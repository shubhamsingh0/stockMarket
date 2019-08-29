package com.StockMarket.Exception;

public class StockMarketExceptionHandler extends Exception {

	private String message;

	public StockMarketExceptionHandler(String message) {
		super();
		this.message = message;
		System.out.println(this.message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
