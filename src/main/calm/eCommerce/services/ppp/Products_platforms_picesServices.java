package main.calm.eCommerce.services.ppp;

import main.calm.eCommerce.model.PPP;
import main.calm.eCommerce.services.database.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Products_platforms_picesServices {
    DBService db = new DBService();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;

    /**
     * Method to create a PPP in the table
     * @param product_id
     * @param platform_id
     * @param price
     */
    public void createPPP(int product_id, int platform_id, double price){

        try{
            connection = db.getConnection();

            preparedStatement = connection.prepareStatement( "INSERT INTO `eCommerce`.`products_platforms_pices` (`product_id`, `platform_id`, `price`) VALUES ('?', '?', '?')");

            preparedStatement.setInt(1, product_id);

            preparedStatement.setInt(2, platform_id);

            preparedStatement.setDouble(3, price);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.getStackTrace();

        } finally {
            db.close(preparedStatement, connection);
        }

        System.out.println("ppp has been created");

    }

    /**
     * Method to list all PPPs in the table
     *
     */

    public  void listAllPPP(){

        try{
            connection = db.getConnection();

            statement = connection.createStatement();
            System.out.println("before query");

            resultSet = statement.executeQuery("SELECT * FROM eCommerce.products_platforms_pices;");

            ArrayList<PPP> ppplist = mappingPPP(resultSet);

            for (PPP p : ppplist) {
                System.out.println(p.toString());
            }

        }catch (Exception e){
            e.getStackTrace();
        }finally {
            db.close(statement, connection);
        }

        System.out.println("This is all PPPs");
    }

    /**
     * Support method to list all PPPs
     * @param resultSet
     * @return
     */

    public ArrayList<PPP> mappingPPP(ResultSet resultSet) {

            ArrayList<PPP> result = new ArrayList();
            try {
                while (resultSet.next()) {
                    PPP temp = new PPP(resultSet.getInt("id"),resultSet.getInt("product_id"),resultSet.getInt("platform_id"),
                            resultSet.getDouble("price"));

                    result.add(temp);
                }
            }catch  (Exception e){
               e.getStackTrace();
            }
            return result;

    }

    /**
     * Method to update the PPPs
     * @param product_id
     * @param platform_id
     * @param price
     * @param id
     */

    public void updatePPP(int product_id, int platform_id, double price, int id){
        try{
            connection = db.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE `eCommerce`.`products_platforms_pices` SET `product_id`=? ,`platform_id`= ? , `price`= ? WHERE `id`= ? ;");

            preparedStatement.setInt(1, product_id);

            preparedStatement.setInt(2, platform_id);

            preparedStatement.setDouble(3, price);

            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            System.out.println("PPP updated");

        }catch (Exception e){

            e.getStackTrace();

        } finally {

            db.close(preparedStatement, connection);
        }
    }

    /**
     * method to delete a PPP
     * @param id
     */

    public void deletePPP(int id){
        try{
            connection = db.getConnection();

            preparedStatement = connection.prepareStatement("delete from eCommerce.products_platforms_pices where id = ?;");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            System.out.println("PPP deleted");


        }catch ( Exception e ){

            e.getStackTrace();

        }finally {

            db.close(preparedStatement, connection);

        }

    }

}
