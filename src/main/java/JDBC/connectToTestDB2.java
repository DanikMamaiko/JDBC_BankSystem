package JDBC;

import java.sql.*;

public class connectToTestDB2 {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            System.out.println("We have connected");
//            Statement statement = connection.createStatement();
//                statement.executeUpdate("CREATE TABLE Users (id varchar(5), name varchar(30), password varchar(30));");
//                statement.executeUpdate("insert into Users (id, name, password) VALUES ('1', 'Ivan', '123')");
//                statement.executeUpdate("insert into Users (id, name, password) VALUES ('2', 'Alex', '568')");
//                statement.executeUpdate("drop table Users");

            String userId = "1";

            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where id = ?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("userName: " + resultSet.getString("name"));
                System.out.println("userPassword: " + resultSet.getString("password"));
            }


//            ResultSet resultSet3 = statement.executeQuery("select * from Users where id = '" + userId +"'");
//            while (resultSet3.next()){
//                System.out.println("userName: " + resultSet3.getString("name"));
//                System.out.println("userPassword: " + resultSet3.getString("password"));
//            }

//            ResultSet resultSet2 = statement.executeQuery("select * from Users");
//                while(resultSet2.next()){
//                    System.out.println(resultSet2.getString(1));
//                    System.out.println(resultSet2.getString(2));
//                    System.out.println(resultSet2.getString(3));
//                    System.out.println("-----");
//                }

        } catch(Exception exception){
            System.out.println("Exception has received: " + exception);
        }
    }
}
