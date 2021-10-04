package com.obs.pojo;

import javax.persistence.*;

@Entity
	@Table(name = "OBS_TBL_ACCOUNT")
public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "ACCID")
		private int accId;

		@Column(name = "PASS")
		private String pass;

		@Column(name = "TXPASS")
		private String txPass;

		@Column(name = "ATTEMPT")
		private int attempt;
		
		@Column(name = "Registered")
		private String isRegistered="0";
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "ACCNO")
		Customer customer;

		public String getIsRegistered() {
			return isRegistered;
		}




		public void setIsRegistered(String isRegistered) {
			this.isRegistered = isRegistered;
		}




		public Customer getCustomer() {
			return customer;
		}




		public void setCustomer(Customer customer) {
			this.customer = customer;
		}




		public String getisRegistered() {
			return isRegistered;
		}

		
		

		public void setisRegistered(String register) {
			this.isRegistered = register;
		}




		public int getAccId() {
			return accId;
		}

		public void setAccId(int accId) {
			this.accId = accId;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getTxPass() {
			return txPass;
		}

		public void setTxPass(String txPass) {
			this.txPass = txPass;
		}

		public int getAttempt() {
			return attempt;
		}

		public void setAttempt(int attempt) {
			this.attempt = attempt;
		}


}
