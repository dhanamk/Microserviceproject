package com.app.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.StockCalculationService;

@RestController
@RequestMapping("/calc")
public class StockCalculatorRestController {

	@Autowired
	private Environment env;
	
	@Autowired
	private StockCalculationService calculatorService;
	@GetMapping("/calculate/{companyName}/{qty}")
	public ResponseEntity<String> getTotalCost(@PathVariable("companyName")String companyName,
												@PathVariable("qty")Integer qty)
	{
		Double companyPrice=calculatorService.getCompanyPrice(companyName);
		Double totalcost=companyPrice*qty;
		String portNumber = env.getProperty("local.server.port");
		
		String resMsg="Total cost :: "+totalcost+"Calcualtion port number is :: "+portNumber;
		
		return new ResponseEntity<>(resMsg,HttpStatus.OK);
	}
}
