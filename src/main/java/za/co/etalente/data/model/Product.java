package za.co.etalente.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENT_BALANCE")
    private Double currentBalance;
}
