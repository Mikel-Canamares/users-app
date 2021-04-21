package com.devs4.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.devs4.users.entities.Adress;


@Repository
public interface AdressRepository extends CrudRepository<Adress, Integer>{

}
