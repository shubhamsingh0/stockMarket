package com.StockMarket.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class StockPrice {
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stockPriceId;
	@OneToOne(targetEntity=Company.class)
	private Company companyId;
	@OneToOne(targetEntity=StockExchange.class)
	private StockExchange stockExchangeId;
	
	private int currentPrice;
	
	private Date date;

	private Date time;
	public Company getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}
	public StockExchange getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(StockExchange stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	public int getStockPriceId() {
		return stockPriceId;
	}
	public void setStockPriceId(int stockPriceId) {
		this.stockPriceId = stockPriceId;
	}
	
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + currentPrice;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((stockExchangeId == null) ? 0 : stockExchangeId.hashCode());
		result = prime * result + stockPriceId;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockPrice other = (StockPrice) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (currentPrice != other.currentPrice)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (stockExchangeId == null) {
			if (other.stockExchangeId != null)
				return false;
		} else if (!stockExchangeId.equals(other.stockExchangeId))
			return false;
		if (stockPriceId != other.stockPriceId)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockPrice [stockPriceId=" + stockPriceId + ", companyId=" + companyId + ", stockExchangeId="
				+ stockExchangeId + ", currentPrice=" + currentPrice + ", date=" + date + ", time=" + time + "]";
	}
	
}
