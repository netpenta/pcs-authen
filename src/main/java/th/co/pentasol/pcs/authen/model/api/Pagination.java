package th.co.pentasol.pcs.authen.model.api;

import lombok.Data;

import java.util.List;

@Data
public class Pagination {
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private List<String> sortByList;
    private String sortOrder;
}
