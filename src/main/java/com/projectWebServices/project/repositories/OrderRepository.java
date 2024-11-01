package com.projectWebServices.project.repositories;

import com.projectWebServices.project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
