package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enums.EmployeeSQL;
import enums.Props;

public class ConnTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(Props.ORA_DRIVER.getValue());
			conn = DriverManager.getConnection(Props.DB_URL.getValue(),Props.DB_USER.getValue(),Props.DB_PASS.getValue());
			pstmt = conn.prepareStatement(EmployeeSQL.COUNT.toString());
			rs = pstmt.executeQuery();
			String count = null;
			while(rs.next()) {
				count = rs.getString("COUNT");
			}
			System.out.println("회원의 이름은 ::"+count);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
