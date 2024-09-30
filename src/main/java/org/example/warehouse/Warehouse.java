package org.example.warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Warehouse {
    String name;
    private final List<ProductRecord> products = new ArrayList<>();

    private Warehouse() {

    }

    private Warehouse(String name) {
        this.name = name;
    }





    public static Warehouse getInstance(String name) {
        return new Warehouse(name);

    }

    public static Warehouse getInstance() {
        return new Warehouse();

    }

    public boolean isEmpty() {
        return this.name == null || this.name.isEmpty();
    }

    public List<ProductRecord> getProducts() {
        return products;
    }

    public ProductRecord addProduct(UUID UUID_value, String UUID_Name, Category category, BigDecimal bigDecimal){
        var product = new ProductRecord(UUID_value, UUID_Name, category, bigDecimal);
        products.add(product);
        return product;
    }


}
