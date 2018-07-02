package main.calm.eCommerce.services.Product;

import main.calm.eCommerce.Controller;
import main.calm.eCommerce.model.Product;
import main.calm.eCommerce.services.database.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private DBService database;

    public ProductService() {
        database = new DBService();
    }

    /**
     * Updating a product give the user the ability to update a product in the table
     *
     * @param id - product id
     * @param p_name - product name
     * @param p_description - product description
     * @throws Exception
     */
    public void updatingAProdcuct (int id, String p_name, String p_description) throws Exception{
        try{
            connection = database.getConnection();

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connection
                    .prepareStatement("UPDATE eCommerce.products SET p_name = ? , p_description = ? where id = ? ; ");

            // defining product
            preparedStatement.setString(1,p_name);

            preparedStatement.setString(2,p_description);

            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.getStackTrace();
            throw e;
        } finally {
            database.close(preparedStatement,connection);
        }
    }

    /**
     * method to delete a product in the table
     *
     * @param id
     */
    public void deletingAProduct(int id){
        try{
            connection= database.getConnection();

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connection
                    .prepareStatement("delete from eCommerce.products where id = ? ; " );

            // prepare
            preparedStatement.setInt(1, id);
            // execute
            preparedStatement.executeUpdate();

        }catch (Exception e){

        }finally {
            database.close(preparedStatement,connection);
        }
    }

    /**
     * Method to show all product in the table
     * @throws Exception
     */
    public void listingAllProducts() throws Exception {
        ArrayList<Product> temp = new ArrayList();

        try {
            connection= database.getConnection();

            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();

            //Executing the query
            resultSet = statement.executeQuery("select  * from products; ");

            //Putting ResultSet in an Array of products

            temp = MapResultProducts(resultSet);

            // printing out all the itens
            for (Product a: temp){
                System.out.println(a.toString());
            }


        } catch (Exception e) {
            e.getStackTrace();
            throw e;
        } finally {
            database.close(resultSet, preparedStatement,connection);
        }
    }

    /**
     * method to transfor the table in a arraylist of products
     *
     * @param a
     * @return
     * @throws Exception
     */
    public ArrayList<Product> MapResultProducts(ResultSet a) throws Exception{
        ArrayList<Product> result = new ArrayList<>();
        try {
            while (a.next()) {
                Product temp = new Product
                        (a.getInt("id"), a.getString("p_name"), a.getString("p_description"));
                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            e.getStackTrace();
            throw e;
        }
    }

    /**
     * Method to insert a new product in a table
     * @param p_name - product name
     * @param p_description - product description
     * @throws Exception
     */

    public void createNewProductInDB ( String p_name, String p_description) throws Exception{

        try {

            connection = database.getConnection();

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connection
                    .prepareStatement("insert into  eCommerce.products ( p_name, p_description) " +
                            "values ( ?, ?)");

            // INSERTING THE PRODUCT NAME
            preparedStatement.setString(1, p_name);

            // INSERTING THE PRODUCT DESCRIPTION
            preparedStatement.setString(2, p_description);

            preparedStatement.executeUpdate();


        } catch (Exception e){
            e.getStackTrace();
            throw e;
        } finally {
            database.close(preparedStatement,connection);
        }

    }


}
