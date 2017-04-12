package com.su.hpre.alipay.service;

import com.su.hpre.alipay.model.Employee;

public interface EmployeeService {

	Employee getEmployee(Long id);

	void addNewEmployee(Employee employee);
}
