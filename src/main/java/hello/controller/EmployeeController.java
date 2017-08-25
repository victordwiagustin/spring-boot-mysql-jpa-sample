package hello.controller;

import hello.entity.Employee;
import hello.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neviim 2 on 25/08/2017.
 */

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path = "/add")
    private @ResponseBody
    String addNew(@RequestParam String name, @RequestParam String address, @RequestParam String position) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setPosition(position);
        employeeRepository.save(employee);
        return "Saved";
    }

    @GetMapping(path = "/all")
    private @ResponseBody Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/get-one")
    private @ResponseBody Employee getOne(@RequestParam Integer id) {
        return employeeRepository.findOne(id);
    }

    @DeleteMapping(path = "delete")
    private @ResponseBody void delete(@RequestParam Integer id) {
        employeeRepository.delete(id);
    }
}
