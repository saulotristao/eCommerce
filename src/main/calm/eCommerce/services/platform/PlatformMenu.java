package main.calm.eCommerce.services.platform;

import main.calm.eCommerce.model.Platform;

import java.util.Scanner;

public class PlatformMenu {


    public void controllerPlatform(){

        int index3 = 0;
        PlatformService example3 = new PlatformService();

        try {
            while (index3 != 5) {
                System.out.println("Please choice a number between 1-5");
                System.out.println("1-Create insert a new platform ");
                System.out.println("2-Listing all platforms ");
                System.out.println("3-Deleting a platform ");
                System.out.println("4-Updating a platform ");
                System.out.println("5- to Exit this platform control");

                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();

                while (true) {
                    if (line.length() == 1) {
                        try {
                            index3 = Integer.parseInt(line);
                            break;
                        } catch (NumberFormatException e) {
                            // do nothing.
                        }
                    }
                    System.out.println("Error!(" + line + ") Please enter a single digit. ");
                    line = scanner.nextLine();
                }


                switch (index3) {
                    case 1:
                        Platform input = insertPlatform();
                        example3.createNewPlatformDB( input.getName(),input.getUrl(), input.getSales_fee());
                        break;
                    case 2:
                        example3.listingAllPlatforms();
                        System.out.println("all platforms listed");
                        break;
                    case 3:
                        example3.deletingPlatform(5);
                        System.out.println("____________");
                        break;
                    case 4:
                        System.out.println("Please input the id of the platform");
                        int id3 = scanner.nextInt();
                        Platform modify = insertPlatform();
                        example3.updatingPlaform(id3, modify.getName(),modify.getUrl(), modify.getSales_fee());
                        System.out.println("_______________");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        index3 = 5;
                        break;

                    default:
                        System.out.println("please enter a number between 1-5");
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public Platform insertPlatform (){
        Platform result;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the name of the platform");
        String name =scanner.next();

        System.out.println("Please input the url of the platform");
        String url =scanner.next();

        System.out.println("Please input the sales_fee of the platform");
        double sales_fee = scanner.nextDouble();

        result = new Platform (name,url,sales_fee);

        return result;

    }
}
