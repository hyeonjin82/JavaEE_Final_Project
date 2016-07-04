package com.jin.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class UserDatabase {
	private boolean isD=false;
	public void log(String msg){
		if(isD){
			System.out.println(this.getClass()+" : " + msg);
		}
	}
	public void log(String msg, Exception ee){
		if(isD){
			System.out.println(this.getClass()+" : " + ee.getMessage()+" : " + msg);
		}
	}
	public Connection getConnection() throws SQLException{
//		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fs?user=root", "root", "abc4343");
		String url="jdbc:mysql://localhost:3306/fs?user=root";
		String user="root";
		String password="abc4343";
		return DriverManager.getConnection(url, user, password);	
	}
	public void close(Connection conn, Statement psmt, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
			
			}
		}
		if(psmt!=null){
			try {
				psmt.close();
			} catch (SQLException e) {
			
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
			
			}
		}
	}
	public UserDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log("1/6");
		} catch (ClassNotFoundException e) {
			log("1/6", e);
		}
		
	}
}
