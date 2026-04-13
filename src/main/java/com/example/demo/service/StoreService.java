package com.example.demo.service;

import com.example.demo.entity.Store;

public interface StoreService {

	Store findByName(String storename);

	void save(Store st);

	void deleteStore(Integer i_id);

}
