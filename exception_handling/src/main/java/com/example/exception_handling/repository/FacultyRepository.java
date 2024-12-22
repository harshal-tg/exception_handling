package com.example.exception_handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Exceptions.UserNotFoundException;
import com.example.exception_handling.entity.Faculty;


public interface FacultyRepository extends JpaRepository<Faculty,Integer>{

    @Query("SELECT f from Faculty f WHERE f.email = :email")
    Faculty getByEmail(@Param("email") String emailAddress);

}