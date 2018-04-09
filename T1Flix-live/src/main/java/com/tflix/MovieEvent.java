package com.tflix;

import java.util.Date;

public class MovieEvent {

	private String title;
	private Date date;

	public MovieEvent() {

	}

	public MovieEvent(String title, Date date) {
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
