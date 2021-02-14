package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;



@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emalEmailService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "hello this s email servives";
	}
	
	//api to send email
			@RequestMapping(value = "/sendemail",method = RequestMethod.POST)
			public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
			{
		
				//this.emalEmailService.sendEmail(subject, message, to)
			
			System.out.println(request);
			boolean result =  this.emalEmailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
			if(result)
			{
			//	return ResponseEntity.ok("Email is send successfully");
				return ResponseEntity.ok(new EmailResponse("Email is send successfully"));
			}else {
				//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not send");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not send"));
			}
			
			
			}

}
