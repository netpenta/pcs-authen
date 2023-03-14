package th.co.pentasol.pcs.authen.model;

import lombok.Data;

import java.util.Locale;

@Data
public class UserInfo {
    private Long userId;
    private String userName;
    private Locale locale;
    private String ipAddress;
}
