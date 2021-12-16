package com.amigoscode.employeemanager.service;

import com.amigoscode.employeemanager.exception.UserNotFoundExceptional;
import com.amigoscode.employeemanager.model.Employee;
import com.amigoscode.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setImageUrl("https://bootdey.com/img/Content/avatar/avatar" + (1 + (int) (Math.random() * 8)) + ".png");
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundExceptional("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

}
