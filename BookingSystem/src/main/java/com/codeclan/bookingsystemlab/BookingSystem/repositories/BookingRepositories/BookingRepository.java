package com.codeclan.bookingsystemlab.BookingSystem.repositories.BookingRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
    List<Booking> findAllBookingsByDate(String date);
}
