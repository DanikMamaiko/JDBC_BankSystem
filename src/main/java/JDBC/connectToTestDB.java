package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectToTestDB {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            System.out.println("We have connected");
            Statement statement = connection.createStatement();
                //statement.executeUpdate("CREATE TABLE Books (id integer, name varchar(30));");
                //statement.executeUpdate("insert into Books (id, name) VALUES (1, 'Inferno')");
                //statement.executeUpdate("insert into Books (id, name) VALUES (2, 'Adam adventure')");

            ResultSet resultSet = statement.executeQuery("select * from Books");
                  while(resultSet.next()){
                      System.out.println(resultSet.getInt(1));
                      System.out.println(resultSet.getString(2));
                      System.out.println("-----");
                  }
            System.out.println("*******");
            ResultSet resultSet2 = statement.executeQuery("select name from Books where id=1");
                  while(resultSet2.next()){
                      System.out.println(resultSet2.getString("name"));
                  }
        } catch(Exception exception){
            System.out.println("Exception has received: " + exception);
        }
    }
}
