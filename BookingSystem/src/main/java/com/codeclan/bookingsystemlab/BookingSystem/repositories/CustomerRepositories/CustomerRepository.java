package com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
