package hello.repository;

import hello.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by neviim 2 on 25/08/2017.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
