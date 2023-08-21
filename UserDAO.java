package com.example.CRUD.DAO;

import com.example.CRUD.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
}
