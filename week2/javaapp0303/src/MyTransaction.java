import java.sql.*;
import java.util.*;
public class MyTransaction {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String user="root";
        String password="1234";
        String url="jdbc:mysql://localhost:3306/classicmodels";
        String sql="INSERT INTO classicmodels.offices "
        		+ "(officeCode,city,phone,addressLine1,addressLine2,state,country,postalCode,territory)"
        		+ " VALUES "
        		+ "(?,?,?,?,?,?,?,?,?);";
        Connection cn=DriverManager.getConnection(url, user, password);
        cn.setAutoCommit(false);
        PreparedStatement st= cn.prepareStatement(sql);
        st.setString(1, "11");
        st.setString(2, "Kaohsiung");
        st.setString(3, "07-123123");
        st.setString(4, "Adress NA");
        st.setString(5, null);
        st.setString(6, null);
        st.setString(7, "Taiwan");
        st.setString(8, "500");
        st.setString(9, "ASIA");
        int row=st.executeUpdate();
        System.out.println("inserted:"+row);
        Scanner input=new Scanner(System.in);
        System.out.print("Save Record(Y/N)?");
        String answer=input.next();
        if(answer.equalsIgnoreCase("y")) {
        	   cn.commit();
        }else {
        	   cn.rollback();
        }
        cn.setAutoCommit(true);
        cn.close();
	}

}
