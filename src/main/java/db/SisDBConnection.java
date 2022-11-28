package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SisDBConnection{
    //load driver
	private final static String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final static String URL ="jdbc:mysql://localhost:3306/quadwave";
	private final static String USER ="root";
	private final static String PASSWORD ="root";
	private static boolean  isDriverLoaded=false;
	
	
	
	public static Connection getConnection() throws SQLException{
		Connection con = null;
		try {
			Class.forName(DRIVER_CLASS);
			System.out.println("driver loaded");
			isDriverLoaded=true;
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR : driver Class Not Found " + DRIVER_CLASS);
			e.printStackTrace();
		}
		 if(isDriverLoaded) {
			 con  = DriverManager.getConnection(URL,USER,PASSWORD);
		 }
		 return con;
	}
	
	//close connection
	
	public static void closeConnection(Connection con) throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		
	}
	
}
