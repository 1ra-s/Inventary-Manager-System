package Converter;

import entity.Category;
import entity.Product;
import model.CategoryModel;
import model.ProductModel;


public class ProductConverter {

    public static Product convertToEntity(ProductModel model) {
        Product product = new Product();
        product.setName(model.getName());
        product.setDescription(model.getDescription());
        product.setPrice(model.getPrice());
        product.setQuantity(model.getQuantity());
        product.setCategory(new Category(model.getCategoryId()));

        return product;
    }

    public static Category convertCatToEntity(CategoryModel categoryModel) {
        Category category = new Category();
        category.setName(categoryModel.getName());
        return category;
    }
}
