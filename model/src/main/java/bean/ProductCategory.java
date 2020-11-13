package bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author sunxiaoyu3
 * @description 商品试题类
 * @createTime 2020/11/05 19:13:00
 */
@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class ProductCategory {
    /**
     * 类别id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类别名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 类别编号
     */
    @Column(name = "category_type")
    private Integer categoryType;

    public ProductCategory() {
    }


    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
