package com.example.demo.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Items;
import com.example.demo.entity.Store;

public interface ItemRepository extends JpaRepository<Items, Integer>{
	List<Items> findByStore(Store store);
	 Page<Items> findByStore(Store store, Pageable pageable);
	 Page<Items> findByStoreAndNameContainingIgnoreCase(
		        Store store, String name, Pageable pageable);
}
