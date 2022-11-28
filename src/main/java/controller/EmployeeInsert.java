package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SisDBConnection;

/**
 * Servlet implementation class EmployeeInsert
 */
@WebServlet("/insert")
public class EmployeeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInsert() {
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
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		Long year = Long.parseLong(request.getParameter("exp"));
		String degn = request.getParameter("degn");
		Connection con = null;
		String sql = "insert into employee_detail values(?,?,SYSDATE(),?,?)";
		PreparedStatement pstmt = null;
		Integer rs = null;
		try {
			con = SisDBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.setString(2, name);
			pstmt.setLong(3, year);
			pstmt.setString(4, degn);
			rs = pstmt.executeUpdate();
			if(rs == 1) {
				System.out.println("Successfully Inserted!!!");
			}else {
				System.out.println("Not Inserted!!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("fetch");
		rd.forward(request, response);
	}

}
