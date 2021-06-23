package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public Connection con;
	public  Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "admin");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
