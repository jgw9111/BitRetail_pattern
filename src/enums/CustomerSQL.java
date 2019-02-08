package enums;

public enum CustomerSQL {
	SIGNUP,SIGNIN;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case SIGNUP : 
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,CITY,POSTAL_CODE,ADDRESS)\n" + 
					"VALUES(?,?,?,?,?,?,?)");
			break;
		case SIGNIN :
			query.append("SELECT * FROM CUSTOMERS " + 
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		}
		
		return query.toString();
	}
}
