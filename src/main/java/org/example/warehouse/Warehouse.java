package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    String name;
    private final List<ProductRecord> addedProducts = new ArrayList<>();
    private final List<ProductRecord> changedProducts = new ArrayList<>();

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
        return addedProducts;
    }

    public List<ProductRecord> getChangedProducts() {
        return changedProducts;
    }

    public ProductRecord addProduct(UUID UUID_value, String UUID_Name, Category category, BigDecimal bigDecimal){
        var product = new ProductRecord(UUID_value, UUID_Name, category, bigDecimal);
        addedProducts.add(product);
        return product;
    }

   // public Optional<ProductRecord> getProductById(UUID uuid_value){
   //     for (ProductRecord product : getProducts()) {
   //         if(product.UUID_value().equals(uuid_value)){
   //             return Optional.of(product);
   //         }
   //     }
   //     return Optional.empty();

   // }

    public List<ProductRecord> getProductById(UUID uuid_value) {
        return getProducts()
                .stream()
                .filter(product -> product.uuid() == uuid_value).toList();
    }

    public void updateProductPrice(UUID UUID_value, BigDecimal bigDecimal){
        for (ProductRecord product : getProducts()) {
            if (product.UUID_value().equals(UUID_value)) {
                changedProducts.add(product);


                getProducts()
                        .stream()
                        .filter(item -> item.UUID_value().equals(UUID_value))
                        .toList()
                        .getFirst()
                        .setBigDecimal(bigDecimal);
            }
        }


    }


}
