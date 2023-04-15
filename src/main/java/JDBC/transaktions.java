package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class transaktions {
    public static void main(String [] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test"; // test - название БД
        Class.forName("com.mysql.cj.jdbc.Driver"); // данность

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();

            connection.setAutoCommit(false);

            statement.executeUpdate("insert into books values (3, 'third book')");
            statement.executeUpdate("insert into books values (4, 'fourth book')");

            connection.commit();

        } catch (Exception e){
            connection.rollback();
            e.printStackTrace();
        }

    }
}
