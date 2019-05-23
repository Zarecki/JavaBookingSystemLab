package com.codeclan.bookingsystemlab.BookingSystem.repositories.CustomerRepositories;

import com.codeclan.bookingsystemlab.BookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getAllCustomersByCourseName(long id) {
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.course.id", id));
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

    @Transactional
    public List<Customer> getAllCustomersByCustomerTownAndCourse(String town, Long courseId) {
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("town", town));
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.course.id", courseId));
            result = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }

    @Transactional
    public List<Customer> getAllCustomersByCustomerAgeTownAndCourse(int age, String town, Long courseId){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("age", age));
            cr.add(Restrictions.eq("town", town));
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.course.id", courseId));
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
