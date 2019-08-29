package com.StockMarket.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="IPO")
public class IPO {
	@Id
	
	private int id;
	
	@OneToOne(targetEntity=Company.class)
	private Company companyId;
	
	@OneToOne(targetEntity=StockExchange.class)
	private StockExchange stockExchangeid;

	private int pricePerShare;
	
	private int totalNumberOfShares;
	
	private Date dateAndtime;
	
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Company getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}
	public StockExchange getStockExchangeid() {
		return stockExchangeid;
	}
	public void setStockExchangeid(StockExchange stockExchangeid) {
		this.stockExchangeid = stockExchangeid;
	}
	public int getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(int pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public int getTotalNumberOfShares() {
		return totalNumberOfShares;
	}
	public void setTotalNumberOfShares(int totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}
	public Date getDateAndtime() {
		return dateAndtime;
	}
	public void setDateAndtime(Date dateAndtime) {
		this.dateAndtime = dateAndtime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((dateAndtime == null) ? 0 : dateAndtime.hashCode());
		result = prime * result + id;
		result = prime * result + pricePerShare;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((stockExchangeid == null) ? 0 : stockExchangeid.hashCode());
		result = prime * result + totalNumberOfShares;
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
		IPO other = (IPO) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (dateAndtime == null) {
			if (other.dateAndtime != null)
				return false;
		} else if (!dateAndtime.equals(other.dateAndtime))
			return false;
		if (id != other.id)
			return false;
		if (pricePerShare != other.pricePerShare)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (stockExchangeid == null) {
			if (other.stockExchangeid != null)
				return false;
		} else if (!stockExchangeid.equals(other.stockExchangeid))
			return false;
		if (totalNumberOfShares != other.totalNumberOfShares)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IPO [id=" + id + ", companyId=" + companyId + ", stockExchangeid=" + stockExchangeid
				+ ", pricePerShare=" + pricePerShare + ", totalNumberOfShares=" + totalNumberOfShares + ", dateAndtime="
				+ dateAndtime + ", remarks=" + remarks + "]";
	}
	
}
