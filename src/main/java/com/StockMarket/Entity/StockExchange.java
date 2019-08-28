package com.StockMarket.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StockExchange {
	@Id
	
	private int stockExchangeId;
	
	private String stockExchangeName;
	
	private String stockExchangeBrief;

	private String stockExchangeAddress;
	
	private String stockExchangeRemarks;
	
	public int getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(int stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getStockExchangeBrief() {
		return stockExchangeBrief;
	}
	public void setStockExchangeBrief(String stockExchangeBrief) {
		this.stockExchangeBrief = stockExchangeBrief;
	}
	public String getStockExchangeAddress() {
		return stockExchangeAddress;
	}
	public void setStockExchangeAddress(String stockExchangeAddress) {
		this.stockExchangeAddress = stockExchangeAddress;
	}
	public String getStockExchangeRemarks() {
		return stockExchangeRemarks;
	}
	public void setStockExchangeRemarks(String stockExchangeRemarks) {
		this.stockExchangeRemarks = stockExchangeRemarks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockExchangeAddress == null) ? 0 : stockExchangeAddress.hashCode());
		result = prime * result + ((stockExchangeBrief == null) ? 0 : stockExchangeBrief.hashCode());
		result = prime * result + stockExchangeId;
		result = prime * result + ((stockExchangeName == null) ? 0 : stockExchangeName.hashCode());
		result = prime * result + ((stockExchangeRemarks == null) ? 0 : stockExchangeRemarks.hashCode());
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
		StockExchange other = (StockExchange) obj;
		if (stockExchangeAddress == null) {
			if (other.stockExchangeAddress != null)
				return false;
		} else if (!stockExchangeAddress.equals(other.stockExchangeAddress))
			return false;
		if (stockExchangeBrief == null) {
			if (other.stockExchangeBrief != null)
				return false;
		} else if (!stockExchangeBrief.equals(other.stockExchangeBrief))
			return false;
		if (stockExchangeId != other.stockExchangeId)
			return false;
		if (stockExchangeName == null) {
			if (other.stockExchangeName != null)
				return false;
		} else if (!stockExchangeName.equals(other.stockExchangeName))
			return false;
		if (stockExchangeRemarks == null) {
			if (other.stockExchangeRemarks != null)
				return false;
		} else if (!stockExchangeRemarks.equals(other.stockExchangeRemarks))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockExchange [stockExchangeId=" + stockExchangeId + ", stockExchangeName=" + stockExchangeName
				+ ", stockExchangeBrief=" + stockExchangeBrief + ", stockExchangeAddress=" + stockExchangeAddress
				+ ", stockExchangeRemarks=" + stockExchangeRemarks + "]";
	}
	
}
