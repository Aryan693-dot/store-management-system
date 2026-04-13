package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Items;
import com.example.demo.entity.Store;
import com.example.demo.entity.StoreAdmin;
import com.example.demo.model.ItemModel;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.ItemService;
import com.example.demo.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

   

    @Autowired
    private ItemService itemService;

//    @Autowired
//    StoreService storeService;

    @GetMapping("/addItem")
    public String addItemPage() {
        return "addItem";
    }

  
    @PostMapping("/saveItem")
    public String saveItem(ItemModel model, HttpSession session) {

        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "login";
        }

        Items item = new Items();
        item.setName(model.getName());
        item.setPrice(model.getPrice());
        item.setQuantity(model.getQuantity());
        item.setStore(store);

        itemService.save(item);

        return "home";
    }

 
    @GetMapping("/viewItems")
    public String viewItems(
            Model model,
            HttpSession session,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "name") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "") String keyword) {

        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "login";
        }

        int pageSize = 5;

        Sort sort = sortDir.equals("asc") ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page, pageSize, sort);

        Page<Items> itemPage;

        if (keyword != null && !keyword.isEmpty()) {
            itemPage = itemService.findByStoreAndName(store, keyword, pageable);
        } else {
            itemPage = itemService.findByStore(store, pageable);
        }

        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);

        return "viewItems";
    }
    

    @GetMapping("/removeItem")
    public String removeItemPage(Model model, HttpSession session) {

        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "login";
        }

        List<Items> items = itemService.findByStore(store);

        model.addAttribute("items", items);

        return "removeItem";
    }
    @PostMapping("/deleteItem")
    public String deleteItem(@RequestParam("id") Integer id, HttpSession session) {

        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "login";
        }

        Items item = itemService.findById(id);

        if (item != null &&
            item.getStore().getI_id().equals(store.getI_id())) {

            itemService.deleteById(id);
        }

        return "redirect:/viewItems";
    }
    @GetMapping("/editItem")
    public String editItem(@RequestParam("id") Integer id, Model model) {

        Items item = itemService.findById(id);

        model.addAttribute("item", item);

        return "editItem";
    }
    
    @GetMapping("/salesReport")
    public String salesReport(Model model, HttpSession session) {

        //Get store from session
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "redirect:/";
        }

        //Get items of that store
        List<Items> items = itemService.findByStore(store);

        //Calculate total sales
        double totalSales = 0;
        for (Items item : items) {
        	totalSales += item.getPrice() * item.getSold();
        }
        // Find low stock items
        List<Items> lowStockItems = new ArrayList<>();
        for (Items item : items) {
            if (item.getQuantity() < 5) {
                lowStockItems.add(item);
            }
        }
        //Send data to JSP
        model.addAttribute("totalSales", totalSales);
        model.addAttribute("lowStockItems", lowStockItems);
        model.addAttribute("items", items); // optional (for table)

        return "salesReport";
    }
    @PostMapping("/updateItem")
    public String updateItem(
            @RequestParam("i_id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("quantity") Integer quantity,
            HttpSession session) {

        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "login";
        }

        Items existingItem = itemService.findById(id);

        if (existingItem != null &&
            existingItem.getStore().getI_id().equals(store.getI_id())) {

            existingItem.setName(name);
            existingItem.setPrice(price);
            existingItem.setQuantity(quantity);

            itemService.save(existingItem);
        }

        return "redirect:/viewItems";
    }
    
   
    @GetMapping("/back")
    public String back() {
    	return "home";
    }
    @PostMapping("/sellItem")
    public String sellItem(@RequestParam("id") Integer id, HttpSession session) {

        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return "login";
        }

        Items item = itemService.findById(id);

        if (item != null && item.getQuantity() > 0) {

            item.setQuantity(item.getQuantity() - 1);

            if (item.getSold() == null) {
                item.setSold(1);
            } else {
                item.setSold(item.getSold() + 1);
            }

            itemService.save(item);
        }

        return "redirect:/viewItems";
    }
}
