package com.tejaMess.EMS.Controller;

import com.tejaMess.EMS.Model.Employee;
import com.tejaMess.EMS.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        super();
        this.employeeService=employeeService;
    }


//<------>CREATE EMPLOYEE REST-API <------------>
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

//<------------>Get ALL EMPLOYEES<----------------->

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    //<------------>Get A PARTICULAR EMPLOYEE BY HIS ID<----------------->
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId)
    {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    //<------------>UPDATE A EMPLOYEE<----------------->

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(Employee employee,@PathVariable("id") Long id)
    {
        return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee,id), HttpStatus.OK);
    }

    //<------------>Delete A EMPLOYEE<----------------->
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
    }
}


























