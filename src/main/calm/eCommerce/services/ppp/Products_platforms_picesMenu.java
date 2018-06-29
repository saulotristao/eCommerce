package main.calm.eCommerce.services.ppp;

import main.calm.eCommerce.model.Product;
import main.calm.eCommerce.services.Product.ProductService;
import main.calm.eCommerce.services.database.DBService;

import java.util.Scanner;

public class Products_platforms_picesMenu {

    private void controllerPPP() {

        Products_platforms_picesMenu example = new Products_platforms_picesMenu();

        int index = 0;

        try {
            while (index != 5) {
                System.out.println("Please choice a number between 1-5");
                System.out.println("1-Create insert a new ppp ");
                System.out.println("2-Listing all ppp ");
                System.out.println("3-Deleting a pp ");
                System.out.println("4-Change a pp description ");
                System.out.println("5-to Exit this ppp control");

                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine ();

                DBService db = new DBService();
                index = db.checkIfingteger(line);


                switch (index) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

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


}
