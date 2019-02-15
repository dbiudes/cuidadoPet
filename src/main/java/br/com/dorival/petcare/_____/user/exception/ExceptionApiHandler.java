package br.com.dorival.petcare._____.user.exception;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import br.com.dorival.petcare.Util_Internalization;

//import br.com.dorival.petcare.PetCareConfig;

//import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class ExceptionApiHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private Util_Internalization i18n;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionApiDetails errorDetails = new ExceptionApiDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ExceptionApiDetails errorDetails = new ExceptionApiDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionApiDetails errorDetails = new ExceptionApiDetails( new Date(), i18n.Translate("error.validation"), FormatardErros(ex.getBindingResult().getFieldErrors()) );
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}

	private String FormatardErros(List<org.springframework.validation.FieldError> fieldErrors) { 
		String listErrors = ""; int pos = 1;
		for (org.springframework.validation.FieldError fieldError : fieldErrors) {
			String msg = i18n.Translate(fieldError.getDefaultMessage());
			try {
				listErrors += "[" + pos++ + "] " + i18n.Translate("i18.field") + ": " + fieldError.getField() + " - " 
						 + i18n.Translate("i18.criteria") + ": " + i18n.Translate(fieldError.getDefaultMessage()) + " ";	
			} catch (Exception ex) {
				listErrors += "[" + pos++ + "] Campo: " + fieldError.getField() + " - Criterio: " + fieldError.getDefaultMessage() + " ";
				System.out.println("*** ERRO DE TRADUCAO - CHAVE: " + fieldError.getField() + " / MENSAGEM: " + fieldError.getDefaultMessage() + " ***");
			}
		}
		return listErrors;
	}
	
	

}