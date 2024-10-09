package org.example.warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        List<ProductRecord> addedProducts = new ArrayList<>();
        ProductRecord addedProduct;
        UUID UUID_milk;
        UUID_milk = UUID.randomUUID();


        Warehouse warehouse = Warehouse.getInstance("test");
        addedProduct = warehouse.addProduct(UUID_milk, "Milk", Category.of("Dairy"), BigDecimal.valueOf(999, 2));

        Warehouse warehouse2 = Warehouse.getInstance();
        addedProducts.add(warehouse2.addProduct(UUID.randomUUID(), "Milk", Category.of("Dairy"), BigDecimal.valueOf(999, 2)));
        addedProducts.add(warehouse2.addProduct(UUID.randomUUID(), "Apple", Category.of("Fruit"), BigDecimal.valueOf(290, 2)));
        addedProducts.add(warehouse2.addProduct(UUID.randomUUID(), "Bacon", Category.of("Meat"), BigDecimal.valueOf(1567, 2)));

        addedProducts.forEach(System.out::println);
        System.out.println();

        warehouse2.updateProductPrice(addedProducts.get(1).uuid(), BigDecimal.valueOf(311, 2));

        warehouse2.getProducts().forEach(item -> System.out.println(item.price()));
        System.out.println();
        addedProducts.forEach(System.out::println);


    }
}
