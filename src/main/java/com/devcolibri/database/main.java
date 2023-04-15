package com.devcolibri.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String [] args){

        System.out.println("Hello world!!");

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch(Exception e){
            System.out.println("Error exception");
        }

    }

}
