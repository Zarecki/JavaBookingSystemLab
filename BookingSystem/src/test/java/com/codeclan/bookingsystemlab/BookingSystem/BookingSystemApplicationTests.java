package com.codeclan.bookingsystemlab.BookingSystem;

import com.codeclan.bookingsystemlab.BookingSystem.models.Booking;
import com.codeclan.bookingsystemlab.BookingSystem.models.Course;
import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.BookingRepositories.BookingRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories.CourseRepository;
import com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingSystemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void canGetAllCoursesByRating(){
		List<Course> found = courseRepository.getAllCoursesByRating(8);
		assertEquals(1 , found.size());
		assertEquals("Advanced Knitting", found.get(0).getName());
	}

	@Test
	public void canGetCoursesByCustomer(){
		List<Course> found = courseRepository.getAllCoursesByCustomer(1L);
		assertEquals(1, found.size());
	}


	@Test
	public void canGetAllBookingsByDate(){
		List<Booking> found = bookingRepository.findAllBookingsByDate("05-11-2019");
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllCustomersByCourse(){
		List<Customer> found = customerRepository.getAllCustomersByCourseName(1L);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllCustomersByCustomerTownAndCourse(){
		List<Customer> found = customerRepository.getAllCustomersByCustomerTownAndCourse("Methil", 1L);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllCustomersByCustomerAgeTownAndCourse(){
		List<Customer> found = customerRepository.getAllCustomersByCustomerAgeTownAndCourse(53, "Methil", 1L);
		assertEquals(1, found.size());
	}
}
