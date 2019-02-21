package enums;

public enum CustomerSQL {
	SIGNUP,SIGNIN,LIST,ROW_COUNT,CUST_PHONE,CUST_RETRIEVE,CUST_UPDATE,CUST_DELETE;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case SIGNUP : 
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHOEN_NUMBER,CITY,ADDRESS,POSTAL_CODE,PHOTO)\n" + 
					"VALUES(?,?,?,?,?,?,?,?,'1040')");
			break;
		case SIGNIN :
			query.append("SELECT * FROM CUSTOMERS " + 
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		case LIST: 
			query.append("SELECT T2.*\n" + 
					"FROM (SELECT ROWNUM R2,T.*\n" + 
					"    FROM (SELECT ROWNUM AS RNUM,C.* \n" + 
					"        FROM CUSTOMERS C \n" + 
					"        ORDER BY ROWNUM DESC)T) T2\n" + 
					"WHERE R2 BETWEEN ? AND ?\n"  );
			break;
		case ROW_COUNT:
			query.append("SELECT COUNT(*) COUNT " + 
						"FROM CUSTOMERS ");
			break;
		case CUST_PHONE:
			query.append("SELECT * \n" + 
						"FROM CUSTOMERS");
			break;
		case CUST_RETRIEVE:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
		case CUST_UPDATE:
			query.append("UPDATE CUSTOMERS \n" + 
					"SET PHOEN_NUMBER = ?,\n" + 
					"    CITY = ?,\n" + 
					"    ADDRESS = ?,\n" + 
					"    POSTAL_CODE = ?,\n" + 
					"    PASSWORD = ? \n" + 
					"WHERE CUSTOMER_ID LIKE ?");
			break;
		case CUST_DELETE:
			query.append("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
		}
		
		return query.toString();
	}
}
