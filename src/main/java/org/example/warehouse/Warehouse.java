package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private final String name;
    private static final List<Warehouse> addedWarehouses = new ArrayList<>();
    private final List<ProductRecord> addedProducts = new ArrayList<>();
    private final List<ProductRecord> changedProducts = new ArrayList<>();

    private Warehouse() {
        this.name = null;

    }

    private Warehouse(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Warehouse getInstance(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Warehouse name cannot be null");
        }

        var warehouseObj = addedWarehouses.stream()
                .filter(warehouse -> warehouse.name.equals(name))
                .findFirst();
        if (warehouseObj.isPresent()) {
            return warehouseObj.get();
        }
        var newWarehouse = new Warehouse(name);
        addedWarehouses.add(newWarehouse);
        return newWarehouse;


    }

    public static Warehouse getInstance() {
        return new Warehouse();

    }

    public boolean isEmpty() {
        return addedProducts.isEmpty();
    }

    public List<ProductRecord> getProducts() {
        return Collections.unmodifiableList(addedProducts);
    }

    public List<ProductRecord> getChangedProducts() {
        return Collections.unmodifiableList(changedProducts);
    }

    public ProductRecord addProduct(UUID UUID_value, String UUID_Name, Category category, BigDecimal bigDecimal) {
        var item = getProductById(UUID_value);

        if (item.isPresent()) {
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
        }

        var product = new ProductRecord(UUID_value, UUID_Name, category, bigDecimal);
        addedProducts.add(product);
        return product;
    }

    public Optional<ProductRecord> getProductById(UUID uuid_value) {
        if (uuid_value == null) {
            return Optional.empty();
        }

        return getProducts().stream()
                .filter(p -> p.UUID_value().equals(uuid_value))
                .findFirst();

    }

    public void updateProductPrice(UUID UUID_value, BigDecimal bigDecimal) {
        var product = getProducts().stream().filter(p -> p.UUID_value().equals(UUID_value)).findFirst();
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product with that id doesn't exist.");
        }
        changedProducts.add(product.get());
        getProducts()
                .stream()
                .filter(item -> item.UUID_value().equals(UUID_value))
                .findFirst()
                .ifPresent(item -> item.setPrice(bigDecimal));


    }


    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return getProducts().stream()
                .collect(Collectors.groupingBy(ProductRecord::category));
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories(Category category) {
        return getProducts().stream()
                .filter(p -> p.category().getName().equals(category.getName()))
                .collect(Collectors.groupingBy(ProductRecord::category));
    }

    public List<ProductRecord> getProductsBy(Category category) {
        Map<Category, List<ProductRecord>> productsGroupedByCategories = getProductsGroupedByCategories(category);
        return productsGroupedByCategories.entrySet()
                .stream()
                .filter(e -> e.getKey().getName().equals(category.getName()))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse warehouse)) return false;
        return Objects.equals(name, warehouse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}