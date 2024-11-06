package com.projectWebServices.project.repositories;


import com.projectWebServices.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
