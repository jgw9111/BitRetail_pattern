package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabasFactory;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {};
	public static CustomerDAOImpl getInstance() {return instance;}

	@Override
	public void insertCustomer(CustomerDTO cus) {
		System.out.println("===Customer DAOImpl===");
		try {
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(CustomerSQL.SIGNUP.toString());
			
			pstmt.setString(1,cus.getCustomerID());
			pstmt.setString(2,cus.getCustomerName());
			pstmt.setString(3,cus.getPassword());
			pstmt.setString(4,cus.getSsn());
			pstmt.setString(5,cus.getPhone());
			pstmt.setString(6,cus.getCity());
			pstmt.setString(7,cus.getAddress());
			pstmt.setString(8,cus.getPostalCode());
			
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1) ? "성공":"실패");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDTO> selectCustomersList() {
		List<CustomerDTO> list = new ArrayList<>();
			try {
				String sql = CustomerSQL.LIST.toString();
				PreparedStatement pstmt = DatabasFactory
											.createDatabase(Vendor.ORACLE)
											.getConnection()
											.prepareStatement(sql);
				ResultSet rs =pstmt.executeQuery();
				CustomerDTO cust = null;
				while(rs.next()) {
					cust = new CustomerDTO();
				 	cust.setCustomerID(rs.getString("CUSTOMER_ID"));
	                cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
	                cust.setSsn(rs.getString("SSN"));
	                cust.setPhone(rs.getString("PHOEN_NUMBER"));
	                cust.setCity(rs.getString("CITY"));
	                cust.setAddress(rs.getString("ADDRESS"));
	                cust.setPostalCode(rs.getString("POSTAL_CODE"));
	                System.out.println("방금 담은 값 : "+cust.getCustomerName());
					list.add(cust);
				}
				System.out.println("1번회원: "+list.get(0).getCustomerName());
				System.out.println("2번회원: "+list.get(1).getCustomerName());
				System.out.println("3번회원: "+list.get(2).getCustomerName());
				System.out.println("4번회원: "+list.get(3).getCustomerName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String searchWord) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(sql);
			pstmt.setString(1,"");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO cust = null;
		try {
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(CustomerSQL.SIGNIN.toString());
			pstmt.setString(1, cus.getCustomerID());
			pstmt.setString(2, cus.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cust = new CustomerDTO();
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setCity(rs.getString("CITY"));
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setPassword(rs.getString("PASSWORD"));
				cust.setPostalCode(rs.getString("POSTALCODE"));
				cust.setSsn(rs.getString("SSN"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cust;
	}

	@Override
	public int countCustomers() {
		int res = 0;
		try {
			String sql = "";
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(sql);
			pstmt.setString(1, "");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean existCustomerId(CustomerDTO cus) {
		boolean ok = false;
			try {
				PreparedStatement pstmt = DatabasFactory
											.createDatabase(Vendor.ORACLE)
											.getConnection()
											.prepareStatement(CustomerSQL.SIGNIN.toString());
				pstmt.setString(1,cus.getCustomerID());
				pstmt.setString(2,cus.getPassword());
				ResultSet rs =pstmt.executeQuery();
				if(rs.next()) {
					ok=true;
				}
				System.out.println("접근 허용 :"+ok);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ok;
	}

	@Override
	public void updateCustomer(CustomerDTO cus) {
		try {
			String sql = "";
			PreparedStatement pstmt = DatabasFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			pstmt.setString(1,"");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {
		try {
			String sql = "";
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(sql);
			pstmt.setString(1,"");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
