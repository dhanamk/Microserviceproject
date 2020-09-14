package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.client.StockPriceClient;
import com.app.exception.CompanyNotFoundException;
import com.app.service.StockCalculationService;

@Service
public class StockCalculationServiceImpl implements StockCalculationService {
	@Autowired
	private StockPriceClient stockPriceClient;

	@Override
	public Double getCompanyPrice(String companyName) {
		ResponseEntity<Double> resEntity = null;

		try {
			resEntity = stockPriceClient.invoiceStockService(companyName);
			if (resEntity != null && resEntity.getStatusCodeValue() == 200) {
				return resEntity.getBody();
			}
		} catch (Exception e) {

			if (e.getMessage().contains("400"))
				throw new CompanyNotFoundException("Company not Found in Cal Service");
		}
		
		return null;
	}
}
