package com.tejaMess.EMS.Service;

import com.tejaMess.EMS.Exception.ResourceNotFoundException;
import com.tejaMess.EMS.Model.Employee;
import com.tejaMess.EMS.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository=employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id)
    {
        Optional<Employee> employee =employeeRepository.findById(id);

        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Employee","Id",id);
        }
    }

    public Employee updateEmployeeById(Employee employee,Long id){
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Id",id)
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        return existingEmployee;
    }

    public void deleteEmployee(Long id)
    {
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Id",id)
        );
        employeeRepository.deleteById(id);
    }

}




















