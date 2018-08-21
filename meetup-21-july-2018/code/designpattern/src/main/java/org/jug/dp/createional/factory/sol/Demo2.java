package org.jug.dp.createional.factory.sol;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo2 {

	public static void main(String[] args) {
		JdbcConnectionFactory connectionFactory=new JdbcConnectionFactory();
		Connection connection= connectionFactory.getConnection();
	}
}
