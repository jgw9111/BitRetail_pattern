package domain;
import lombok.Data;
public @Data class CustomerDTO {
	private String customerID, 
				   customerName, 
				   password, 
				   ssn, // 900000-1
				   photo,
				   phone,
				   city, // 지번주소
				   address, // 상세주소 
				   postalCode;

	
	
}
