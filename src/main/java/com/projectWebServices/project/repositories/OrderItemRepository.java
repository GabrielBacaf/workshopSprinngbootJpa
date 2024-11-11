package com.projectWebServices.project.repositories;

import com.projectWebServices.project.entities.OrdemItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrdemItem, Long>{

}
