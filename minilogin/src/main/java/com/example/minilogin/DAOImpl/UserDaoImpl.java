package com.example.minilogin.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.minilogin.DAO.UserDAO;

import com.example.minilogin.model.Users;
import com.example.minilogin.util.DButil;

@RestController
public class UserDaoImpl implements UserDAO{
	static List<Users> list1=new ArrayList();
	Connection connection;
	
	public UserDaoImpl() {
		connection = DButil.getConnection();
		System.out.println("connection" + connection);
	}	
	public List<Users> viewAllUser(){
		//List<Customer> customer = new ArrayList<Customer>();		
		System.out.println("Inside viewAll customer");

		try {
			list1.clear();

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from users");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Users user=new Users();
				System.out.println("Inside while");
				user.setId(rs.getLong("id"));
				user.setEmail(rs.getString("email"));

				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setConfirm_password(rs.getString("confirm_password"));
				System.out.println("Inside while-2");
				list1.add(user);
				System.out.println(list1);	
			}
			}catch(Exception e) {}
		return list1;
	}
	
	public Users createUser(Users user) {
		int noOfRecords=0;
		try {
		PreparedStatement pst = connection.prepareStatement("Insert into users(email,name,password,confirm_password) values(?,?,?,?)");
		pst.setString(1,user.getEmail());
		pst.setString(2,user.getName());
		pst.setString(3,user.getPassword());
		pst.setString(4,user.getConfirm_password());
		noOfRecords=pst.executeUpdate();
		
		System.out.println(noOfRecords + "record inserted successfully");
		}catch(Exception e) {}
		return user;
	}
	public void updateUser(Users user) {}
	
	public int loginValidation(String name,String password){
		int flag=0;
		viewAllUser();
		for (Users c:list1) {
			System.out.println("Customer data----"+c);
			if (name.equals(c.getName())  && password.equals(c.getPassword())) {
				flag=1;							
				//return flag;
			} 
		}
		System.out.println("flag"+flag);
		return flag;
	}
	
}