package com.codeclan.bookingsystemlab.BookingSystem.components;

import com.codeclan.bookingsystemlab.BookingSystem.models.Booking;
import com.codeclan.bookingsystemlab.BookingSystem.models.Course;
import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.BookingRepositories.BookingRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories.CourseRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Course advancedKnitting = new Course("Advanced Knitting", "Milngavie", 8);
        courseRepository.save(advancedKnitting);

        Customer erik = new Customer("Erik Eriksson", "Methil", 53);
        customerRepository.save(erik);

        Booking booking1 = new Booking("05-11-2019", advancedKnitting, erik);
        bookingRepository.save(booking1);

    }
}
