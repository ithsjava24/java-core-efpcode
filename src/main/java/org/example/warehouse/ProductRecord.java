package org.example.warehouse;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;


public final class ProductRecord {
    private final UUID UUID_value;
    private final String UUID_Name;
    private final Category category;
    private BigDecimal bigDecimal;


    public ProductRecord(UUID UUID_value, String UUID_Name, Category category, BigDecimal bigDecimal) {
        this.UUID_value = UUID_value;
        this.UUID_Name = UUID_Name;
        this.category = category;
        this.bigDecimal = bigDecimal;
    }


    public UUID uuid() {
        if (UUID_value == null) {
            return UUID.randomUUID();
        }
        return UUID_value;
    }


    public BigDecimal price() {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        return bigDecimal;
    }


    public void setBigDecimal(BigDecimal bigDecimal){
        this.bigDecimal = bigDecimal;
    }



    public BigDecimal getBigDecimal() {
        return price();
    }

    public UUID UUID_value() {
        return UUID_value;
    }

    public String UUID_Name() {
        return UUID_Name;
    }

    public Category category() {
        return category;
    }

    public BigDecimal bigDecimal() {
        return bigDecimal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ProductRecord) obj;
        return Objects.equals(this.UUID_value, that.UUID_value) &&
                Objects.equals(this.UUID_Name, that.UUID_Name) &&
                Objects.equals(this.category, that.category) &&
                Objects.equals(this.bigDecimal, that.bigDecimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID_value, UUID_Name, category, bigDecimal);
    }

    @Override
    public String toString() {
        return "ProductRecord[" +
                "UUID_value=" + UUID_value + ", " +
                "UUID_Name=" + UUID_Name + ", " +
                "category=" + category + ", " +
                "bigDecimal=" + bigDecimal + ']';
    }


}