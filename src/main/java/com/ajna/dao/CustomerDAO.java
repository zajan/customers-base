package com.ajna.dao;

import com.ajna.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Customer getCustomer(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    public void saveCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    public void deleteCustomer(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();

    }

    public List<Customer> getCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);
        return query.getResultList();
    }
}
