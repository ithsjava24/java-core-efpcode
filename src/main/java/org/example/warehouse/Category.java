package org.example.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final public class Category {
    private final String categoryName;
    private final static List<Category> categoryList = new ArrayList<>();

    private Category(String categoryName) {
        if (categoryName==null || categoryName.isEmpty() || categoryName.isBlank()) {
            throw new IllegalArgumentException("Category name can't be null");
        }
        categoryName = categoryName.substring(0, 1).toUpperCase().concat(categoryName.substring(1));

        this.categoryName = categoryName;
    }

    public String getName() {
        return this.categoryName;
    }

    public static Category of (String categoryName) {
        var category =
                categoryList.stream()
                        .filter(c -> c.getName().equals(categoryName))
                        .findFirst();
        if (category.isPresent()) {
            return category.get();
        }
        var newCategory = new Category(categoryName);
        categoryList.add(newCategory);

        return newCategory;

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
