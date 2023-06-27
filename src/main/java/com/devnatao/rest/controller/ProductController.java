package com.devnatao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devnatao.rest.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;

}
