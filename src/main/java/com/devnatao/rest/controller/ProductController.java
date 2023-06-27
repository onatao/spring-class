package com.devnatao.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.devnatao.rest.dto.ProductRecordDTO;
import com.devnatao.rest.model.ProductModel;
import com.devnatao.rest.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;

	@PostMapping
	public ResponseEntity<ProductModel> create(@RequestBody @Valid ProductRecordDTO data) {
		var productModel = new ProductModel();
		BeanUtils.copyProperties(data, productModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(productModel));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ProductModel>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductModel> findById(@PathVariable UUID id) {
		Optional<ProductModel> response = repository.findById(id);
		if (response.isEmpty()) ResponseEntity.status(HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(response.get());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductModel> update(@PathVariable UUID id, @RequestBody @Valid ProductRecordDTO data) {
		// encontrando um optional de ProductModel
		Optional<ProductModel> optionalProduct = repository.findById(id);
		// verificando se é e ou não vazio
		if (optionalProduct.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		var productModel = new ProductModel();
		BeanUtils.copyProperties(data, productModel);
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(productModel));
	}
	
}
