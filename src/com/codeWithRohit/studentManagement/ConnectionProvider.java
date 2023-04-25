package com.codeWithRohit.studentManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con;
	
	public static Connection createConnection() {
        try {
            //Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
			
            String userName = "root";
            String pwd = "Rohit@#9149";
            String url = "jdbc:mysql://localhost:3306/durgesh_jdbc_studentManagement";
			
            //Create connection
            con = DriverManager.getConnection(url, userName, pwd);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
