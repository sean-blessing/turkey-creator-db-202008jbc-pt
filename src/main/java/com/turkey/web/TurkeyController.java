package com.turkey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.turkey.business.Turkey;
import com.turkey.db.TurkeyRepo;

@CrossOrigin
@RestController
@RequestMapping("/turkeys")
public class TurkeyController {
	/*
	 *  A controller will implement 5 CRUD methods:
	 *  1) GET ALL
	 *  2) GET BY ID
	 *  3) POST - Insert / Create
	 *  4) PUT - Update
	 *  5) DELETE - Delete
	 */
	
	@Autowired
	private TurkeyRepo turkeyRepo;
	
	//Get all turkeys
	@GetMapping("/")
	public List<Turkey> getAll() {
		return turkeyRepo.findAll();
	}
	
	//Get a turkey by id
	@GetMapping("/{id}")
	public Optional<Turkey> getById(@PathVariable int id) {
		return turkeyRepo.findById(id);
	}
	
	//Add a turkey
	@PostMapping("/")
	public Turkey addTurkey(@RequestBody Turkey t) {
		t = turkeyRepo.save(t);
		return t;
	}
	
	//Update a turkey
	@PutMapping("/")
	public Turkey updateTurkey(@RequestBody Turkey t) {
		t = turkeyRepo.save(t);
		return t;
	}
	
	//Delete a turkey
	@DeleteMapping("/{id}")
	public Turkey deleteTurkey(@PathVariable int id) {
		//Optional type will wrap a turkey
		Optional<Turkey> t = turkeyRepo.findById(id);
		//isPresent() will return true if a turkey was found
		if (t.isPresent()) {
			turkeyRepo.deleteById(id);
		}
		else {
			System.out.println("Error - turkey not found for id "+id);
		}
		return t.get();
	}
	
	
	
	

}
