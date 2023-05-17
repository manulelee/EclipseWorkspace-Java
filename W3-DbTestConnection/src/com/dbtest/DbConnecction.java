package com.dbtest;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnecction {

	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "w3-d1";
	String user = "postgres";
	String pass= "root";
	
	Connection conn;
	Statement state;
	
	public DbConnecction() throws SQLException {
		conn = DriverManager.getConnection(url+dbName, user, pass);
		state = conn.createStatement();
	}
	
	/* creazione del crud */
	
	public insertCliente ()
	
}
