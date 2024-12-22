package com.example.ExceptionHandler;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ErrorResponse;
import com.example.Exceptions.GenerateCsvException;
import com.example.Exceptions.MarksExceededException;
import com.example.Exceptions.UserNotFoundException;
import com.example.Exceptions.WrongPasswordException;
import com.example.Exceptions.WrongUsernameException;
import com.example.constants.ExceptionConstants;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(UserNotFoundException.class)
    // public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e){

    //     ErrorResponse error = new ErrorResponse(101,"User doesn't exist");

    //     return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);

    // }

    // @ExceptionHandler(MarksExceededException.class)
    // public ResponseEntity<?> handleMarksExceededException(MarksExceededException e) {
        
    //     ErrorResponse error = new ErrorResponse(102,"Marks entered exceeds the maximum marks for the field");

    //     return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(GenerateCsvException.class)
    // public ResponseEntity<?> handleGenerateCsvException(GenerateCsvException e){

    //     ErrorResponse error = new ErrorResponse(103,"Generated CSV without entering marks");

    //     return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler({WrongUsernameException.class,WrongPasswordException.class})
    // public ResponseEntity<?> handleWrongUsernameException(WrongUsernameException e){
    //     ErrorResponse error = new ErrorResponse(104,"Wrong UserName Entered");

    //     return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    // }
    
    // @ExceptionHandler(WrongPasswordException.class)
    // public ResponseEntity<?> hadndleWrongPasswordException(WrongPasswordException e) {

    //     ErrorResponse error = new ErrorResponse(105,"Entered wrong password");

    //     return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    // }


    @ExceptionHandler({Exception.class,WrongUsernameException.class,WrongPasswordException.class})
    public ResponseEntity<?> handleMultipleExceptions(Exception ex) {
        
        String s = ExceptionConstants.map1.get(ex.getClass().getSimpleName());

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}
