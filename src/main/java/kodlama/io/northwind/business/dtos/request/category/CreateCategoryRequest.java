package kodlama.io.northwind.business.dtos.request.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {
    private int categoryId;
    private String categoryName;
    private String description;

}
