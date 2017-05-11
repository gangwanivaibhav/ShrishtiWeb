<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shrishti.vg.ConnectionFactory" %>


<% response.setContentType("text/html");%>
<%
	String str=request.getParameter("queryString");
	try {
		
		Connection con = ConnectionFactory.getConnection();
		//Add the data into the database
		String sql = "SELECT name FROM shrishti WHERE name LIKE '"+str+"%' LIMIT 10";
		Statement stm = con.createStatement();
		stm.executeQuery(sql);
		ResultSet rs= stm.getResultSet();
		while (rs.next ()){
			out.println("<li onclick='fill("+rs.getString("name")+");'>"
			+rs.getString("name")+"</i>");
		}
	}catch(Exception e){
		out.println("Exception is ;"+e);
	}
%>