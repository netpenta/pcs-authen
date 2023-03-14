package th.co.pentasol.pcs.authen.model.api;

import lombok.Data;
import th.co.pentasol.pcs.authen.util.ApiStatus;
import java.util.List;

@Data
public class ApiFileResponse {
	private String version;
	private int status;
	private ApiMessage messages;
	private List<FileResponse> files;

	public ApiFileResponse() {
		this.status = ApiStatus.STATUS_OK;
		this.version = "0.0.1";
	}
}
