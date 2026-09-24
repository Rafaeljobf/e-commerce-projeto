package com.rafaelfilho.dscommerce.repositories;

import com.rafaelfilho.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
