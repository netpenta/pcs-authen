package th.co.pentasol.pcs.authen.service;

import th.co.pentasol.pcs.authen.configuration.JwtUtils;
import th.co.pentasol.pcs.authen.dao.UserDao;
import th.co.pentasol.pcs.authen.model.LoginModel;
import th.co.pentasol.pcs.authen.model.UserInfo;
import th.co.pentasol.pcs.authen.model.UserModel;
import th.co.pentasol.pcs.authen.util.ApiStatus;
import th.co.pentasol.pcs.authen.util.NumberUtil;
import th.co.pentasol.pcs.authen.util.Util;
import th.co.pentasol.pcs.authen.component.Message;
import th.co.pentasol.pcs.authen.entity.UserEntity;
import th.co.pentasol.pcs.authen.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
@Service
public class AuthenticationService {

    Message message;

    JwtUtils jwtUtils;

    UserDao userDao;

    public AuthenticationService(Message message, JwtUtils jwtUtils, UserDao userDao) {
        this.message = message;
        this.jwtUtils = jwtUtils;
        this.userDao = userDao;
    }

    public UserModel authentication(Locale locale, LoginModel login) throws ServiceException {
        UserEntity user = userDao.findByUserName(login.getUserName());
        System.out.println(Util.generateStrongPasswordHash(login.getPassword()));
        if (Objects.isNull(user) || !Util.validatePassword(login.getPassword(), user.getUserPassword())) {
            throw new ServiceException(ApiStatus.STATUS_BAD_REQUEST, message.getApiMessageWarning("msg.invalid.username.password", locale));
        }

        String token = jwtUtils.generateToken(login.getUserName());
        Date expiredDate = jwtUtils.getExpirationDateFromToken(token);
        user.setToken(token);
        user.setTokenExpired(expiredDate);
        user.setUserLastLogin(new Date());
        user.setProgramId(this.getClass().getName() + ".authentication");
        user.setModifiedId(user.getUserName());
        user.setModifiedDatetime(new Date());
        userDao.updateUserLogin(user);

        return mapResultToModel(user);
    }

    private UserModel mapResultToModel(UserEntity user){
        UserModel model = new UserModel();
        model.setUserId(user.getUserId());
        model.setName(user.getUserFname());
        model.setUserName(user.getUserName());
        model.setEmail(user.getUserEmail());
        model.setRole(user.getRoleNm());
        model.setAdmin(NumberUtil.convertToInteger(user.getAdminFlg()) == 1);
        model.setFactory(user.getFactory());
        model.setPosition(user.getUserPosition());
        model.setSection(user.getSection());
        model.setWorkPlace(user.getWorkPlace());
        model.setTelephone(user.getUserTelno());
        model.setLocale(user.getUserLocale());
        model.setToken(user.getToken());
        model.setTokenExpiredDate(user.getTokenExpired());
        model.setLastLogin(user.getUserLastLogin());
        model.setLastLogout(user.getUserLastLogout());
        return model;
    }

    public Map<String, Object> logout(UserInfo userInfo) throws ServiceException {
        Map<String, Object> result = new LinkedHashMap<>();
        UserEntity userEntity = userDao.findByUserName(userInfo.getUserName());
        if (Objects.isNull(userEntity)) {
            throw new ServiceException(ApiStatus.STATUS_BAD_REQUEST, message.getApiMessageWarning("msg.user.not.found", userInfo.getLocale()));
        }


        userEntity.setProgramId(this.getClass().getName() + ".logout");
        userEntity.setUserLastLogout(new Date());
        userEntity.setModifiedId(userInfo.getUserName());
        userEntity.setModifiedDatetime(userEntity.getUserLastLogout());
        userDao.updateUserLogout(userEntity);

        result.put("name", userEntity.getUserFname());
        result.put("lastLogout", userEntity.getUserLastLogout());
        return result;
    }
}
