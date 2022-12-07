package kodlama.io.northwind.entities.concretes;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "units_on_order")
    private int unitsOnOrder;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column(name = "discontinued")
    private int discontinued;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
