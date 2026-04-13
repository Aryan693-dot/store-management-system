package com.example.demo.service;

import com.example.demo.entity.StoreAdmin;

public interface AdminService {

	void save(StoreAdmin sadmin);

	StoreAdmin findByUsername(String name);

}
