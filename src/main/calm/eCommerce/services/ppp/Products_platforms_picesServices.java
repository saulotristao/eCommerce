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

    public  void listAllPPP(){
        try{
            connection = db.getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from eCommerce.products_platforms_pices");

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

    public ArrayList<PPP> mappingPPP(ResultSet resultSet) {

            ArrayList<PPP> result = new ArrayList();
            try {
                while (resultSet.next()) {
                    PPP temp = new PPP(resultSet.getInt("product_id"),resultSet.getInt("platform_id"),
                            resultSet.getDouble("price"));
                }
            }catch  (Exception e){
               e.getStackTrace();
            }
            return result;

    }


    public void updatePPP(int platform_id, double price, int id){
        try{
            connection = db.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE `eCommerce`.`products_platforms_pices` SET `platform_id`='?', `price`='?' WHERE `id`='?';");

            preparedStatement.setInt(1, platform_id);

            preparedStatement.setDouble(2, price);

            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            System.out.println("PPP updated");

        }catch (Exception e){

            e.getStackTrace();

        } finally {

            db.close(preparedStatement, connection);
        }
    }

    public void deletePPP(int id){
        try{
            connection = db.getConnection();

            preparedStatement = connection.prepareStatement("delete from e.Commerce.products_platforms_pices where id = ?;");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            System.out.println("PPP ");

        }catch ( Exception e ){

            e.getStackTrace();

        }finally {

            db.close(preparedStatement, connection);

        }

    }

}
