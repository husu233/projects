package com.su.hpre.alipay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.su.hpre.alipay.model.Employee;
import com.su.hpre.alipay.service.EmployeeService;


@Component
public class MyApplication {


	@Autowired
	private EmployeeService empService;
	
	public void performDbTasks()
	{
		Employee empNew = new Employee(1l, "Bytes", "Tree", "Senior Developer", 2000);

		// Save new employee
		empService.addNewEmployee(empNew);
		
		// Get saved employee
		Employee employee = empService.getEmployee(empNew.getId());
		
		System.out.println(employee);

	}

}
