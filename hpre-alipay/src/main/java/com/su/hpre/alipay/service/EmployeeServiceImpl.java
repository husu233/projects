package com.su.hpre.alipay.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.hpre.alipay.dao.EmployeeDao;
import com.su.hpre.alipay.model.Employee;



@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {



	@Autowired
	EmployeeDao employeeDao;

	public Employee getEmployee(Long id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void addNewEmployee(Employee employee) {
		Long id = (Long) employeeDao.save(employee);
	}

}
