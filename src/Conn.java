import java.sql.*;
public class Conn {

	 private Connection c;

	
	Conn() {
		
		try {
			
			setC(DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Bilal449!"));
			
		} catch(Exception e) {
			
			System.out.println(e);
			
		}
		
	}

	public Connection getC() {
		return c;
	}

	public void setC(Connection c) {
		this.c = c;
	}

}
