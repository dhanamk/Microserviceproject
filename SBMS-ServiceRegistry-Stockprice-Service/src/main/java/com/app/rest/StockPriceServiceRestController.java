package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.StockPriceService;

@RestController
@RequestMapping("/prices")
public class StockPriceServiceRestController {
	@Autowired
	private Environment env;
	
	@Autowired
	private StockPriceService stockPriceService;
	
	@GetMapping("/getPrice/{companyName}")
	public ResponseEntity<Double> getPrice(@PathVariable("companyName")String companyName )
	{
		Double stockPrice=stockPriceService.getStockPrice(companyName);
		String portNumber = env.getProperty("local.server.port");
		System.out.println("port number is :: "+portNumber);
		
		return new ResponseEntity<>(stockPrice,HttpStatus.OK);
	}
}
