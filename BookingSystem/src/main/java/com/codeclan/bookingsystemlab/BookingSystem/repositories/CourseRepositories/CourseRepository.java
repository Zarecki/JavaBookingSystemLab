package com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
}
