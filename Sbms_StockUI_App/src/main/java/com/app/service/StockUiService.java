package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUiService {
	
	public String getTotalStockPrice(String companyName,Integer qty)
	{
		String REST_ENDPOINT="http://localhost:3333/stock/calc/calculate/{companyName}/{qty}";
		String response=null;
		WebClient webClient=WebClient.create();
		try {
			response=webClient.get()
					.uri(REST_ENDPOINT, companyName,qty)
					.retrieve()
					.bodyToMono(String.class)
					.block();
		} catch (Exception e) {
			e.printStackTrace();
			response="Company not found in API Gateway";
		}
		return response;
	}
}
