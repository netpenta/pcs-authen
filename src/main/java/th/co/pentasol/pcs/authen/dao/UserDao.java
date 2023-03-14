package th.co.pentasol.pcs.authen.dao;

import th.co.pentasol.pcs.authen.entity.UserEntity;

public interface UserDao {
    UserEntity findByUserName(String userName);

    Integer updateUserLogin(UserEntity data);

    Integer updateUserLogout(UserEntity data);
}
