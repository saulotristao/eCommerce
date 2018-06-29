package main.calm.eCommerce;

import main.calm.eCommerce.services.Product.ProductMenu;
import main.calm.eCommerce.services.database.DBService;
import main.calm.eCommerce.services.platform.PlatformMenu;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        int index2 = 0;
        Controller example2 = new Controller();

        try {
            while (index2 != 4) {
                System.out.println("Please choice a number between 1-3");
                System.out.println("1-To modify product ");
                System.out.println("2-To modify platforms ");
                System.out.println("3-To modify ppp ");
                System.out.println("4-To Exit ");

                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine ();

                DBService dbService = new DBService();
                index2 = dbService.checkIfingteger(line);

                switch (index2) {
                    case 1:
                        System.out.println("entering in product control... ");
                        ProductMenu productMenu = new ProductMenu();
                        productMenu.menuProduct();
                        break;
                    case 2:
                        System.out.println("entering in platform control... ");
                        PlatformMenu platformMenu = new PlatformMenu();
                        platformMenu.controllerPlatform();
                        break;
                    case 3:
                        System.out.println("entering in ppp control ");
                        example2.controllerPPP();
                        break;
                    case 4:
                        System.out.println("Exiting ");
                        index2=4;
                        break;
                    default:
                        System.out.println("Please insert a number between 1-4");
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }



}