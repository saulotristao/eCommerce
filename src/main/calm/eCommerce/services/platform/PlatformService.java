package main.calm.eCommerce.services.platform;

import main.calm.eCommerce.model.Platform;
import main.calm.eCommerce.services.database.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatformService {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private DBService dbService;

    public PlatformService() {
        dbService = new DBService();
    }

    public void deletingPlatform(int id) {
        try{
            // creating connection
            connection= dbService.getConnection();
            // preparing the statement
            preparedStatement = connection.prepareStatement("delete from eCommerce.platforms where id = ? ");
            // preparing parameters
            preparedStatement.setInt(1,id);
            // executing
            preparedStatement.executeUpdate();
            //
            System.out.println("platform deleted");
        }catch (Exception e){
            e.getStackTrace();
        }
        finally {
            dbService.close(preparedStatement, connection);
        }
    }

    public void updatingPlaform(int id, String name, String url, double sales_fee) {
        try{
            // creating connection
            connection= dbService.getConnection();
            // preparing statement
            // UPDATE `eCommerce`.`platforms` SET `name`='shopify' WHERE `id`='4';
            preparedStatement = connection.prepareStatement("update eCommerce.platforms SET name = ? , url = ? , sales_fee = ? where id = ? ");
            // preparing parameters

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, url);
            preparedStatement.setDouble(3, sales_fee);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
            System.out.println("platform update");

        } catch (Exception e){

        } finally {
            dbService.close(preparedStatement,connection);
        }

    }

    public void listingAllPlatforms() {
        try{
            //creating the connection
            connection = dbService.getConnection();
            // create a statement
            statement = connection.createStatement();
            // run the query
            resultSet = statement.executeQuery("select * from eCommerce.platforms");
            //maping platforms
            ArrayList<Platform> listOfPlatforms = new ArrayList<>();
            listOfPlatforms = mappingPlatforms(resultSet);
            // printing all platforms
            for (Platform a : listOfPlatforms) {
                System.out.println(a.toString());
            }

        }catch (Exception e){

        }finally {
            dbService.close(resultSet,statement,connection);
        }

    }

    public ArrayList<Platform> mappingPlatforms(ResultSet resultSet) throws Exception{

        ArrayList<Platform> result = new ArrayList();

        try{
            while (resultSet.next()){
                Platform temp = new Platform( resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("url"), resultSet.getDouble("sales_fee"));
                result.add(temp);
            }
            return result;
        }catch( Exception e ) {
            e.getStackTrace();
            throw e;
        }
    }

    public void createNewPlatformDB(String name, String url , double sales_fee) {
        try{
            // creating the connection
            connection = dbService.getConnection();

            // preparing the preparedStatement

            preparedStatement = connection
                    .prepareStatement("insert into eCommerce.platforms ( name , url , sales_fee) values ( ? , ?, ?) ");

            // passing new platform data

            preparedStatement.setString(1, name);

            preparedStatement.setString(2, url);

            preparedStatement.setDouble(3, sales_fee);

            preparedStatement.executeUpdate();

            System.out.println("platform inserted");


        }catch (Exception e){

        }finally {
            dbService.close(preparedStatement,connection    );
        }
    }


}
