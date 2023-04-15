package JDBC;

import java.sql.*;
import java.util.*;

public class forBank {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Input cash account for withdraw");
        Scanner scanner = new Scanner(System.in);
        double cash = scanner.nextDouble();

        try{
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();

            // if database is empty, use this cod
            ResultSet resultSet = statement.executeQuery("select count(*) from bank");
            while (resultSet.next()) {
                if (resultSet.getInt("count(*)") == 0) {
                    statement.executeUpdate("insert into bank values (0, 0)");
                    break;
                }
            }

            double d1=0;
            double d2=0;

            ResultSet resultSet2 = statement.executeQuery("select * from bank");
            while (resultSet2.next()) {
                double ost1 = resultSet2.getDouble("user_account");
                double ost2 = resultSet2.getDouble("bank_account");

                d1 = ost1;
                d2 = ost2;
            }

            System.out.println("Remain in user account: " + d1);
            System.out.println("Remain in bank account: " + d2);
            System.out.println("*****");

            double value1 = cash*0.98+d1;
            double value2 = cash*0.02+d2;

            System.out.println("New value in user account: " + value1);
            System.out.println("New value in bank account: " + value2);
            System.out.println("*****");

            PreparedStatement preparedStatement = connection.prepareStatement("update bank SET user_account=?, bank_account=?");
            preparedStatement.setDouble(1, value1);
            preparedStatement.setDouble(2, value2);
            preparedStatement.executeUpdate();

            System.out.println("end of program");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
