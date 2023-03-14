package th.co.pentasol.pcs.authen.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiMessage {
    private String type;
    private String message;
    private List<String> messageList;
}
