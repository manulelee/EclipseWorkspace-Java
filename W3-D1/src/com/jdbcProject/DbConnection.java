package com.jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class DbConnection {

	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "w3-d1.2";
	String user = "postgres";
	String pass = "root";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url+dbName, user, pass);
		st = conn.createStatement();
		System.out.println("Connesso al database: " + dbName);
	}
	
	public void inserisciStudente(Studente s) throws SQLException {
		System.out.println(s.getBirthdate());
		String sql = "INSERT INTO studenti (nome, last_name, gender, birthdate, avg, min_vote, max_vote) "
				+ "VALUES ('"+s.getNome()+"', "
						+ "'"+s.getCognome()+"', "
						+ "'"+s.getGender()+"', "
						+ "'"+s.getBirthdate()+"', "
						+ "'"+s.getAvg()+"', "
						+ "'"+s.getMin_vote()+"', "
						+ "'"+s.getMax_vote()+"')";
		
		st.executeUpdate(sql);
		System.out.println("Studente " + s.getNome() + " " + s.getCognome() + " aggiunto nel sistema...");
	}
	
	public void aggiornaStudente (Studente s) throws SQLException {
		String sql = "UPDATE studenti SET "
				+ "nome = '"+s.getNome()+"', "
				+ "last_name = '"+s.getCognome()+"', "
				+ "gender = '"+s.getGender()+"', "
				+ "birthdate = '"+s.getBirthdate()+"', "
				+ "avg = '"+s.getAvg()+"', "
				+ "min_vote =  '"+s.getMin_vote()+"', "
				+ "max_vote = '"+s.getMax_vote()+"'"
				+ "WHERE id =  '"+ s.getId()+"'";
		st.executeUpdate(sql);
		System.out.println( s.getNome() + " " + s.getCognome() + " modificato nel DB!!");
	}
	
	
	public Studente ricercaId (int id) throws SQLException  {
		String sql = "SELECT * FROM studenti WHERE id = " + id;
		ResultSet rs = st.executeQuery(sql);
		
		Studente s = null;
		if(rs.next()) {
			s = new Studente(
					rs.getInt("id"), 
					rs.getString("name"), 
					rs.getString("last_name"), 
					rs.getString("gender"),
					LocalDate.parse(rs.getString("birthdate")), 
					rs.getDouble("avg"), 
					rs.getInt("min_vote"), rs.getInt("max_vote"));
		}
		return s;
	}
	
	public void deleteStudent(int id) throws SQLException  {
		String sql = "DELETE FROM studenti WHERE id = " + id;
		st.executeUpdate(sql);
	}
	
	

}
