//package bank_project;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class main1 {
//    public static void main(String [] args) throws ClassNotFoundException {
//        System.out.println("Input cash account for withdraw");
//        Scanner scanner = new Scanner(System.in);
//
//        double cash = scanner.nextDouble();
//
//        String name = "root";
//        String password = "root";
//        String url = "jdbc:mysql://localhost:3306/test";
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        try{
//            Connection connection = DriverManager.getConnection(url, name, password);
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select count(*) from bank");
//
//            while (resultSet.next()){
//                // if database is empty, use this cod
//                if(resultSet.getInt("count(*)")==0){
//                    statement.executeUpdate("insert into bank values (0, 0)");
//                    break;
//                }
//
//                double d1 = resultSet.getDouble("user_account");
//                double d2 = resultSet.getDouble("bank_account");
//
//                System.out.println("Remains in user_account: " + d1);
//                System.out.println("Remains in bank_account: " + d2);
//
//                PreparedStatement preparedStatement2 = connection.prepareStatement("update bank SET user_account=?, bank_account=?");
//                preparedStatement2.setDouble(1, cash*0.98+d1);
//                preparedStatement2.setDouble(2, cash*0.02+d2);
//
//                double d3 = resultSet.getDouble("user_account");
//                double d4 = resultSet.getDouble("bank_account");
//                System.out.println("New value in user_account: " + d3);
//                System.out.println("New value in bank_account: " + d4);
//
//            }
//
//
//
//
////            Statement statement = connection.createStatement();
////            statement.executeUpdate("truncate table bank");
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//    }
//}
