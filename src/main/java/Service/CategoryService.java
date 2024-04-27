package Service;

import Converter.ProductConverter;
import dao.Categorydao;
import entity.Category;
import model.CategoryModel;

import java.util.List;

public class CategoryService {

    Categorydao categoryDao = new Categorydao();
    public void create(CategoryModel categoryModel) {
        //Convert it to entity
        Category product = ProductConverter.convertCatToEntity(categoryModel);
        categoryDao.create(product);

    }

    public List<Category> displayAllCategories() {
        return categoryDao.getCategories();
    }


}
