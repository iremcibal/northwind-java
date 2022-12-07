package kodlama.io.northwind.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;
}
