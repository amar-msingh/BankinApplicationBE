package com.obs.pojo;

import javax.persistence.*;

@Entity
@Table(name = "OBS_TBL_ADMIN")
public class Admin {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PASS")
	private String pass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}