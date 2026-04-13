package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer i_id;
	@Column(unique = true)
	private String name;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Items> li;
	
	@OneToOne(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	private StoreAdmin sAdmin;

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Items> getLi() {
		return li;
	}

	public void setLi(List<Items> li) {
		this.li = li;
	}

	public StoreAdmin getsAdmin() {
		return sAdmin;
	}

	public void setsAdmin(StoreAdmin sAdmin) {
		this.sAdmin = sAdmin;
	}
}
