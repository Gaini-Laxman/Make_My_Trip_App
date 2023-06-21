package com.klinnovations.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.klinnovations.controller.MakeMyTripController;

	
@ControllerAdvice
public class AppExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(MakeMyTripController.class);

	
	@ExceptionHandler(value = Exception.class) //Exception- super class of any exception
	   public String handlerAE(Exception ae) {
		String msg = ae.getMessage(); 
		logger.error(msg); 
		return "errorPage"; }

}
