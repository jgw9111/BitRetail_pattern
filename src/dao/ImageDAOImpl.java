package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import domain.ImageDTO;
import enums.Vendor;
import factory.DatabasFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAOImpl instance = new ImageDAOImpl();
	Connection conn;
	public ImageDAOImpl() {
		 conn = DatabasFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection();
	}
	public static ImageDAOImpl getInstance() {return instance;}


	@Override
	public void insertImage(ImageDTO img) {
		String sql = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ImageDTO> selectimageList(Proxy pxy) {
		List<ImageDTO> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<ImageDTO> selectsearchImages(Proxy pxy) {
		List<ImageDTO> list = new ArrayList<>();
		return list;
	}

	@Override
	public ImageDTO selectImage(ImageDTO img) {
		ImageDTO image = null;
		return image;
	}

	@Override
	public int countImage(Proxy pxy) {
		int res = 0;
		return res;
	}

	@Override
	public boolean existImage(Proxy pxy) {
		boolean ok = false;
		return ok;
	}

	@Override
	public void updateImage(ImageDTO img) {
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		
	}
	@Override
	public String lastImageSeq() {
		// TODO Auto-generated method stub
		return null;
	}

}
