package com.rafaelfilho.dscommerce.controllers;

import com.rafaelfilho.dscommerce.dto.CategoryDTO;
import com.rafaelfilho.dscommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll( ){
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

}
