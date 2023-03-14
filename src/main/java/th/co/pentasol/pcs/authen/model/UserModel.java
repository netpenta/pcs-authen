package th.co.pentasol.pcs.authen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class UserModel {
    private Long userId;
    private String userName;
    private String name;
    private String role;
    private String position;
    private String factory;
    private String section;
    private String workPlace;
    private String telephone;
    private String email;
    private String locale;
    private boolean admin;
    private String token;
    private Date tokenExpiredDate;
    private Date lastLogin;
    private Date lastLogout;
}
