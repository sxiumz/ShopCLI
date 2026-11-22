package dut.pd3.practics.practic_1;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/** Кошик. Порожній конструктор генерує Lombok (@NoArgsConstructor). */
@NoArgsConstructor
public class Cart {
    // Ініціалізація поля одразу, тому @NoArgsConstructor достатньо
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product); // видаляє одну появу товару
    }

    /** Видалення за ID. Повертає true, якщо товар був у кошику. */
    public boolean removeProductById(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    /** Копія списку, щоб запобігти змінам ззовні. */
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void clear() {
        products.clear();
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        sb.append(String.format("Загальна вартість: %.2f", getTotalPrice()));
        return sb.toString();
    }
}
