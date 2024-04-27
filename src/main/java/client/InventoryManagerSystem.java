package client;
import Service.CategoryService;
import Service.ProductService;
import entity.Category;
import entity.Product;
import model.CategoryModel;
import model.ProductModel;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class InventoryManagerSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choices;
        do {
            System.out.println("Inventory Managment System");
            System.out.println("1.Add product ");
            System.out.println("2.Display all product ");
            System.out.println("3.Notify for low stock product ");
            System.out.println("4.Add category ");
            System.out.println("5.Display all category ");
            choices = sc.nextInt();
            switch (choices) {
                case 1:
                    createProduct(sc);
                    break;
                case 2:
                    displayAllProducts();
                case 3:
                    notifyforlowstock();
                case 4 :
                    addcategory(sc);
                case 5:
                    displayallcategory();

            }
        }while (choices != 6);
    }

    private static void displayallcategory() {
        CategoryService categoryService = new CategoryService();
        DateTimeFormatter outputDtf = DateTimeFormatter.ofPattern("EEEE, dd 'of' MMMM uuuu",
                Locale.ENGLISH);
        System.out.println(String.format("%-10s%-10s", "Name", "Created At"));
        for (Category p:categoryService.displayAllCategories()) {
            System.out.println(String.format("%-10s%-10s", p.getName(),
                    p.getCreateAt().format(outputDtf)));
        }

    }

    private static void addcategory(Scanner sc) {
        System.out.println("Ju lutem fusni emrin kategorise");
        CategoryModel model = new CategoryModel();
        model.setName(sc.next());
        CategoryService categoryService = new CategoryService();
        categoryService.create(model);

    }

    private static void notifyforlowstock() {

    }

    private static void displayAllProducts() {
        ProductService productService = new ProductService();
        DateTimeFormatter outputDtf = DateTimeFormatter.ofPattern("EEEE, dd 'of' MMMM uuuu",
                Locale.ENGLISH);
        System.out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-10s", "Name", "Description ",
                "Price", "Quantity", "Category", "CreateAt"));
        for (Product p:productService.displayAllProducts()) {
            System.out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-10s", p.getName(), p.getDescription(),
                    p.getPrice(), p.getQuantity(), p.getCategory().getName() + " ", p.getCreateAt().format(outputDtf)));

        }
    }

    public static void createProduct(Scanner scanner) {
        System.out.println("Ju lute fusni te dhenat per produktin");
        System.out.println("Ju lutem fusni emrin e produktit");
        String name = scanner.next();
        System.out.println("Ju lutem fusni pershkrimi e produktit");
        String description=" ";
        description= scanner.nextLine();
        description+=scanner.nextLine();
        System.out.println("Ju lutem fusni cmimin e produktit");
        Double price = scanner.nextDouble();
        System.out.println("Ju lutem fusni sasine e produktit");
        Integer quantity = scanner.nextInt();
        System.out.println("Ju lutem fusni kategorine");
        Long categoryId = scanner.nextLong();

        ProductModel productModel = new ProductModel();
        productModel.setDescription(description);
        productModel.setName(name);
        productModel.setQuantity(quantity);
        productModel.setPrice(price);
        productModel.setCategoryId(categoryId);

        ProductService productService = new ProductService();
        productService.create(productModel);
    }
}
