package com.obs.dto;

public class Transfer {
	private String fromaccno;
	private String toaccno;
	private String amount;
	private String txndetails;
	public String getFromaccno() {
		return fromaccno;
	}
	public void setFromaccno(String fromaccno) {
		this.fromaccno = fromaccno;
	}
	public String getToaccno() {
		return toaccno;
	}
	public void setToaccno(String toaccno) {
		this.toaccno = toaccno;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTxndetails() {
		return txndetails;
	}
	public void setTxndetails(String txndetails) {
		this.txndetails = txndetails;
	}
	
	
}
