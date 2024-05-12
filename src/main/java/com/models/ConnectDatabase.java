package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.order.JavaBeans.ProductBean;

public class ConnectDatabase {
	private Connection con = null;
	private String sql, sql1, selectSQL;
	String message;
	private PreparedStatement pstate = null, pstate1 = null, selectPstate = null;

	public ConnectDatabase() {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/OrderDetails";
		String username = "root";
		String password = "Omsairam$9";
		try {
			Class.forName(className);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductBean retrieve(String pid) {
		sql = "select * from OrderInfo where productId = ?";
		ProductBean bean = null;
		try {
			pstate = con.prepareStatement(sql);
			pstate.setString(1, pid);
			ResultSet result = pstate.executeQuery();
			if (result.next()) {
				String proid = result.getString("productId");
				String proname = result.getString("productName");
				String purchasedate = result.getString("purchaseDate");
				float price = result.getFloat("price");
				bean = new ProductBean(proid, proname, purchasedate, price);
			} else {
				bean = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public int checkDuplicate(String email) {
		selectSQL = "select * from login where email = ?";
		int flag = 0;
		try {
			selectPstate = con.prepareStatement(selectSQL);
			selectPstate.setString(1, email);
			ResultSet queryResult = selectPstate.executeQuery();
			if (queryResult.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public String insert(String fname, String lname, String add1, String add2, String city, int pno, String email,
			String password) {
		int temp = checkDuplicate(email);
		if (temp == 1) {
			message = "Duplicate";
		} else {
			sql = "insert into login values(?,?)";
			try {
				pstate = con.prepareStatement(sql);
				pstate.setString(1, email);
				pstate.setString(2, password);
				int executeUpdate = pstate.executeUpdate();
				if (executeUpdate > 0) {
					sql1 = "insert into personal values(?, ?, ?, ?, ?, ?, ?)";
					try {
						pstate1 = con.prepareStatement(sql1);
						pstate1.setString(1, fname);
						pstate1.setString(2, lname);
						pstate1.setString(3, add1);
						pstate1.setString(4, add2);
						pstate1.setString(5, city);
						pstate1.setInt(6, pno);
						pstate1.setString(7, email);
						int insertPersonal = pstate1.executeUpdate();
						if (insertPersonal > 0) {
							message = "Registered Successfully";
						} else {
							message = "Personal records could not be entered into the database";
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "Login records could not be entered into the database";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	public String validate(String uname, String pword) {
		sql = "select * from login where email = ? and password = ?";
		String fname = null;
		try {
			pstate = con.prepareStatement(sql);
			pstate.setString(1, uname);
			pstate.setString(2, pword);
			ResultSet queryResult = pstate.executeQuery();
			if (queryResult.next()) {
				sql1 = "select * from personal where email = ?";
				try {
				pstate1 = con.prepareStatement(sql1);
				pstate1.setString(1, uname);
				
				ResultSet queryResult1 = pstate1.executeQuery();
				if (queryResult1.next()) {
					fname = queryResult1.getString("fname");
				}else {
					fname = "NoData";
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				fname = "NoData";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fname;
	}
}
