package com.projectWebServices.project.repositories;

import com.projectWebServices.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
