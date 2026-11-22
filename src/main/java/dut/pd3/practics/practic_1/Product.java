package dut.pd3.practics.practic_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** Товар. Конструктор, геттери та сеттери генеруються Lombok. */
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int id;               // Унікальний ідентифікатор товару
    private String name;          // Назва товару
    private double price;         // Ціна товару
    private String description;   // Опис товару
    private Category category;    // Категорія товару

    @Override
    public String toString() {
        return "Товар{id=" + id +
                ", назва='" + name + '\'' +
                ", ціна=" + price +
                ", опис='" + description + '\'' +
                ", категорія='" + category.getName() + "'}";
    }
}
