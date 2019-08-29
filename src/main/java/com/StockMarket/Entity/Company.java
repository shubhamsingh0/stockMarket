package com.StockMarket.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

@Entity
@Table(name="company")
public class Company {
	@Id
	@Column
	private String companyId;
	@Column
	private String companyName;
	@Column
	private int companyTurnOver;
	@Column
	private String companyCeo;
	@Column
	private String companySector;
	@Column
	private String companyBrief;
	@Column
	private int companyStockCode;
	
	
	@OneToMany(targetEntity=Directors.class,cascade=CascadeType.MERGE)
	private List<Directors> directorName=new ArrayList<Directors>();
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyTurnOver() {
		return companyTurnOver;
	}
	public void setCompanyTurnOver(int companyTurnOver) {
		this.companyTurnOver = companyTurnOver;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public String getCompanySector() {
		return companySector;
	}
	public void setCompanySector(String companySector) {
		this.companySector = companySector;
	}
	public String getCompanyBrief() {
		return companyBrief;
	}
	public void setCompanyBrief(String companyBrief) {
		this.companyBrief = companyBrief;
	}
	public int getCompanyStockCode() {
		return companyStockCode;
	}
	public void setCompanyStockCode(int companyStockCode) {
		this.companyStockCode = companyStockCode;
	}
	public List<Directors> getDirectorName() {
		return directorName;
	}
	public void setDirectorName(List<Directors> directorName) {
		this.directorName = directorName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyBrief == null) ? 0 : companyBrief.hashCode());
		result = prime * result + ((companyCeo == null) ? 0 : companyCeo.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((companySector == null) ? 0 : companySector.hashCode());
		result = prime * result + companyStockCode;
		result = prime * result + companyTurnOver;
		result = prime * result + ((directorName == null) ? 0 : directorName.hashCode());
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
		Company other = (Company) obj;
		if (companyBrief == null) {
			if (other.companyBrief != null)
				return false;
		} else if (!companyBrief.equals(other.companyBrief))
			return false;
		if (companyCeo == null) {
			if (other.companyCeo != null)
				return false;
		} else if (!companyCeo.equals(other.companyCeo))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companySector == null) {
			if (other.companySector != null)
				return false;
		} else if (!companySector.equals(other.companySector))
			return false;
		if (companyStockCode != other.companyStockCode)
			return false;
		if (companyTurnOver != other.companyTurnOver)
			return false;
		if (directorName == null) {
			if (other.directorName != null)
				return false;
		} else if (!directorName.equals(other.directorName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyTurnOver="
				+ companyTurnOver + ", companyCeo=" + companyCeo + ", companySector=" + companySector
				+ ", companyBrief=" + companyBrief + ", companyStockCode=" + companyStockCode + ", directorName="
				+ directorName + "]";
	}
	
	
	
}
