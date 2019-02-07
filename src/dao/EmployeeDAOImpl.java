package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabasFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {return instance;}


	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			String sql = EmployeeSQL.REGISTER.toString();
			
			System.out.println("실행할 쿼리: "+sql);
			
			Connection conn = DatabasFactory
							.createDatabase(Vendor.ORACLE)
							.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,emp.getManager());
			pstmt.setString(2,emp.getName());
			pstmt.setString(3,emp.getBirthDate());
			pstmt.setString(4,emp.getPhoto());
			pstmt.setString(5,emp.getNotes());
			
			int rs = pstmt.executeUpdate();
			
			System.out.println((rs==1) ? "성공":"실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<EmployeeDTO> selectEmployeeList() {
		List<EmployeeDTO> list = new ArrayList<>();
		String sql = "";
		try {
			PreparedStatement pstmt = DatabasFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		List<EmployeeDTO> list = new ArrayList<>();
		String sql = "";
		try {
			PreparedStatement pstmt = DatabasFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public EmployeeDTO selectEmployee(String serchWord) {
		
		return null;
	}

	@Override
	public int countEmployees() {
		int res = 0;
		String sql ="";
		try {
			PreparedStatement pstmt = DatabasFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			pstmt.setString(1,"");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean exsitEmployee(EmployeeDTO emp) {
		boolean ok = false;
		try {
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(EmployeeSQL.ACCESS.toString());
			pstmt.setString(1,emp.getEmployeeId());
			pstmt.setString(2,emp.getName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ok = true ;
			}
			System.out.println("접근 허용 : " + ok);
			/*while(rs.next()) {
				String name = rs.getString("NAME");
				if(name.equals("")) {
					ok = true;
				}
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		String sql ="";
		try {
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

}
