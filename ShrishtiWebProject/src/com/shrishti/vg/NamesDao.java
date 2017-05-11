package com.shrishti.vg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NamesDao {
	public Names getAllMatchingNames(String param) throws SQLException{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from shrishti where name like '%"+param+"%' ");
		Names returnName = null;
		ResultSet res = ps.executeQuery();
		while(res.next()){
			int temp = res.getInt("count");

			if(param.compareToIgnoreCase(res.getString("name")) == 0){
		
				PreparedStatement ps1 = con.prepareStatement(
				      "update shrishti set count = ? where name = ?");
				ps1.setInt(1,(temp+1));
				ps1.setString(2,param);
				ps1.executeUpdate();
				ps1.close();
				System.out.println("temp "+(temp+1));
				System.out.println(res.getString("name"));
				returnName = new Names(res.getString("name"), res.getInt("count"));
			}else{	
			}
		}
		return returnName;
	}
}
