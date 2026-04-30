import java.sql.*;
public class StoredProc2Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 String user="root";
	     String password="1234";
	     String url="jdbc:mysql://localhost:3306/classicmodels";
	     String sql="call classicmodels.GetEmpCountInOffice(? , ?);";
	     
	     Connection cn=DriverManager.getConnection(url, user, password);
	     CallableStatement st=cn.prepareCall(sql);
	     String city="nyc";
	     st.setString(1, city);
	     st.registerOutParameter(2, Types.INTEGER);
	     boolean flag=st.execute();
	     if(!flag) {
	    	    int num=st.getInt(2);
	    	    System.out.printf("%s city has %d employees",city,num);
	     }else {
	    	     System.out.println("You got RETURN data");
	     }
	     cn.close();
	}

}
