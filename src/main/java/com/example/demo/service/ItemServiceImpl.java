package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Items;
import com.example.demo.entity.Store;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepo;

    @Override
    public void saveItem(Items item) {
        itemRepo.save(item);
    }

    @Override
    public List<Items> getItemsByStore(Store store) {
        return itemRepo.findByStore(store);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepo.deleteById(id);
    }

    @Override
    public Items getItemById(Integer id) {
        return itemRepo.findById(id).orElse(null);
    }

    @Override
    public void updateItem(Items item) {
        itemRepo.save(item);
    }

    @Override
    public void sellItem(Integer id) {

        Items item = itemRepo.findById(id).orElse(null);

        if (item != null && item.getQuantity() > 0) {

            item.setQuantity(item.getQuantity() - 1);

            if (item.getSold() == null) {
                item.setSold(1);
            } else {
                item.setSold(item.getSold() + 1);
            }

            itemRepo.save(item);
        }
    }

	@Override
	public void save(Items item) {
		itemRepo.save(item);
		
	}

	@Override
	public List<Items> findByStore(Store store) {
		List<Items> li=itemRepo.findByStore(store);
		return li;
	}

	@Override
	public Items findById(Integer id) {
		Items item=itemRepo.findById(id).orElse(null);
		return item;
	}

	@Override
	public void deleteById(Integer id) {
		Items item=itemRepo.findById(id).orElse(null);
		itemRepo.delete(item);
	}

	@Override
	public Page<Items> findByStore(Store store, Pageable pageable) {
		Page<Items> itemPage = itemRepo.findByStore(store, pageable);
		return itemPage;
	}

	@Override
	public Page<Items> findByStoreAndName(Store store, String keyword, Pageable pageable) {
		  return itemRepo.findByStoreAndNameContainingIgnoreCase(store, keyword, pageable);
	}

	
}
