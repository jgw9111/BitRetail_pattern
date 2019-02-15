package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabasFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

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
	public List<CustomerDTO> selectCustomersList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
			try {
				/*System.out.println("실행할 쿼리::"+CustomerSQL.LIST.toString());*/
				String sql = CustomerSQL.LIST.toString();
				Pagination page = ((PageProxy)pxy).getPage();
				PreparedStatement pstmt = DatabasFactory
											.createDatabase(Vendor.ORACLE)
											.getConnection()
											.prepareStatement(sql);
				String startRow = String.valueOf(page.getStartRow());
				String endRow = String.valueOf(page.getEndRow());
				pstmt.setString(1, startRow);
				pstmt.setString(2, endRow);
				System.out.println("DAO 스타트로우:" + startRow);
				System.out.println("DAO 엔드로우:" + endRow);
				ResultSet rs =pstmt.executeQuery();
				CustomerDTO cust = null;
				while(rs.next()) {
					cust = new CustomerDTO();
					cust.setRnum(rs.getString("RNUM"));
				 	cust.setCustomerID(rs.getString("CUSTOMER_ID"));
	                cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
	                cust.setSsn(rs.getString("SSN"));
	                cust.setPhone(rs.getString("PHOEN_NUMBER"));
	                cust.setCity(rs.getString("CITY"));
	                cust.setAddress(rs.getString("ADDRESS"));
	                cust.setPostalCode(rs.getString("POSTAL_CODE"));
					list.add(cust);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(CustomerSQL.CUST_RETRIEVE.toString());
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
	public int countCustomers(Proxy pxy) {
		int res = 0;
		try {
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(CustomerSQL.ROW_COUNT.toString());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt("COUNT"); 
			}
		} catch (Exception e) {
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
	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			PreparedStatement ps = DatabasFactory
								.createDatabase(Vendor.ORACLE)
								.getConnection()
								.prepareStatement(CustomerSQL.CUST_PHONE.toString());
			ResultSet rs = ps.executeQuery();
			CustomerDTO cust =null;
			while(rs.next()) {
				cust = new CustomerDTO(); // deep copy
				String entry = rs.getString("CUSTOMER_ID");
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setPhone(rs.getString("PHOEN_NUMBER"));
				map.put(entry, cust); // pk 값 entry 로 치환
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public CustomerDTO selectCustomerOne(CustomerDTO cus) {
		CustomerDTO cust = new CustomerDTO();
		try {
			
			PreparedStatement pstmt = DatabasFactory
										.createDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(CustomerSQL.CUST_RETRIEVE.toString());
			pstmt.setString(1, cus.getCustomerID());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setCity(rs.getString("CITY"));
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setPostalCode(rs.getString("POSTAL_CODE"));
				cust.setSsn(rs.getString("SSN"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setPhone(rs.getString("PHOEN_NUMBER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return cust;
	}

}
