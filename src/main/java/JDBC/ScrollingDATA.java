package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollingDATA {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection(url, name, password);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into books values (2, 'Auto Eminem')");

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from books");

            if(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.previous()){
                System.out.println(resultSet.getString("name"));
            }
            System.out.println("*****");
            //---
            if(resultSet.absolute(2)){
                System.out.println(resultSet.getString("name"));
            }
            System.out.println("*****");
            //--
            if(resultSet.first()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.last()){
                System.out.println(resultSet.getString("name"));
            }
            System.out.println("*****");
            //--
            //relative(index) - transport to value

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
