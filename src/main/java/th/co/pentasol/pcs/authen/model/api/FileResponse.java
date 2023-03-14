package th.co.pentasol.pcs.authen.model.api;

import lombok.Data;

@Data
public class FileResponse {
    private String fileType;
    private String fileName;
    private String filePath;
    private byte[] file;
}
