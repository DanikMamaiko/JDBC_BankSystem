package JDBC;

import java.sql.*;

public class workWithDate {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into datework (name, date) values (849, ?)");
            preparedStatement.setDate(1, new Date(1679592503401L));
            preparedStatement.execute();

            System.out.println(preparedStatement);

            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into datework values (900, '2004-05-10')");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
