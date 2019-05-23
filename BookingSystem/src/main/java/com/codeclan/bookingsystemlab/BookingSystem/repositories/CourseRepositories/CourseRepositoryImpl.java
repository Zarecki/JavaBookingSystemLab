package com.codeclan.bookingsystemlab.BookingSystem.repositories.CourseRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

    @Autowired
    EntityManager entityManager;


    @Transactional
    public List<Course> getAllCoursesByRating(int rating) {
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("rating", rating));
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Course> getAllCoursesByCustomer(Long id) {
        List<Course> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.customer.id", id));
            result = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
           session.close();
        }
        return result;
    }
}
