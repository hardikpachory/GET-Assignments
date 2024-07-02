package assignment_8;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Employee> employees;
	
	public Department(String name) {
		this.name = name;
		employees = new ArrayList<Employee>();
	}
	
	public boolean join(Employee employee) {
		return employees.add(employee);
	}
	
	public boolean relieve(Employee employee) {
		return employees.remove(employee);
	}
	
	public List<Employee> getEmployess(){
		return employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Developers> getEmployee(){
//		List<Developers> devs = new ArrayList<>();
//		for(Employee e: employees) {
//			if( e instanceof Developer) {
//				devs.add(e);
//			}
//		}
//		return devs;
//	}
	
}
