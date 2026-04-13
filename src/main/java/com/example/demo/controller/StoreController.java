package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Store;
import com.example.demo.model.StoreModel;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;

import jakarta.servlet.http.HttpSession;
@Controller
public class StoreController {
	@Autowired
	StoreService service;
	
	@PostMapping("/registerStore")
	public String registerStore() {
		return "regStore";
	}
	@PostMapping("/regStore")
	public String register(StoreModel store) {
		Store st=new Store();
		st.setName(store.getName());
		service.save(st);
		return "index";
		
	}
	@PostMapping("/deleteStore")
	public String deleteStore(HttpSession session) {

	    Store store = (Store) session.getAttribute("store");

	    if (store != null) {
	        service.deleteStore(store.getI_id());
	    }

	    session.invalidate();
	    return "redirect:/";
	}
}
