package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Items;
import com.example.demo.entity.Store;

public interface ItemService {
	void saveItem(Items item);

    List<Items> getItemsByStore(Store store);

    void deleteItem(Integer id);

    Items getItemById(Integer id);

    void updateItem(Items item);

    void sellItem(Integer id);

	void save(Items item);

	List<Items> findByStore(Store store);

	Items findById(Integer id);

	void deleteById(Integer id);

	Page<Items> findByStore(Store store, Pageable pageable);
	
	public Page<Items> findByStoreAndName(Store store, String keyword, Pageable pageable);
}
