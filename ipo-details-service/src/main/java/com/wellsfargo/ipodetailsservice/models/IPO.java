package com.wellsfargo.ipodetailsservice.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ipo_details")
public class IPO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique=true)
	private String company_name;
	@Column(unique=true)
	private String se_name;
	private double price_per_share;
	private double total_shares;
	private Timestamp open_date_time;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getSe_name() {
		return se_name;
	}
	public void setSe_name(String se_name) {
		this.se_name = se_name;
	}
	public double getPrice_per_share() {
		return price_per_share;
	}
	public void setPrice_per_share(double price_per_share) {
		this.price_per_share = price_per_share;
	}
	public double getTotal_shares() {
		return total_shares;
	}
	public void setTotal_shares(double total_shares) {
		this.total_shares = total_shares;
	}
	public Timestamp getOpen_date_time() {
		return open_date_time;
	}
	public void setOpen_date_time(Timestamp open_date_time) {
		this.open_date_time = open_date_time;
	}

}
