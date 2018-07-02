package main.calm.eCommerce.services.ppp;

import main.calm.eCommerce.model.PPP;
import main.calm.eCommerce.model.Product;
import main.calm.eCommerce.services.Product.ProductService;
import main.calm.eCommerce.services.database.DBService;

import java.util.Scanner;

public class Products_platforms_picesMenu {

    /**
     * Pmethod that gives acess to all functions related to Product_Platform_Prices
     *
     */
    public void controllerPPP() {

        Products_platforms_picesServices example = new Products_platforms_picesServices();

        int index = 0;

        try {
            while (index != 5) {
                System.out.println("Please choice a number between 1-5");
                System.out.println("1-Create insert a new ppp ");
                System.out.println("2-Listing all ppp ");
                System.out.println("3-Deleting a ppp ");
                System.out.println("4-Change a ppp description ");
                System.out.println("5-to Exit this ppp control");

                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine ();

                DBService db = new DBService();
                index = db.checkIfingteger(line);


                switch (index) {
                    case 1:
                        PPP insert = insertPPPuser();
                        example.createPPP(insert.getProduct_id(), insert.getPlatform_id(), insert.getPrice());
                        break;

                    case 2:
                        example.listAllPPP();
                        break;
                    case 3:
                        System.out.println("Please insert the id of the PPP that you want to delete");
                        Scanner scanner1 = new Scanner(System.in);
                        int deleteID = scanner1.nextInt();
                        example.deletePPP(deleteID);
                        break;
                    case 4:
                        System.out.println("Please insert the id of the PPP that you want to delete");
                        Scanner scanner2 = new Scanner(System.in);
                        int updateId = scanner2.nextInt();
                        PPP update = insertPPPuser();
                        example.updatePPP(update.getProduct_id(),update.getPlatform_id(),update.getPrice(), updateId);
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

    /**
     * method to create a new PPLP
     * ask the user all inputs
     * @return
     */
    public PPP insertPPPuser() {

        PPP temp = new PPP();
        Scanner scanner = new Scanner(System.in);

        System.out.println("please input a product_id");
        temp.setProduct_id(scanner.nextInt());
        System.out.println("please input a platform_id");
        temp.setPlatform_id(scanner.nextInt());
        System.out.println("please input the price");
        temp.setPrice(scanner.nextDouble());

        return temp;
    }


}
