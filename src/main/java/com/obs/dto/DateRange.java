package com.obs.dto;

import java.time.LocalDate;

public class DateRange {
	private LocalDate date1;
	private LocalDate date2;
	public LocalDate getDate1() {
		return date1;
	}
	public void setDate1(LocalDate date1) {
		this.date1 = date1;
	}
	public LocalDate getDate2() {
		return date2;
	}
	public void setDate2(LocalDate date2) {
		this.date2 = date2;
	}
	
}
