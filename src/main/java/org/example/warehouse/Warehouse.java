package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

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

    public Optional<ProductRecord> getProductById(UUID uuid_value){
        for (ProductRecord product : getProducts()) {
            if(product.equals(uuid_value)){
                return Optional.of(product);
            }
        }
        return Optional.empty();

    }

    public void updateProductPrice(UUID UUID_value, BigDecimal bigDecimal){
        Optional<ProductRecord> product = getProductById(UUID_value);
        ProductRecord oldProduct = ProductRecord.of(product.get().UUID_value(), product.get().UUID_Name(), product.get().category(), product.get().bigDecimal());
        ProductRecord updateProduct = ProductRecord.of(product.get().UUID_value(), product.get().UUID_Name(),product.get().category(), bigDecimal);
        int index = getProducts().indexOf(oldProduct);
        getProducts().set(index, updateProduct);


    }


}
