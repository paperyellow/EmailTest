package site.mtcoding.emailtest.test;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.mtcoding.emailtest.domian.user.Users;
import site.mtcoding.emailtest.service.EmailService;
import site.mtcoding.emailtest.service.UserService;
import site.mtcoding.emailtest.web.dto.JoinReqDto;
import site.mtcoding.emailtest.web.dto.EmailCheckReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PageControllerTest {
    private final HttpSession session;
    private final UserService userService;
    private final EmailService emailService;

    @GetMapping("/board/imageForm")
    public String imageForm() {
        return "board/imageForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(@Valid JoinReqDto dto, Model model) {
        userService.회원가입(dto);

        session.setAttribute("principal", dto);
        return "redirect:/joinConfirm";
    }

    @GetMapping("/joinConfirm")
    public String joinConfirm() {

        return "user/joinConfirm";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping(value = "/user/email/send")
    public void sendmail(EmailCheckReqDto dto) throws MessagingException {

        StringBuffer emailcontent = new StringBuffer();

        emailcontent.append("<!DOCTYPE html>");
        emailcontent.append("<html>");
        emailcontent.append("<head>");
        emailcontent.append("</head>");
        emailcontent.append("<body>");
        emailcontent.append(
                " <div>" +
                        dto.getUsername() +
                        "		님 안녕하세요.<br />" +
                        "		아래 메일 인증 버튼을 클릭하여 회원가입을 완료해 주세요.<br />" +
                        "		감사합니다.<br />" +
                        "	<a" +
                        "	href=\"http://localhost:8000/user/email/certified?username=" + dto.getUsername()
                        + "&emailConfirm=" + dto.getEmailConfirm() + "\" target=\"_blank\">" +
                        "		<button> 메일 인증 </button>" +
                        "	</a>" +
                        " </div>");
        emailcontent.append("</body>");
        emailcontent.append("</html>");

        emailService.sendEmail(dto.getEmail(), "메일 인증", emailcontent.toString());
    }

    @GetMapping(value = "/user/email/certified")
    public String checkmail(EmailCheckReqDto dto) throws MessagingException {

        Users u = userService.이메일인증확인(dto);

        if (u != null) {
            userService.이메일인증업데이트(dto);
            session.invalidate(); // 로그아웃
        } else {
            System.out.println("실패");
        }

        return "user/emailSuccess";
    }
}
