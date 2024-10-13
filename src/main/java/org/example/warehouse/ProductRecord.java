package org.example.warehouse;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record ProductRecord(UUID UUID_value, String UUID_Name, Category category, BigDecimal price) {

    public ProductRecord {
        if (UUID_Name == null || UUID_Name.isEmpty() || UUID_Name.isBlank()) {
            throw new IllegalArgumentException("Product name can't be null or empty.");
        }

        if (category == null || category.getName() == null || category.getName().isEmpty() || category.getName().isBlank()) {
            throw new IllegalArgumentException("Category can't be null.");
        }

    }

    public UUID uuid() {
        if (UUID_value == null) {
            return UUID.randomUUID();
        }
        return UUID_value;
    }


    public BigDecimal price() {
        if (price == null) {
            return BigDecimal.ZERO;
        }
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ProductRecord) obj;
        return Objects.equals(this.UUID_value, that.UUID_value) &&
                Objects.equals(this.UUID_Name, that.UUID_Name) &&
                Objects.equals(this.category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID_value, UUID_Name, category, price);
    }

    @Override
    public String toString() {
        return "ProductRecord[" +
                "UUID_value=" + UUID_value + ", " +
                "UUID_Name=" + UUID_Name + ", " +
                "category=" + category + ", " +
                "bigDecimal=" + price + ']';
    }


}
