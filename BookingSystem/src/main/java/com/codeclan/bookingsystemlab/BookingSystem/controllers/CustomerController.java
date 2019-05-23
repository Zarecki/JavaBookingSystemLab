package com.codeclan.bookingsystemlab.BookingSystem.controllers;

import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories.CourseRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/course/{courseId}")
    public List<Customer> getAllCustomersByCourse(@PathVariable Long courseId){
        return customerRepository.getAllCustomersByCourseName(courseId);
    }

    @GetMapping(value = "/town/{town}/course/{courseId}")
    public List<Customer> getAllCustomersByCustomerTownAndCourse(@PathVariable String town, Long courseId){
        return customerRepository.getAllCustomersByCustomerTownAndCourse(town, courseId);
    }

    @GetMapping(value = "/age/{age}/town/{town}/course/{courseId}")
    public List<Customer> getAllCustomersByCustomerAgeTownAndCourse(@PathVariable int age, String town, Long courseId){
        return customerRepository.getAllCustomersByCustomerAgeTownAndCourse(age, town, courseId);
    }
}
