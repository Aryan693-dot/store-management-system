package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(AdminAlreadyExistsException.class)
	    public String handleAdminExists(AdminAlreadyExistsException ex, Model model) {

	        model.addAttribute("error", ex.getMessage());

	        return "register"; // go back to register page
	    }
	  @ExceptionHandler(NoSuchStoreAvailable.class)
	  public String handleAdminExists(NoSuchStoreAvailable ex,Model model) {
		  model.addAttribute("error", ex.getMessage());
		  return "register"; 
	  }
	  
}
