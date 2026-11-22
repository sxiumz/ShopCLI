package dut.pd3.practics.practic_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Категорії
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Каталог товарів
        List<Product> catalog = List.of(
                new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics),
                new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones),
                new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories)
        );

        Cart cart = new Cart();
        List<Order> orderHistory = new ArrayList<>(); // Історія замовлень

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Видалити товар з кошика");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Історія замовлень");
            System.out.println("7 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = readInt();
            switch (choice) {
                case 1 -> catalog.forEach(System.out::println);
                case 2 -> {
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    Product p = findById(catalog, readInt());
                    if (p == null) System.out.println("Товар з таким ID не знайдено");
                    else {
                        cart.addProduct(p);
                        System.out.println("Додано: " + p.getName());
                    }
                }
                case 3 -> System.out.println(cart);
                case 4 -> {
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    if (cart.removeProductById(readInt())) System.out.println("Товар видалено");
                    else System.out.println("Такого товару немає в кошику");
                }
                case 5 -> {
                    if (cart.isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.add(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                }
                case 6 -> {
                    if (orderHistory.isEmpty()) System.out.println("Історія замовлень порожня.");
                    else for (int i = 0; i < orderHistory.size(); i++) {
                        System.out.println("--- Замовлення №" + (i + 1) + " ---");
                        System.out.println(orderHistory.get(i));
                    }
                }
                case 7 -> {
                    System.out.println("Введіть назву товару або категорії:");
                    String query = scanner.nextLine().trim().toLowerCase();
                    boolean found = false;
                    for (Product p : catalog) {
                        if (p.getName().toLowerCase().contains(query)
                                || p.getCategory().getName().toLowerCase().contains(query)) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Нічого не знайдено");
                }
                case 0 -> {
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                }
                default -> System.out.println("Невідома опція. Спробуйте ще раз.");
            }
        }
    }

    private static Product findById(List<Product> catalog, int id) {
        for (Product p : catalog) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    /** Безпечне читання числа: не падає, якщо ввести текст. */
    private static int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Введіть число:");
            }
        }
    }
}
