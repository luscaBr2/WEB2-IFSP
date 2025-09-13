package br.edu.ifspcjo.ads.cjoweb2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
	String description, date;
	int id;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
