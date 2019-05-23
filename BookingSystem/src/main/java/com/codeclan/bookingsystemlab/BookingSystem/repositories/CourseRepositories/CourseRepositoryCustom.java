package com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> getAllCoursesByRating(int rating);

    List<Course> getAllCoursesByCustomer(Long id);
}
