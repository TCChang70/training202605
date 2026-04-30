package model;
import java.util.*;
import java.sql.*;
public class StoredProcCode {
	Connection classicmodelsConnection() {
		try {
			String user = "root";
			String password = "1234";
			String url = "jdbc:mysql://localhost:3306/classicmodels";
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			System.out.println("Connection error " + ex.getMessage());
		}
		return null;
	}
	public List<String> getAllOfficeCity(){
		Connection cn=classicmodelsConnection();
		if (cn == null) {
			return new ArrayList<String>();
		} else {
			String sql = "select CITY from classicmodels.OFFICES";
			try {
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				List<String> data = new ArrayList<>();
				while (rs.next()) {					
					String name = rs.getString("CITY");
					data.add(name);
				}
				cn.close();
				return data;
			} catch (Exception ex) {
				System.out.println("getAllOffice error " + ex.getMessage());
			}
			return new ArrayList<String>();
		}
	}
	public List<Employee> execGetEmpInOffice(String city){
		Connection cn=classicmodelsConnection();
		try {
		   CallableStatement cStmt = cn.prepareCall("CALL GetEmpInOffice(?)");
           cStmt.setString(1, city);
           ResultSet rs=cStmt.executeQuery();
           List<Employee> data=new ArrayList<>();
           while(rs.next()) {
        	     int no=rs.getInt("employeeNumber");
        	     String fn=rs.getString("firstName");
        	     String ln=rs.getString("lastName");
        	     String ex=rs.getString("extension");
        	     String em=rs.getString("email");
        	     String code=rs.getString("officeCode");
        	     String tt=rs.getString("jobTitle");        	     
        	     int rpt=rs.getInt("reportsTo");
        	     Employee e1=new Employee(no,fn,ln,ex,em,code,tt,rpt);
        	     data.add(e1);
           }           
           cn.close();
           return data;
		}catch(Exception ex) {
			System.out.println("exec GetEmpInOffice error "+ex.getMessage());
		}
        return new ArrayList<Employee>();
	}
}
