package dut.pd3.practics.practic_1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/** Замовлення, створене з вмісту кошика. */
@Getter
public class Order {
    private final List<Product> products;  // Список товарів у замовленні
    private final double totalPrice;       // Загальна вартість
    @Setter
    private String status;                 // Статус: "Нове", "Оплачене", "Відправлене"

    public Order(Cart cart) {
        this.products = new ArrayList<>(cart.getProducts());
        this.totalPrice = cart.getTotalPrice();
        this.status = "Нове";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Замовлення:\n");
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        sb.append(String.format("Загальна вартість: %.2f%n", totalPrice));
        sb.append("Статус: ").append(status);
        return sb.toString();
    }
}
