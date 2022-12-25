package kodlama.io.northwind.business.dtos.request.basketItem;

import kodlama.io.northwind.entities.concretes.Basket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBasketItemRequest {
    private int basketItemId;
    private int basketBasketId;
    private int productId;
}
