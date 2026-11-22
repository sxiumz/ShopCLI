package dut.pd3.practics.practic_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** Категорія товару. Lombok генерує конструктор, геттери та сеттери. */
@Getter
@Setter
@AllArgsConstructor
public class Category {
    private int id;       // Унікальний ідентифікатор категорії
    private String name;  // Назва категорії

    @Override
    public String toString() {
        return "Категорія{id=" + id + ", назва='" + name + "'}";
    }
}
