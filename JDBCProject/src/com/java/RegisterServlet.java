package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.ResultStreamer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String sn=request.getParameter("sname");
		String p=request.getParameter("spass1");
	    int sa=Integer.parseInt(request.getParameter("sage"));
		float sf=Float.parseFloat(request.getParameter("sfees"));
		int id=Integer.parseInt(request.getParameter("sid"));
		System.out.println(p);
		
		try
		{
			Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			
		    String ins="insert into student values("+id+",'"+sn+"',"+sa+","+sf+",'"+p+"')";
			//String dis="select * from student ";
			int i=st.executeUpdate(ins);
			
			if(i>0)
			{
				out.println("Registered Successfully");
			}
			else
			{
				out.println(" Not Registered ");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
