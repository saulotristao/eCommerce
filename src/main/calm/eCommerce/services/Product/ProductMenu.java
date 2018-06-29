package main.calm.eCommerce.services.Product;

import main.calm.eCommerce.Controller;
import main.calm.eCommerce.model.Product;

import java.util.Scanner;

public class ProductMenu {

    public void menuProduct(){

        ProductService example = new ProductService();
        int index = 0;

        try {
            while (index != 5) {
                System.out.println("Please choice a number between 1-5");
                System.out.println("1-Create insert a new product in the products ");
                System.out.println("2-Listing all products ");
                System.out.println("3-Deleting a product ");
                System.out.println("4-Change a product description ");
                System.out.println("5- to Exit this platform control");

                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine ();

                while (true) {
                    if (line.length () == 1) {
                        try {
                            index = Integer.parseInt (line);
                            break;
                        }
                        catch (NumberFormatException e) {
                            // do nothing.
                        }
                    }
                    System.out.println ("Error!(" + line + ") Please enter a single digit. ");
                    line = scanner.nextLine ();
                }


                switch (index) {
                    case 1:
                        Product input = inputProduct();
                        example.createNewProductInDB(input.getP_name(), input.getP_description());
                        System.out.println("product inserted");
                        System.out.println();
                        break;
                    case 2:
                        example.listingAllProducts();
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("please enter the id of the product you want to delete");
                        int id = scanner.nextInt();
                        example.deletingAProduct(id);
                        System.out.println("product deleted");
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("please enter the id of the product you want to change");
                        id = scanner.nextInt();
                        Product modify = inputProduct();
                        example.updatingAProdcuct(id, modify.getP_name(), modify.getP_description());
                        System.out.println("product changed ");
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        index = 5;
                        break;

                    default:
                        System.out.println("please enter a number between 1-5");
                }
            }

        } catch (Exception e) {
            System.out.println("error in readDateBase()" + e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public Product inputProduct(){
        Product result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the name of the product");
        String productname = scanner.next();
        System.out.println("Please insert the product description");
        String productdescription = scanner.next();
        result = new Product(productname, productdescription);
        return result;
    }
}
