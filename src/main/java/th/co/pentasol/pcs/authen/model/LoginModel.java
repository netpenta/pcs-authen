package th.co.pentasol.pcs.authen.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class LoginModel {
    @NotBlank(message = "{msg.required.username}")
    private String userName;
    @NotBlank(message = "{msg.required.password}")
    private String password;
}
