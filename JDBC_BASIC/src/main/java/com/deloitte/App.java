package com.deloitte;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties props = null;
		InputStream input = null;
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			input = new FileInputStream(
					"C:/Users/soumyardas/eclipse-oxygen_workspace/JDBC_BASIC/src/main/Config.properties");
			props = new Properties();
			props.load(input);
			Class.forName(props.getProperty("CLASS_NAME"));
			conn = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USERNAME"),
					props.getProperty("PASSWORD"));
			pstmt = conn.prepareStatement(
					"SELECT NAME FROM EMP WHERE ID = ? ");
			System.out.println("Please enter Emp Id.");
			pstmt.setInt(1, scan.nextInt());
			rs = pstmt.executeQuery();
			if (rs.next() == false)
				System.out.println("Sorry no employee found for this id.");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
			scan.close();
		}
	}
}
