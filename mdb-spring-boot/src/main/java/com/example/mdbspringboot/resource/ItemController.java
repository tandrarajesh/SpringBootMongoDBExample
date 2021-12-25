package com.example.mdbspringboot.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mdbspringboot.model.GroceryItem;
import com.example.mdbspringboot.repository.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	ItemRepository itemRepository;
	
	@PostMapping("/additem")
	public String saveItem(@RequestBody GroceryItem groceryItem){
		itemRepository.save(groceryItem);
		return "Added grocery with id "+ groceryItem.getId();
	}
	
	@GetMapping("/finaAllItems")
	public List<GroceryItem> getItem(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/findAllItems/{id}")
	public Optional<GroceryItem> getItem(@PathVariable int id) {
		return itemRepository.findById(id);
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public String deleteItem(@PathVariable int id) {
		itemRepository.deleteById(id);
		return "Item deleted with id "+ id;
	}
}
