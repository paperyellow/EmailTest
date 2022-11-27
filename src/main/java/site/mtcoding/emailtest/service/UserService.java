package site.mtcoding.emailtest.service;

import org.springframework.stereotype.Service;

import site.mtcoding.emailtest.domian.user.Users;
import site.mtcoding.emailtest.domian.user.UserRepository;
import site.mtcoding.emailtest.web.dto.JoinReqDto;
import site.mtcoding.emailtest.web.dto.LoginReqDto;
import site.mtcoding.emailtest.web.dto.EmailCheckReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void 회원가입(JoinReqDto dto) {
        userRepository.save(dto.toEntity());

    }

    public Users 로그인(LoginReqDto dto) {
        Users userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
        return userEntity;
    }

    public Users 이메일인증확인(EmailCheckReqDto dto) {
        Users userEntity = userRepository.mCheck(dto.getUsername(), dto.getEmailConfirm());
        return userEntity;
    }

    public void 이메일인증업데이트(EmailCheckReqDto dto) {
        userRepository.mUpdate(dto.getUsername());
    }
}
