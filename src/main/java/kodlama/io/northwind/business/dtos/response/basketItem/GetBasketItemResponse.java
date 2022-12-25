package kodlama.io.northwind.business.dtos.response.basketItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBasketItemResponse {
    private int basketItemId;
    private int basketBasketId;
    private int productId;
}
