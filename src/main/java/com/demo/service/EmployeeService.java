package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository res;
	
	public Employee saveEmployee(Employee emp) {
		return res.save(emp);
	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> eee = res.findAll();
		System.out.println(eee.toString());
		return res.findAll();
	}
	
	@SuppressWarnings("deprecation")
	public Employee getEmployeeByID(int id) {
		return res.getById(id);
	}
	
	public void deleteEmployee(int id) {
		Employee e = res.getById(id);
		res.delete(e);
	}
	
	public Employee updateEmployee(Employee emp) {
		return res.save(emp);
	}
	
}
