package hello.itemservice.domain.item;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

@Data
//@ScriptAssert(lang = "javascript",script = "_this.price * _this.quantity >= 100000", message = "총합이 10000원 넘게 입력해 주세요")
public class Item {

//    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
    private Long id;
//    @NotBlank(groups = {UpdateCheck.class, SaveCheck.class})
    private String itemName;
//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class})
//    @Range(min=1000,max = 1000000)
    private Integer price;
//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class})
//    @Max(value = 9999,groups = {SaveCheck.class}) // 수정 요구사항 추가
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
