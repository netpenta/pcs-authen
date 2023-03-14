package th.co.pentasol.pcs.authen.entity;

import lombok.Data;
import java.util.Date;

@SuppressWarnings("all")
@Data
public class UserEntity {
    private Long userId;
    private Long roleId;
    private String roleNm;
    private String userName;
    private String userPassword;
    private String factory;
    private String section;
    private String workPlace;
    private String token;
    private Date tokenExpired;
    private String userFname;
    private String userPosition;
    private String userEmail;
    private String userTelno;
    private String userLocale;
    private Integer adminFlg;
    private Date userLastLogin;
    private Date userLastLogout;
    private Integer deletedFlg;
    private Date createdDatetime;
    private String modifiedId;
    private String modifiedBy;
    private Date modifiedDatetime;
    private String programId;
}
