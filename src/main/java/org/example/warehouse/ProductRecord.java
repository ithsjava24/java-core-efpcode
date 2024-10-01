package org.example.warehouse;
import java.math.BigDecimal;
import java.util.UUID;


public record ProductRecord (UUID UUID_value, String UUID_Name, Category category, BigDecimal bigDecimal) {

    public static ProductRecord of(UUID UUID_value, String UUID_Name, Category category, BigDecimal bigDecimal) {
        return new ProductRecord(UUID_value, UUID_Name, category, bigDecimal);
    }

    public UUID uuid() {
        if(UUID_value == null) {
            return UUID.randomUUID();
        }
        return UUID_value;
    }


    public BigDecimal price() {
        if(bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        return bigDecimal;
    }


}