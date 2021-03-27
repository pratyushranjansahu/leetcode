package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestEmployee {

	public static void main(String[] args) {
	Employee e1=new Employee();
	e1.setAge(2);
	e1.setName("Pratyush");
	
	Employee e2=new Employee();
	e2.setAge(2);
	e2.setName("Pratyush");
	List<Employee> employeeList = new ArrayList<>(Arrays.asList(e1,e2));
	 Map<Integer, List<Employee>> employeesMap = employeeList.stream()
             .collect(Collectors.groupingBy(Employee::getAge
            		 ));

	System.out.println(employeesMap);
	}

}
