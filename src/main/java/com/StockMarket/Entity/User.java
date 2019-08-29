package com.StockMarket.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="idUser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column
	private String username;
	@Column
	private String	password;
	@Column
	private String	userType;
	@Column
	private String email;
	@Column
	private long mobileNumber;
	@Column
	private int statusConfirmed;
	
	public User(int userId, String username, String password, String userType, String email, long mobileNumber,
			int statusConfirmed) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.statusConfirmed = statusConfirmed;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int userId2, String username2, String userType2, String email2, long mobileNumber2) {
		this.userId = userId2;
		this.username = username2;
		this.userType = userType2;
		this.email = email2;
		this.mobileNumber = mobileNumber2;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getStatusConfirmed() {
		return statusConfirmed;
	}
	public void setStatusConfirmed(int statusConfirmed) {
		this.statusConfirmed = statusConfirmed;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (mobileNumber ^ (mobileNumber >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + statusConfirmed;
		result = prime * result + userId;
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobileNumber != other.mobileNumber)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (statusConfirmed != other.statusConfirmed)
			return false;
		if (userId != other.userId)
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", statusConfirmed=" + statusConfirmed + "]";
	}

}
