package com.codeclan.bookingsystemlab.BookingSystem.repositories.BookingRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {

    List<Booking> findAllBookingsByDate(String date);

}
