package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StoreAdmin;
import com.example.demo.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepository repository;

	@Override
	public void save(StoreAdmin sadmin) {
		repository.save(sadmin);
		
	}

	@Override
	public StoreAdmin findByUsername(String name) {
		repository.findByUsername(name);
		  return repository.findByUsername(name);
	}
}
