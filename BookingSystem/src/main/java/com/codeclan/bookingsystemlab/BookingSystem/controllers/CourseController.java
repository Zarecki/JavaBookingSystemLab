package com.codeclan.bookingsystemlab.BookingSystem.controllers;

import com.codeclan.bookingsystemlab.BookingSystem.models.Course;
import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.BookingRepositories.BookingRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories.CourseRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getAllCoursesByRating(@PathVariable int rating){
        return courseRepository.getAllCoursesByRating(rating);
    }

    @GetMapping(value = "/customer/{customerName}")
    public List<Course> getAllCoursesByCustomer(@PathVariable Long customerId){
        return courseRepository.getAllCoursesByCustomer(customerId);
    }
}
