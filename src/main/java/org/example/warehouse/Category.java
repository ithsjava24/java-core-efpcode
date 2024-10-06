package org.example.warehouse;

import java.util.Objects;

public class Category {
    private final String categoryName;

    private Category(String categoryName) {
        if (categoryName==null || categoryName.isEmpty() || categoryName.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be null");
        }
        categoryName = categoryName.substring(0, 1).toUpperCase().concat(categoryName.substring(1));



        this.categoryName = categoryName;
    }

    public String getName() {
        return this.categoryName;
    }

    public static Category of (String categoryName) {
        return new Category(categoryName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoryName);
    }
}
