package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class resultSetEx {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";

        private Connection connection;
        public resultSetEx(){
            try{
                connection = DriverManager.getConnection(url, name, password);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public Connection getConnection(){
            return connection;
        }
}
