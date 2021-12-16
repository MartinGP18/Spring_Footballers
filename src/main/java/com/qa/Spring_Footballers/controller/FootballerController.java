package com.qa.Spring_Footballers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.Spring_Footballers.domain.Footballer;
import com.qa.Spring_Footballers.service.FootballerService;

@RestController
@RequestMapping("/footballer")
public class FootballerController {
	
	private FootballerService service;
	
	private FootballerController(FootballerService service) {
		this.service = service;
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Footballer> createFootballer(@RequestBody Footballer footballer) {
		return new ResponseEntity<Footballer>(this.service.create(null), HttpStatus.CREATED);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Footballer>> readAllFootballers(){
		return new ResponseEntity<List<Footballer>>(this.service.getAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<Footballer> readFootballerById(@PathVariable long id){
		return new ResponseEntity<Footballer>(this.service.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Footballer> updateFootballer(@PathVariable long id, @RequestBody Footballer footballer){
		return new ResponseEntity<Footballer>(this.service.update(id, footballer), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteFootballer(@PathVariable long id){
		return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
