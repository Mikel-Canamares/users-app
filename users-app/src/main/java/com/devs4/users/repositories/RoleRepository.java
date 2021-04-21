package com.devs4.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4.users.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
