package org.jug.dp.createional.factory.ps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo2 {

	public static void main(String[] args) {
		try {
            Properties prop = new Properties();

            InputStream inputStream = Demo2.class.getClassLoader().getResourceAsStream("db.properties");

            prop.load(inputStream);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection is done");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
