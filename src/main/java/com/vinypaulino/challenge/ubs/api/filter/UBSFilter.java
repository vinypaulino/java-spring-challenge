package com.vinypaulino.challenge.ubs.api.filter;

import lombok.Data;

@Data
public class UBSFilter {
	 
	
	public UBSFilter(double latitude, double longitude, int page, int per_page) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.page = page;
		this.per_page = per_page;
	}
	public UBSFilter() {
		// TODO Auto-generated constructor stub
	}
	private double latitude;
	private double longitude;
	private int page;
	private int per_page;
	
}
