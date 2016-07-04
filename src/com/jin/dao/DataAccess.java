package com.jin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jin.beans.Branch;
import com.jin.beans.Food;
import com.jin.beans.FoodService;
import com.jin.beans.Frequent;
import com.jin.beans.Like;
import com.jin.beans.Provide;
import com.jin.beans.Student;


public class DataAccess extends UserDatabase{
	
	public DataAccess(){
	}
	public List<Map<String, String>> selectTable(String table, String order){	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData md=null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			String selectcsFoods = "SELECT * FROM " + table + " order by " + order;
			conn=getConnection();
			pstmt=conn.prepareStatement(selectcsFoods);
			rs = pstmt.executeQuery();
			md = rs.getMetaData();
			int count = md.getColumnCount();
			while(rs.next()){
				Map<String, String> map = new HashMap<String,String>();
				for(int i=1;i<=count;i++){	
					map.put(md.getColumnName(i), rs.getString(i));	
			    }
				list.add(map) ;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}
	
	public List<String> selectTables(){	
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<String> list = new ArrayList<String>();
		try {
			String selectcsFoods = "SELECT table_name FROM information_schema.tables WHERE table_schema='fs'";
			conn=getConnection();
			stmt=conn.createStatement();
			rs = stmt.executeQuery(selectcsFoods);
			while(rs.next()){
				String table = rs.getString(1);
				list.add(table) ;
		    }
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}
	
	public List<String> getColunmNames(String table){	
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSetMetaData md=null;
		List<String> list = new ArrayList<String>();
		try {
			String selectcsFoods = "SELECT * FROM " + table;
			conn=getConnection();
			stmt=conn.createStatement();
			rs = stmt.executeQuery(selectcsFoods);
			md = rs.getMetaData();
			int count = md.getColumnCount();
			for(int i=1;i<=count;i++){
				String name = md.getColumnName(i);	
				list.add(name) ;
		    }
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}
	public List<String> selectBranch(){	
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<String> list = new ArrayList<String>();
		try {
			String selectcsFoods = " SELECT distinct b.name FROM branch b, foodservice f WHERE b.name = f.name";
			conn=getConnection();
			stmt=conn.createStatement();
			rs = stmt.executeQuery(selectcsFoods);
			while(rs.next()){
				list.add(rs.getString(1)) ;
		    }
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}
	public boolean addFrequent(Frequent frequents){
		Connection conn=null;
		PreparedStatement pstmt=null;
	
		try {
			String insertTable = " Insert into  frequents(Student, Name, Bnum) values(?,?,?) ";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, frequents.getStudent());
			pstmt.setString(2, frequents.getName());
			pstmt.setInt(3, frequents.getBnum());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteFrequents(Frequent frequents) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from frequents where Student like ? and Name like ? and Bnum = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, frequents.getStudent());
			pstmt.setString(2, frequents.getName());
			pstmt.setInt(3, frequents.getBnum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean addStudent(Student student){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String insertTable = " Insert into  student(snum, name, major, hobby) values(?,?,?,?)";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, student.getSnum());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getMajor());
			pstmt.setString(4, student.getHobby());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public boolean updateStudent(Student student){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String insertTable = " Update student set name= ?, major= ?, hobby= ? where snum = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getMajor());
			pstmt.setString(3, student.getHobby());
			pstmt.setString(4, student.getSnum());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteStudent(Student student) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from student where snum = ? ";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, student.getSnum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean addFoodService(FoodService foodService){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String insertTable = " Insert into  foodservice(name, category, rate) values(?,?,?)";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, foodService.getName());
			pstmt.setString(2, foodService.getCategory());
			pstmt.setInt(3, foodService.getRate());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public boolean updateFoodService(FoodService foodService){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String insertTable = " Update foodservice set category= ?, rate= ? where name = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, foodService.getCategory());
			pstmt.setInt(2, foodService.getRate());
			pstmt.setString(3, foodService.getName());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteFoodService(FoodService foodService) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from foodservice where name = ? ";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, foodService.getName());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean addBranch(Branch branch){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fmt.parse(branch.getSince());
			String insertTable = " Insert into  branch(name, bnum, location, since) values(?,?,?,?)";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, branch.getName());
			pstmt.setString(2, branch.getBnum());
			pstmt.setString(3, branch.getLocation());
			pstmt.setDate(4, new java.sql.Date(date.getTime()));
		    pstmt.executeUpdate();
		} catch (SQLException | ParseException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public boolean updateBranch(Branch branch){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fmt.parse(branch.getSince());
			String insertTable = " Update branch set location= ?, since= ? where name = ? and bnum = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, branch.getLocation());
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setString(3, branch.getName());
			pstmt.setString(4, branch.getBnum());
		    pstmt.executeUpdate();
		} catch (SQLException | ParseException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteBranch(Branch branch) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from branch where name = ? and bnum = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, branch.getName());
			pstmt.setString(2, branch.getBnum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean addFood(Food food){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			String insertTable = " Insert into  food(name, cuisine, type) values(?,?,?)";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, food.getName());
			pstmt.setString(2, food.getCuisine());
			pstmt.setString(3, food.getType());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public boolean updateFood(Food food){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String insertTable = " Update food set cuisine= ?, type= ? where name = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, food.getCuisine());
			pstmt.setString(2, food.getType());
			pstmt.setString(3, food.getName());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteFood (Food food) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from food where name = ? ";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, food.getName());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean addProvide(Provide provide){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			String insertTable = " Insert into  provides(foodservice, food, price) values(?,?,?)";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, provide.getFoodService());
			pstmt.setString(2, provide.getFood());
			pstmt.setDouble(3, provide.getPrice());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public boolean updateProvide(Provide provide){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String insertTable = " Update provides set price= ? where foodservice = ? and food = ?";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setDouble(1, provide.getPrice());
			pstmt.setString(2, provide.getFoodService());
			pstmt.setString(3, provide.getFood());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteProvide (Provide provide) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from provides where foodservice = ? and food = ? ";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, provide.getFoodService());
			pstmt.setString(2, provide.getFood());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean addLike(Like like){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			String insertTable = " Insert into  likes(student, food) values(?,?)";
			conn=getConnection();
			pstmt=conn.prepareStatement(insertTable);	
			pstmt.setString(1, like.getStudent());
			pstmt.setString(2, like.getFood());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public int deleteLike (Like like) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			String deleteTable = "Delete from likes where student = ? and food = ? ";
			conn=getConnection();
			pstmt=conn.prepareStatement(deleteTable);
			pstmt.setString(1, like.getStudent());
			pstmt.setString(2, like.getFood());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return count;
		}
		return count;
	}
	public boolean createTable(String tableName, String col){
		Connection conn=null;
		Statement stmt=null;
		try {
			String createTable = " create table " + tableName +" (" + col + ")";
			conn=getConnection();
			stmt=conn.createStatement();
			System.out.println("query" + createTable);
		    stmt.executeQuery(createTable);
		} catch (SQLException e) {	
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
}
