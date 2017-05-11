package com.shrishti.vg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * github
 * https://github.com/gangwanivaibhav/ShrishtiWeb.git
 * Servlet implementation class search
 */
@WebServlet("/search.php")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramName= request.getParameter("name");
		System.out.println("name is "+paramName);
		Names names;
		try{
			names = new NamesDao().getAllMatchingNames(paramName);
			System.out.println(names.getId()+" "+names.getName()+" "+ names.getCount());

		Gson gson = new Gson();

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			

			  //create Json Object
			    response.setContentType("application/json");
		        PrintWriter out = response.getWriter();
//		        out.println("{");
//		        out.println("\"Name\": \"Devesh\",");
//		        out.println("\"Count\": \"Sharma\"");
//		        out.println("}");
		      
		        out.println( gson.toJson(names));
		        out.close();
		       

			    // finally output the json string       
			   
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}catch(Exception ex){
		}
	}

}