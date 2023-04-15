package JDBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class mainResSet {
    public static void main(String [] args){
        resultSetEx rse = new resultSetEx();

        String query = "select * from users";

        try {
            Statement statement = rse.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
//                String name = resultSet.getString(2);
//                System.out.println(name);
                user us = new user();
                us.setId(resultSet.getInt(1));
                us.setName(resultSet.getString(2));
                us.setPassword(resultSet.getString(3));

                System.out.println(us);
            }

        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
}
