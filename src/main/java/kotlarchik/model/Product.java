package kotlarchik.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Cost", nullable = false)
    private int cost;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "MainImagePath", nullable = false)
    private String mainImagePath;

    @Column(name = "IsActive", nullable = false)
    private int isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ManufacturerID")
    private Manufact manufact;

    @OneToMany(mappedBy = "ProductID", fetch = FetchType.EAGER)
    private Set<ProductSale> productSales;
}
