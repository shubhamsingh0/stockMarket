package com.StockMarket.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.StockMarket.Entity.Company;
@Entity
@Table(name="Directors")
public class Directors {
	@Id
	@Column(name="directorsId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int directorsId;
	@Column(name="directorsName")
	private String name;
	public int getdirectorsId() {
		return directorsId;
	}
	public void setdirectorsId(int directorsId) {
		this.directorsId =directorsId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + directorsId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Directors other = (Directors) obj;
		
		if (directorsId != other.directorsId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Directors [directorsId=" + directorsId  + ", name=" + name + "]";
	}

	
}
