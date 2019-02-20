package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ImageDTO;
import enums.ImageSQL;
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
		try {
			PreparedStatement pstmt = conn.prepareStatement(ImageSQL.IMAGE_STORE.toString());
			System.out.println("이미지DAO 이미지파일명: "+img.getImgName());
			System.out.println("이미지DAO 이미지확장자: "+img.getImgExtention());
			System.out.println("이미지DAO 이미지오너아이디: "+img.getOwner());
			pstmt.setString(1,img.getImgName());
			pstmt.setString(2,img.getImgExtention());
			pstmt.setString(3,img.getOwner());
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
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
		ImageDTO image = new ImageDTO();
		try {
			PreparedStatement pstmt = conn.prepareStatement(ImageSQL.SELECT_ONE_IMG.toString());
			pstmt.setString(1,img.getImgSeq());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				image.setImgExtention(rs.getString("IMG_EXTENTION"));
				image.setImgName(rs.getString("IMG_NAME"));
				image.setImgSeq(rs.getString("IMG_SEQ"));
				image.setOwner(rs.getString("OWNER"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			String sql ="";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteImage(ImageDTO img) {
		
	}
	@Override
	public String lastImageSeq() {
		String imgseq = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(ImageSQL.LASTIMAGE_SEQ.toString());
			ResultSet rs = pstmt.executeQuery();
/*			pstmt.setString(1,);
*/			while(rs.next()) {
				imgseq = rs.getString("IMG_SEQ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgseq;
	}

}
