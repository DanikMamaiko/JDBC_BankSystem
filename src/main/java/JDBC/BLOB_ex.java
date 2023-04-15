package JDBC;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.sql.*;

public class BLOB_ex {
    public static void main(String [] args) throws ClassNotFoundException {
        String name = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stat = connection.createStatement();

            BufferedImage image = ImageIO.read(new File("smile.png"));
            Blob blob = connection.createBlob();

            try(OutputStream outputStream = blob.setBinaryStream(1);){
                ImageIO.write(image, "png", outputStream);
            }

            PreparedStatement statement = connection.prepareStatement("insert into forImage (id, name, img) VALUES (?, ?, ?)");
            statement.setInt(1, 1);
            statement.setString(2, "Smile");
            statement.setBlob(3, blob);
            statement.execute();

            // image was written

            ResultSet resultSet = statement.executeQuery("select * from forImage");
            while (resultSet.next()){
                Blob blob2 = resultSet.getBlob("img");
                BufferedImage image2 = ImageIO.read(blob.getBinaryStream());
                File outputFile = new File("saved.png");
                ImageIO.write(image2, "png", outputFile);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

//            statement.executeUpdate("CREATE TABLE forImage (id integer, name varchar(30), img BLOB);");
//            System.out.println("Table has been created");
