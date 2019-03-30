package fm.product.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by ngocson on 27/03/2019
 */
@Data
public class ProductDTO {
    private String productID;
    private String name;
    private String date;

    List<DetailEmployeeDTO> employeeDTOList;
}
