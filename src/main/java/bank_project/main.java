package bank_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class main {
    public static void main(String [] args) throws ClassNotFoundException {
        System.out.println("Input cash account for withdraw");
        Scanner scanner = new Scanner(System.in);

        double cash = scanner.nextDouble();

        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from bank");

            PreparedStatement preparedStatement = connection.prepareStatement("update bank SET user_account=?, bank_account=?");
            preparedStatement.setDouble(1, cash*0.98);
            preparedStatement.setDouble(2, cash*0.02);
            preparedStatement.execute();

            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from bank");
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()){
                double d1 = resultSet.getDouble("user_account");
                double d2 = resultSet.getDouble("bank_account");
                System.out.println("Remains in user_account: " + d1);
                System.out.println("Remains in bank_account: " + d2);
            }

//            Statement statement = connection.createStatement();
//            statement.executeUpdate("truncate table bank");

        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
