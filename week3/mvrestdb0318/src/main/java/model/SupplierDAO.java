package model;
import java.util.*;
import java.sql.*;
public class SupplierDAO {

  Connection supplierConnection() {
	  try {
		  String user="root";
		  String password="1234";
		  String url="jdbc:mysql://localhost:3306/classicmodels";
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  return DriverManager.getConnection(url, user, password);
	  }catch(Exception ex) {
		  System.out.println("Connection error "+ex.getMessage());
	  }
	  return null;
  }
  public Supplier findBySupplierId(int sid){
	  Connection cn= supplierConnection();
	  if(cn==null) {
		  return null;
	  }else {
		  String sql="select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from classicmodels.SUPPLIERS where SUP_ID=?";
		  try {
		     PreparedStatement st=cn.prepareStatement(sql);
		     st.setInt(1, sid);
		     ResultSet rs=st.executeQuery();
		     
		     if(rs.next()) {
		    	   int no=rs.getInt("SUP_ID");
		    	   String name=rs.getString("SUP_NAME");
		    	   String street=rs.getString("STREET");
		    	   String city=rs.getString("CITY");
		    	   String state=rs.getString("STATE");
		    	   String zip=rs.getString("ZIP");
		    	   Supplier sp=new Supplier(no,name,street,city,state,zip);
		    	   cn.close();
		    	   return sp;		    	   
		     }		     
		     return null;		     
		  }catch(Exception ex) {
			  System.out.println("getAll error "+ex.getMessage());			  
		  }
		  return null;
	  }
  }
  public List<Supplier> getAll(){
	  Connection cn= supplierConnection();
	  if(cn==null) {
		  return new ArrayList<Supplier>();
	  }else {
		  String sql="select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from classicmodels.SUPPLIERS";
		  try {
		     Statement st=cn.createStatement();
		     ResultSet rs=st.executeQuery(sql);
		     List<Supplier> data=new ArrayList<>();
		     while(rs.next()) {
		    	   int no=rs.getInt("SUP_ID");
		    	   String name=rs.getString("SUP_NAME");
		    	   String street=rs.getString("STREET");
		    	   String city=rs.getString("CITY");
		    	   String state=rs.getString("STATE");
		    	   String zip=rs.getString("ZIP");
		    	   Supplier sp=new Supplier(no,name,street,city,state,zip);
		    	   data.add(sp);		    	   
		     }
		     cn.close();
		     return data;		     
		  }catch(Exception ex) {
			  System.out.println("getAll error "+ex.getMessage());			  
		  }
		  return new ArrayList<Supplier>();
	  }
  }
  
  public boolean updatesupplier(String sid, String sname, String street, String city, String state,String zip) {
		Connection con = supplierConnection();
		PreparedStatement updatesp = null;

		String updateStatement = "update classicmodels.suppliers " + " set SUP_NAME= ? , " + " STREET= ? , " + " CITY=? ,"
				+ " STATE=? , ZIP=? " + " where SUP_ID= ?";

		try {
			con.setAutoCommit(false);
			updatesp = con.prepareStatement(updateStatement);			
			updatesp.setString(1, sname);
			updatesp.setString(2, street);
			updatesp.setString(3, city);
			updatesp.setString(4, state);
			updatesp.setString(5, zip);
			updatesp.setInt(6, Integer.parseInt(sid));
			int rows=updatesp.executeUpdate();
			con.commit();
			con.close();
			return rows>0;
		} catch (Exception e) {
			if (con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
					con.close();
				} catch (SQLException excep) {

				}
				System.out.println("update supplier error " + e.getMessage());
			}
		}
		return false;
	}
  
  public boolean insertSupplier(String sid, String sname, String street, String city, String state,String zip) {

		Connection con = supplierConnection();
		PreparedStatement insert = null;

		String insertStatement = "insert into classicmodels.SUPPLIERS( SUP_ID,SUP_NAME,STREET,CITY,STATE,ZIP)"
				+ "values (?,?,?,?,?,?)";

		try {
			con.setAutoCommit(false);
			insert = con.prepareStatement(insertStatement);
			insert.setInt(1, Integer.parseInt(sid));
			insert.setString(2, sname);
			insert.setString(3, street);
			insert.setString(4, city);
			insert.setString(5, state);
			insert.setString(6, zip);			
			int row = insert.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			con.close();
			return row>0;
		} catch (Exception e) {
			System.out.println("insert supplier error " + e.getMessage());
		}
        return false;
	}

  public boolean deleteSupplier(String sid) {
		Connection con = supplierConnection();
		PreparedStatement delete = null;

		String deleteStatement = "delete from classicmodels.suppliers " + " where SUP_ID=? ";

		try {

			con.setAutoCommit(false);
			delete = con.prepareStatement(deleteStatement);
			delete.setInt(1,Integer.parseInt(sid));
			int row=delete.executeUpdate();
			con.commit();
            con.close();
            return row>0;
		} catch (Exception e) {
			System.out.println("delete supplier error "+e.getMessage());
			if (con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
					con.close();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		return false;
	}
}
