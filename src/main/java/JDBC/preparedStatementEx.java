package JDBC;

import java.sql.*;

public class preparedStatementEx {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String INSERT_NEW = "INSERT INTO dishes VALUES (?,?,?)";
        String query = "select * from dishes";


        try{
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query);
            Statement statement2 = connection.createStatement();

            ResultSet resultSet2 = preparedStatement2.executeQuery();
            //ResultSet resultSet2 = statement2.executeQuery(query);

            while (resultSet2.next()){
                int id1 = resultSet2.getInt("id");
                String name1 = resultSet2.getString("name");
                int time1 = resultSet2.getInt("time");

                System.out.println(id1 + "/" + name1 + "/" + time1);
            }

//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "dish name");
//            preparedStatement.setInt(3, 40);
//
//            preparedStatement.execute();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
