package com.yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.EmployeeDao;
import com.yue.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeedao;
    public Employee queryEmployeeByName(Employee employee){
    	return employeedao.queryEmployeeByName(employee);
    }
}
