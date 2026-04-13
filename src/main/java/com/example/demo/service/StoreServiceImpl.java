package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
@Service
public class StoreServiceImpl implements StoreService{
	@Autowired
	StoreRepository repository;

	@Override
	public Store findByName(String storename) {
		Store store=repository.findByName(storename);
		return store;
	}

	@Override
	public void save(Store st) {
		repository.save(st);
		
	}
	@Override
	public void deleteStore(Integer id) {
	    repository.deleteById(id);
	}
}
