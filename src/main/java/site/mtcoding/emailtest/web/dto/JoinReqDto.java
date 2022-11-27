package site.mtcoding.emailtest.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.mtcoding.emailtest.domian.user.Users;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinReqDto {
    @Size(min = 2, max = 20)
    @NotBlank
    private String username;

    @Size(min = 4, max = 20)
    @NotBlank
    private String password;

    @Size(min = 4, max = 50)
    @NotBlank
    private String email;

    private String emailConfirm = "confirmNot";

    public Users toEntity() {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setEmailConfirm(emailConfirm);
        return user;
    }

}
