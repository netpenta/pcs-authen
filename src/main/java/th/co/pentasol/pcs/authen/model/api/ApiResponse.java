package th.co.pentasol.pcs.authen.model.api;

import lombok.Data;
import th.co.pentasol.pcs.authen.util.ApiStatus;
import java.util.Date;

@Data
public class ApiResponse {
    public static final String VERSION = "0.0.1";
    private Date timestamp;
    private int status;
    private String error;
    private ApiMessage messages;
    private String path;
    private Object data;



    public ApiResponse() {
        this.timestamp = new Date();
        this.status = ApiStatus.STATUS_OK;
        this.error = "";
        this.path = "";
    }

    public ApiResponse(Object data) {
        this.timestamp = new Date();
        this.status = ApiStatus.STATUS_OK;
        this.error = "";
        this.path = "";
        this.data = data;
    }
}
