package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class updateResSet {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("select * from bank");

            while (resultSet.next()){
                System.out.println(resultSet.getString("user_account"));
                System.out.println(resultSet.getString("bank_account"));
            }
            System.out.println("---");

            resultSet.last();
            resultSet.updateString("user_account", "new Value");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("user_account", "inserted name");
            resultSet.insertRow();

//            resultSet.absolute(2);
//            resultSet.deleteRow();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
