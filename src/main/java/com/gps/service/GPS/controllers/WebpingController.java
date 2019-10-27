package com.gps.service.GPS.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Check if the application has started.
 */

@Controller
public class WebpingController {

	@GetMapping(value = "/webping")
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<>("Service is running", HttpStatus.OK);
	}
}
