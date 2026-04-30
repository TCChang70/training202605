package model;

import java.util.*;
import java.sql.*;

public class CoffeeDAO {

	Connection coffeeConnection() {
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

	public List<Coffee> getAll() {
		Connection cn = coffeeConnection();
		if (cn == null) {
			return new ArrayList<Coffee>();
		} else {
			String sql = "select COF_NAME , SUP_ID, PRICE ,SALES,TOTAL from classicmodels.COFFEES";
			try {
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				List<Coffee> data = new ArrayList<>();
				while (rs.next()) {
					int no = rs.getInt("SUP_ID");
					String name = rs.getString("COF_NAME");
					double p = rs.getDouble("PRICE");
					int sa = rs.getInt("SALES");
					int tt = rs.getInt("TOTAL");
					Coffee cf = new Coffee(name, no, p, sa, tt);
					data.add(cf);
				}
				cn.close();
				return data;
			} catch (Exception ex) {
				System.out.println("getAll error " + ex.getMessage());
			}
			return new ArrayList<Coffee>();
		}
	}

	public void InsertCoffee(String coffee, String sale, String total, String supplier, String price) {

		Connection con = coffeeConnection();
		PreparedStatement insert = null;

		String insertStatement = "insert into classicmodels.COFFEES( COF_NAME , SUP_ID , PRICE , SALES ,TOTAL)"
				+ "values (?,?,?,?,?)";

		try {
			con.setAutoCommit(false);
			insert = con.prepareStatement(insertStatement);
			insert.setString(1, coffee);
			insert.setInt(2, Integer.parseInt(supplier));
			insert.setDouble(3, Double.parseDouble(price));
			insert.setInt(4, Integer.parseInt(sale));
			insert.setInt(5, Integer.parseInt(total));
			int row = insert.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			con.close();
		} catch (Exception e) {
			System.out.println("insert coffee error " + e.getMessage());
		}

	}

	public void updateCoffee(String coffee, String sale, String total, String price, String sid) {
		Connection con = coffeeConnection();
		PreparedStatement updateSales = null;

		String updateStatement = "update classicmodels.COFFEES " + " set TOTAL = ? , " + " Price= ? , " + " Sales=? ,"
				+ " SUP_ID=? " + " where COF_NAME = ?";

		try {
			con.setAutoCommit(false);
			updateSales = con.prepareStatement(updateStatement);
			updateSales.setInt(1, Integer.parseInt(total));
			updateSales.setDouble(2, Double.parseDouble(price));
			updateSales.setInt(3, Integer.parseInt(sale));
			updateSales.setInt(4, Integer.parseInt(sid));
			updateSales.setString(5, coffee);
			updateSales.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			if (con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
					con.close();
				} catch (SQLException excep) {

				}
				System.out.println("update coffee error " + e.getMessage());
			}
		}
	}

	public void deleteCoffee(String coffee) {
		Connection con = coffeeConnection();
		PreparedStatement delete = null;

		String deleteStatement = "delete from classicmodels.COFFEES " + " where COF_NAME=? ";

		try {

			con.setAutoCommit(false);
			delete = con.prepareStatement(deleteStatement);
			delete.setString(1, coffee);
			delete.executeUpdate();
			con.commit();
            con.close();
		} catch (Exception e) {
			System.out.println("delete coffee error "+e.getMessage());
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
	}

}
