import java.sql.*;

public class StoredProcDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 String user="root";
	     String password="1234";
	     String url="jdbc:mysql://localhost:3306/classicmodels";
	     String sql="call classicmodels.GetEmpInOffice(?);";
	     
	     Connection cn=DriverManager.getConnection(url, user, password);
	     CallableStatement st=cn.prepareCall(sql);
	     st.setString(1, "tokyo");
	     boolean flag=st.execute();
	     if(flag) {
	    	     ResultSet rs=st.getResultSet();
	    	     while(rs.next()) {
	    	    	   int no=rs.getInt("employeeNumber");
	    	    	   String fn=rs.getString("firstName");
	    	    	   String em=rs.getString("email");
	    	    	   String title=rs.getString("jobTitle");
	    	    	   System.out.printf("No:%d FirstName:%s Email:%s JobTitle:%s%n",no,fn,em,title);
	    	     }
	     }else {
	    	    System.out.println("No Data");
	     }
	     cn.close();
	}

}
