package com.project383.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "n_value")
	private int nValue;
	
	@Column(name = "result")
	private int result;
	
	@Column(name = "time")
	private String time;
	
	public User() {
		
	}
	
	public User(int nValue, int result, String d) {
		super();
		this.nValue = nValue;
		this.result = result;
		this.time = d;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getnValue() {
		return nValue;
	}

	public void setnValue(int nValue) {
		this.nValue = nValue;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
