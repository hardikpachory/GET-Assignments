package assignment_8;

public class ExecutePayroll {
	public static void main(String[] args) {
		
		// TODO create PDF of the salaries
		
		Employee emp = new Developer("Test Developer", 25000);
		Employee emp2 = new Developer("Test Developer2", 30000);
		
		Department dept = new Department("Test Department");
		Department dept2 = new Department("Test Department 2");
		
		Organization org = new Organization("Test Organization");
		
		dept.join(emp);
		dept2.join(emp2);
		
		org.addDepartment(dept);
		org.addDepartment(dept2);
		
		Payroll.printSalarySLip(org);
	}
}
