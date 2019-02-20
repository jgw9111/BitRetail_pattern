package enums;

public enum ImageSQL {
	IMAGE_STORE,LASTIMAGE_SEQ,SELECT_ONE_IMG;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case IMAGE_STORE: 
			query.append("INSERT INTO IMAGES(IMG_SEQ,IMG_NAME,IMG_EXTENTION,OWNER) "
					+ "VALUES(IMG_SEQ.NEXTVAL,?,?,?)");
			break;
		case LASTIMAGE_SEQ: 
			query.append(" SELECT IMG_SEQ \n" + 
					" FROM IMAGES \n" + 
					" WHERE IMG_SEQ LIKE ((SELECT MAX(IMG_SEQ) \n" + 
					" FROM IMAGES))");
			break;
		case SELECT_ONE_IMG:
			query.append("SELECT * FROM IMAGES WHERE IMG_SEQ LIKE ?");
			break;
		}
		return query.toString();
	}
}
