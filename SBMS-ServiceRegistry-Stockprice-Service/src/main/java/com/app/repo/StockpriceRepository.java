package com.app.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.StockPrice;

public interface StockpriceRepository extends JpaRepository<StockPrice, Serializable>{

	public StockPrice findByCompanyName(String companyName);
	
}
