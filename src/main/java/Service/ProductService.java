package Service;

import Converter.ProductConverter;
import dao.Productdao;
import entity.Product;
import model.ProductModel;

import java.util.List;

public class ProductService {

    Productdao productdao = new Productdao();
    public void create(ProductModel productModel) {
        //Convert it to entity
        Product product = ProductConverter.convertToEntity(productModel);
        productdao.create(product);

    }

    public List<Product> displayAllProducts() {
        return productdao.getProducts();
    }

    //public List<Product> getAllProducts() {
        //return productdao.getAllProducts();

}
