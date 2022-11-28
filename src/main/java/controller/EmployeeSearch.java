package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class EmployeeSearch
 */
@WebServlet("/search")
public class EmployeeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("id");
		Integer id = null;
		String name = null;
		String sql = null;
		ArrayList<Employee> allEmp = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println(type);
		try {
			id = Integer.parseInt(type);
			sql = "select * from employee_detail where eid = "+id;
		}catch(Exception e) {
			name = type;
			sql = "select * from employee_detail where ename like '%"+name+"%'";
		}finally {
			try {
				System.out.println(sql);
				con = SisDBConnection.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				allEmp = new ArrayList<>();
				while(rs.next()){
					Employee emp = new Employee(rs.getLong(1),rs.getString(2),rs.getDate(3) + "",rs.getLong(4),rs.getString(5));
					allEmp.add(emp);
				}
				System.out.println(allEmp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("allEmp", allEmp);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
