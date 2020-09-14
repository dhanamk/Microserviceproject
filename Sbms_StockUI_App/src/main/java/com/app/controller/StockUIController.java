package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.StockUiService;

@Controller
@RequestMapping("/stock")
public class StockUIController {
	@Autowired
	private StockUiService service;

	@GetMapping("/")
	public String loadForm() {
		return "index";
	}

	@GetMapping("/getTotalCost")
	public String handleGetTotalCost(HttpServletRequest req, Model model) {
		String companyName = req.getParameter("companyName");
		String qty = req.getParameter("qty");
		String response = service.getTotalStockPrice(companyName, Integer.parseInt(qty));
		model.addAttribute("msg", response);
		return "index";
	}
}
