package service;

import java.util.List;

import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService {
	private static ImageServiceImpl instance = new ImageServiceImpl();
	public ImageServiceImpl() { dao = ImageDAOImpl.getInstance();}
	public static ImageServiceImpl getInstance() {return instance;}
	ImageDAOImpl dao;
	@Override
	public void addImage(ImageDTO img) {
		dao.insertImage(img);
	}

	@Override
	public List<ImageDTO> imageList(Proxy pxy) {
		return dao.selectimageList(pxy);
	}

	@Override
	public List<ImageDTO> searchImages(Proxy pxy) {
		return dao.selectsearchImages(pxy);
	}

	@Override
	public ImageDTO searchImage(ImageDTO img) {
		return dao.selectImage(img);
	}

	@Override
	public int countImage(Proxy pxy) {
		return dao.countImage(pxy);
	}

	@Override
	public void updateImage(ImageDTO img) {
		dao.updateImage(img);
		
	}

	@Override
	public void removeImage(ImageDTO img) {
		dao.deleteImage(img);
	}

}
