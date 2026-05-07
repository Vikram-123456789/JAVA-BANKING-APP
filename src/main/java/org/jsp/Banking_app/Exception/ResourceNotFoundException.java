package org.jsp.Banking_app.Exception;

public class ResourceNotFoundException extends RuntimeException{
	String resoursesName;
	String fieldName;
	long fieldId;
	public ResourceNotFoundException(String resoursesName, String fieldName, long fieldId) {
		super();
		this.resoursesName = resoursesName;
		this.fieldName = fieldName;
		this.fieldId = fieldId;
	}
	@Override
	public String getMessage() {
		return resoursesName +"not found for"+ fieldName +"="+fieldId;
	}
	

}
