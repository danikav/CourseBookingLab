package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomersFilteredByCourse(
            @RequestParam(name = "courseName", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
            ) {
        if (courseName !=null && town !=null && age != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseNameAndTownIgnoreCaseAndAgeGreaterThan(courseName, town, age), HttpStatus.OK);
        }
        if (courseName !=null && town !=null) {
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseNameAndTownIgnoreCase(courseName, town), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
