package assignment_8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayrollSystemTest {
    
	Employee emp = new Developer("Test Developer", 25000);
	Employee emp2 = new Developer("Test Developer2", 30000);
	
	Department dept = new Department("Test Department");
	Department dept2 = new Department("Test Department 2");
	
	Organization org = new Organization("Test Organization");
	
	@Test
	@DisplayName("Join Department Test One")
	void departmentJoinTest() {
		assertTrue(dept.join(emp));
	}
	
	@Test
	@DisplayName("Join Department Test Two")
	void departmentJoinTestTwo() {
		assertTrue(dept2.join(emp2));
	}
	
	@Test
	@DisplayName("Add Department Test One")
	void addDepartmentTest() {
		assertTrue(org.addDepartment(dept));
		
	}
	@Test
	@DisplayName("Add Department Test Two")
	void addDepartmentTestTwo() {
		assertTrue(org.addDepartment(dept2));
		
	}
}
