package assignment_8;

public class Payroll {
	public static void printSalarySLip(Organization org) {
		System.out.println("     Salary Slip of All Employees of " + org.getNameOfOrganization());
		System.out.println("-------------------------------------\n");
		for(Employee emp : org.getAllEmployees()) {
			System.out.println("Employee ID  : " + emp.getId());
			System.out.println("Name         : " + emp.getName());
			System.out.println("Department   : " + emp.getDeptName());
			System.out.println("Basic Salary : " + emp.getBasicSalary());
			System.out.println("Bonus        : " + emp.getBonus());
			System.out.println("Compensation : " + emp.getCompensation());
			System.out.println("--------------------------------------------");
		}
	}
}
