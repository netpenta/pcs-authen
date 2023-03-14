package th.co.pentasol.pcs.authen.controller;

import th.co.pentasol.pcs.authen.model.LoginModel;
import th.co.pentasol.pcs.authen.model.api.ApiResponse;
import th.co.pentasol.pcs.authen.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.pentasol.pcs.authen.service.AuthenticationService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@SuppressWarnings("ALL")
@Slf4j
@RestController
@RequestMapping("v1/authen")
public class AuthenController extends AbsController{
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponse> login(HttpServletRequest request, @Valid @RequestBody LoginModel data) throws ServiceException {
        return responseOK(authenticationService.authentication(request.getLocale(), data));
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<ApiResponse> logout(HttpServletRequest request) throws Exception{
        return responseOK(authenticationService.logout(userService.getUserInfo(request)), message.getApiMessageInfo("msg.logout.success", request.getLocale()));
    }
}
