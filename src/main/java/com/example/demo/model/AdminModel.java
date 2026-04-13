package com.example.demo.model;

import com.example.demo.entity.Store;

public class AdminModel {
	private String username;
	private String password;
	private String store;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
}
