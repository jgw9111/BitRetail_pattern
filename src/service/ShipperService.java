package service;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperService {
	public void registShipper(ShipperDTO shi);
	public List<ShipperDTO> bringShippersList();
	public List<ShipperDTO> retrieveShippers(String searchWord);
	public ShipperDTO retrieveShipper(String serchWord);
	public int countShippers();
	public boolean existShipper();
	public void modifyShipper(ShipperDTO shi);
	public void removeShipper(ShipperDTO shi);
}
