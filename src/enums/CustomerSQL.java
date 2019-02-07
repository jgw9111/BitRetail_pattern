package enums;

public enum CustomerSQL {
	SIGNUP,SINGIN;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case SIGNUP : 
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,CITY,POSTAL_CODE,ADDRESS)\n" + 
					"VALUES(?,?,?,?,?,?,?)");
			break;
		
		}
		
		return query.toString();
	}
}
