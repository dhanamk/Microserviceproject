package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CompanyNotAvailableException;
import com.app.model.StockPrice;
import com.app.repo.StockpriceRepository;
import com.app.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	@Autowired
	private StockpriceRepository stockpriceRepository;
	@Override
	public Double getStockPrice(String companyName) {
		StockPrice entity = stockpriceRepository.findByCompanyName(companyName);
		if (entity == null) {
			throw new CompanyNotAvailableException("Company not available in Price Service");
		}
		Double companyPrice = entity.getCompanyPrice();
		return companyPrice;
	}
}
