package com.su.hpre.alipay.dao;

import java.io.Serializable;

import com.su.hpre.alipay.model.Employee;


public interface EmployeeDao {

	Serializable save(Employee employee);

	Employee findById(Serializable id);

}
