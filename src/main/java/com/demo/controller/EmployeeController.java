package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = "/save")
	public Employee createEmployee(@RequestBody Employee emp) {
		System.out.println(emp.toString());
		return service.saveEmployee(emp);
	}
	
	@GetMapping(value = "/getall")
	@ResponseBody
	public List<Employee> getAll()
	{
		return service.getAllEmployee();
	}
	
	@GetMapping(value = "/get/{id}")
	@ResponseBody
	public Employee getEmployee(@RequestAttribute("id") int id)
	{
		return service.getEmployeeByID(id);
	}
	
	@RequestMapping(value = "/hello" , method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee aq ){
		return ResponseEntity.ok(service.saveEmployee(aq));
		
	}
	

}
