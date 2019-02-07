package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
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
			pstmt.setString(5,cus.getCity());
			pstmt.setString(6,cus.getPostalCode());
			pstmt.setString(7,cus.getAddress());
			
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1) ? "성공":"실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDTO> selectCustomersList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO selectCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

}
