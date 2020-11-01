package com.service.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDao {

	Connection con=null;
	public int insertProductToDb(Product pobj){
		int result=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			PreparedStatement pst=con.prepareStatement("insert into product values(?,?)");
			pst.setString(1, pobj.getName());
			pst.setInt(2, pobj.getQty());
			result=pst.executeUpdate();
			
			
		}catch(Exception e){ e.printStackTrace();}
		
		return result;
	}
	
}
