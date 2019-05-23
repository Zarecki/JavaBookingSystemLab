package com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> getAllCustomersByCourseName(long name);

    List<Customer> getAllCustomersByCustomerTownAndCourse(String town, Long courseId);

    List<Customer> getAllCustomersByCustomerAgeTownAndCourse(int age, String town, Long courseId);
}
