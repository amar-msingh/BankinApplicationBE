package com.obs.pojo;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "OBS_TBL_TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TXID")
	private int txId;

	@Column(name = "TXDETAILS")
	private String txDetails;

	@Column(name = "TXDATE")
	private LocalDateTime txDate;

	@Column(name = "TXTYPE")
	private String txType;

	@Column(name = "TXAMOUNT")
	private String txAmount;

	@Column(name = "TXBAL")
	private String txbal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCNO")
	private Customer customer;

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public String getTxDetails() {
		return txDetails;
	}

	public void setTxDetails(String txDetails) {
		this.txDetails = txDetails;
	}

	public LocalDateTime getTxDate() {
		return txDate;
	}

	public void setTxDate(LocalDateTime txDate) {
		this.txDate = txDate;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public String getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(String txAmount) {
		this.txAmount = txAmount;
	}

	public String getTxbal() {
		return txbal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTxbal(String txbal) {
		this.txbal = txbal;
	}


		


}