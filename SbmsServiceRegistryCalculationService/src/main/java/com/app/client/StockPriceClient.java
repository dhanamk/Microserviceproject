package com.app.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCKPRICE-SERVICE")
@RibbonClient(name = "STOCKPRICE-SERVICE")
public interface StockPriceClient {
	@GetMapping("/prices/getPrice/{companyName}")
	public ResponseEntity<Double> invoiceStockService(@PathVariable("companyName")String companyName);
}
