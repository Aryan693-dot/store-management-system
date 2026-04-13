package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StoreAdmin;

public interface AdminRepository extends JpaRepository<StoreAdmin, Integer>{

	 StoreAdmin findByUsername(String username);

	String findByPassword(String password);

}
