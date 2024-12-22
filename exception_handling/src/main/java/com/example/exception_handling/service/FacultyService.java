package com.example.exception_handling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.GenerateCsvException;
import com.example.Exceptions.MarksExceededException;
import com.example.Exceptions.UserNotFoundException;
import com.example.exception_handling.entity.Faculty;
import com.example.exception_handling.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    public void func1() {
        
        Faculty f = facultyRepository.getByEmail("harshaltiwari856@gmail.com");

        System.out.println(f);

    }

    public void func2() throws MarksExceededException{

        // Some processing for populating marks

        //Someone tried to enter invalid marks using postman or something
        
        throw new MarksExceededException("Marks entered excceds the maximum marks");

    }

    public String func3() throws GenerateCsvException,MarksExceededException {

        // Faculty missed some empty cells
        double num = Math.floor(10*Math.random());
        
        if(num>5){
            throw new GenerateCsvException("Null entries found");
        }
        else{
            System.out.println("It runssss");
        }
        return "Byeee";
    }

}
