package kodlama.io.northwind.business.dtos.response.basket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListBasketResponse {
    private int basketId;
    private int totalCost;
    private String customerId;
}
