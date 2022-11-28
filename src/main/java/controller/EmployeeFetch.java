package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Employee;
import db.SisDBConnection;

/**
 * Servlet implementation class EmployeeFetch
 */
@WebServlet("/fetch")
public class EmployeeFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		String sql = "select * from employee_detail";
		Statement stmt = null;
		ArrayList<Employee> allEmp = null;
		ResultSet rs = null;
		try {
			con = SisDBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			allEmp = new ArrayList<>();
			while(rs.next()){
				Employee emp = new Employee(rs.getLong(1),rs.getString(2),rs.getDate(3) + "",rs.getLong(4),rs.getString(5));
				allEmp.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("allEmp", allEmp);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
