package com.example.reservation_system.service;

import com.example.reservation_system.dao.EmployeeDAO;
import com.example.reservation_system.daomain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    public void deleteEmployee(String id){
        employeeDAO.deleteById(id);
    }

    public void addEmployee(Employee employee){
        employeeDAO.addEmployee(employee);
    }
    public List<Employee> listEmployee(){
        return employeeDAO.listEmployee();
    }

    public Employee getByEmployeeId(String id){
       return employeeDAO.getByEmployeeId(id);
    }
    public void update(Employee employee){
        employeeDAO.update(employee);
    }

    public Employee checkLogin(String id, String pwd) {
        Employee employee = getByEmployeeId(id);
        if(employee == null){
            return null;
        }
        String dbPass = employee.getPassword();
        if(!StringUtils.isEmpty(pwd) && pwd.equals(dbPass)){
            return employee;
        }
        return null;
    }
}
