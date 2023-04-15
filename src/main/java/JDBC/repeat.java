package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class repeat {
    private static String name = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/test";
    public static void main(String [] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String insert_new = "insert into users (id, name, password) values (?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setString(2, "pass2");
//            preparedStatement.setInt(3, 123);
//            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int i1 = resultSet.getInt("id");
                String s1 = resultSet.getString("name");
                int p1 = resultSet.getInt("password");

                System.out.println(i1+"/"+s1+"/"+p1);
            }



        } catch (Exception e){
            e.printStackTrace();
        }


//        try{
//            Connection connection = DriverManager.getConnection(url, name, password);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from users");
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println(resultSet.getInt("password"));
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }


    }
}
