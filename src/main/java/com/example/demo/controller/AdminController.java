package com.example.demo.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Store;
import com.example.demo.entity.StoreAdmin;
import com.example.demo.exception.AdminAlreadyExistsException;
import com.example.demo.exception.NoSuchStoreAvailable;
import com.example.demo.model.AdminModel;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.StoreService;

import jakarta.servlet.http.HttpSession;


@Controller
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private StoreService strService;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@PostMapping("/register")
	public String reg() {
		return"register";
	}
	@PostMapping("/regForm")
	public String register(AdminModel admin) {
	    StoreAdmin sadmin = new StoreAdmin();
	    sadmin.setUsername(admin.getUsername());
	    sadmin.setPassword(admin.getPassword());
	    String storename=admin.getStore();
	    Store store =(Store)strService.findByName(storename);
	    if (store==null)throw new NoSuchStoreAvailable("Store is not present");
	    if (store.getsAdmin() != null) {
	        throw new AdminAlreadyExistsException("Admin already exists for this store!");
	    }

	    if (store != null) {
	        sadmin.setStore(store);      
	        store.setsAdmin(sadmin); 
	        adminservice.save(sadmin);
	    }
	    
	    return "login";
	}
	
	@PostMapping("/login")
	public String login(AdminModel admin, HttpSession session) {

		if (admin.getUsername() == null || admin.getPassword() == null) {
	        return "login";  
	    }
	    String name = admin.getUsername().trim();
	    String password = admin.getPassword().trim();

	    StoreAdmin adm =adminservice.findByUsername(name);

	    if (adm != null && password.equals(adm.getPassword())) {

	        session.setAttribute("user", adm);  
	        session.setAttribute("store", adm.getStore());

	        return "home";
	    }

	    return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {

	    session.invalidate();   

	    return "redirect:/";   
	}
	
	
	
}
