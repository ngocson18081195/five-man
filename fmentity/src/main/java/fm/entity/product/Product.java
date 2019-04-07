package fm.entity.product;

import fm.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create by ngocson on 23/03/2019
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;
}
