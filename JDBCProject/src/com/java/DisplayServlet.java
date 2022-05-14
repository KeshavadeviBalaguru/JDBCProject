package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("sid"));
	
		try
		{
			Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			
			String s="select * from student where sid="+id;
			ResultSet rs=st.executeQuery(s);
			
			if(rs.next())
			{
				out.println("Id ="+rs.getInt(1)+"\n Name ="+rs.getString(2)+"\nAge= "+rs.getInt(3)+"\n Fees ="+rs.getFloat(4)+"\nPassword = "+rs.getString(5));
			}
			else
			{
				out.println("Id Not Exist");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
