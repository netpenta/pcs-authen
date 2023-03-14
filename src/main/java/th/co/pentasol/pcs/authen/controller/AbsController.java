package th.co.pentasol.pcs.authen.controller;

import lombok.extern.slf4j.Slf4j;
import th.co.pentasol.pcs.authen.component.Message;
import th.co.pentasol.pcs.authen.model.api.ApiMessage;
import th.co.pentasol.pcs.authen.model.api.ApiResponse;
import th.co.pentasol.pcs.authen.model.api.ApiResponseWithPage;
import th.co.pentasol.pcs.authen.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import th.co.pentasol.pcs.authen.service.UserService;


@SuppressWarnings("all")
@Slf4j
public class AbsController{

    @Autowired
    UserService userService;
    @Autowired
    Message message;

    public ResponseEntity<ApiResponse> responseOK(Object data){
        ApiResponse apiResponse = new ApiResponse(data);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> responseOK(ApiMessage message){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessages(message);
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> responseOK(Object data, ApiMessage message){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessages(message);
        apiResponse.setData(data);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseWithPage> responseOK(Object data, Long totalRecords, Integer pageNo, Integer pageSize){
        ApiResponseWithPage apiResponse = new ApiResponseWithPage();
        apiResponse.setCurrentPage(pageNo);
        apiResponse.setPageSize(pageSize);
        apiResponse.setTotalPage(Util.calculateTotalPage(totalRecords, pageSize));
        apiResponse.setTotalRecord(totalRecords.intValue());
        apiResponse.setData(data);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
