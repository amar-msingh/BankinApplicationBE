package com.obs.pojo;

import javax.persistence.*;

@Entity
@Table(name = "OBS_TBL_PAYEE")
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAYID")
	private int payid;

	@Column(name = "PAYNAME")
	private String payname;

	@Column(name = "PAYACCNO")
	private String payaccno;

	@Column(name = "PAYNN")
	private String paynn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCNO")
	private Customer customer;

	public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}

	public String getPayname() {
		return payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

	public String getPayaccno() {
		return payaccno;
	}

	public void setPayaccno(String payaccno) {
		this.payaccno = payaccno;
	}

	public String getPaynn() {
		return paynn;
	}

	public void setPaynn(String paynn) {
		this.paynn = paynn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	


	


}
