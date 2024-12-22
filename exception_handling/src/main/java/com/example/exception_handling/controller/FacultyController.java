package com.example.exception_handling.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ErrorResponse;
import com.example.Exceptions.GenerateCsvException;
import com.example.Exceptions.UserNotFoundException;
import com.example.Exceptions.WrongPasswordException;
import com.example.Exceptions.WrongUsernameException;
import com.example.exception_handling.entity.Faculty;
import com.example.exception_handling.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/home")
    public String func1() {

        facultyService.func1();
        return new String("Index");
    }

    @GetMapping("/login")
    public ResponseEntity<?> func2() throws WrongUsernameException,WrongPasswordException {

        double num = Math.floor(10*Math.random());

        //wrong username entered
        if(num > 5){
            System.out.println("NOO ENTRRYY");
            throw new WrongPasswordException("ENTRRRYYY NOT ALLOWED");
        }
        else{
            System.out.println("no entry");
            throw new WrongPasswordException("ENTRRRYYY NOT ALLOWED");
        }
    }

    // @GetMapping("/generateCsv")
    // public String func3() throws GenerateCsvException{

    // }
}