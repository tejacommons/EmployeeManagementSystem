package com.tejaMess.EMS.Service;

import com.tejaMess.EMS.Model.Employee;

import java.util.List;

public interface EmployeeService
{
    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee updateEmployeeById(Employee employee,Long id);

    public void deleteEmployee(Long id);

}
