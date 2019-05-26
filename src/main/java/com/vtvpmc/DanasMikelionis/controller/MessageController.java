package com.vtvpmc.DanasMikelionis.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
	@RequestMapping("/admin/secretMessages/checkIfAdmin")
	public boolean checkIfAdmin() {
		return true;
	}
	
	@RequestMapping("/admin/secretMessages/calculateSum/{firstNumber}/{secondNumber}")
	public String calculateSum(@PathVariable Long firstNumber, @PathVariable Long secondNumber) {
		return firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber);
	}
}
