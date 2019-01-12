package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long>{
	
	
}
