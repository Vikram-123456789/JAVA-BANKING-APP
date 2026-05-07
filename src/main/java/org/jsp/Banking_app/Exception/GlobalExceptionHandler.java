package org.jsp.Banking_app.Exception;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.jsp.product_app.Exception.ResourcesNotFoundException;



public class GlobalExceptionHandler {
	@ExceptionHandler(value = ResourcesNotFoundException.class)
	public ResponseEntity<String> handleResoursesNotFoundException(ResourcesNotFoundException ex) {
		ResponseEntity<String> rs=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
		return rs;
	}
	
	public ResponseEntity<LinkedHashMap<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		LinkedHashMap<String, String> lm=new LinkedHashMap<String, String>();
		
		List<FieldError> errors=ex.getBindingResult().getFieldErrors();
		
		for(FieldError er:errors) {
			String field=er.getField();
			String msg=er.getDefaultMessage();
			
			
			lm.put(field,msg);
		}
		return new ResponseEntity<LinkedHashMap<String, String>>(lm,HttpStatus.BAD_REQUEST);
	}

}
