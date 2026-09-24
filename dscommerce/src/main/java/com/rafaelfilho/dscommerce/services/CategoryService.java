package com.rafaelfilho.dscommerce.services;


import com.rafaelfilho.dscommerce.dto.CategoryDTO;
import com.rafaelfilho.dscommerce.dto.ProductMinDTO;
import com.rafaelfilho.dscommerce.entities.Category;
import com.rafaelfilho.dscommerce.entities.Product;
import com.rafaelfilho.dscommerce.repositories.CategoryRepository;
import com.rafaelfilho.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
