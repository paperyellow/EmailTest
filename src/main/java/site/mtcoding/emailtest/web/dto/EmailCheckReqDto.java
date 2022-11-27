package site.mtcoding.emailtest.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailCheckReqDto {

    @Size(min = 2, max = 20)
    @NotBlank
    private String username;

    @Size(min = 4, max = 20)
    @NotBlank
    private String email;

    @Size(min = 4, max = 20)
    @NotBlank
    private String emailConfirm;

}
