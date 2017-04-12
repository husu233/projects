package com.su.hpre.alipay.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.su.hpre.alipay.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private SessionFactory sessionFactory;

	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Serializable save(Employee employee) {
		return currentSession().save(employee);
	}
	
	@Override
	public Employee findById(final Serializable id) {
		return currentSession().get(Employee.class, id);
	}


}
