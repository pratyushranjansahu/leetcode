package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
	private long id;
	private String name;
	private double amount;

	public Employee(int id, String name, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}

}

public class Java8Feature {

	public static void main(String[] args) {
		//convertStreamToMap();
		traverseStreamMultipleTimes();
	}

	private static void convertStreamToMap() {
		// keys are unique
		List<Employee> employeeList = new ArrayList<>(
				Arrays.asList(new Employee(1, "A", 100), new Employee(2, "A", 200), new Employee(3, "B", 300),
						new Employee(4, "B", 400), new Employee(5, "C", 500), new Employee(6, "C", 600)));

		Map<Long, Employee> employeesMap = employeeList.stream()
				.collect(Collectors.toMap(Employee::getId, Function.identity()));

		System.out.println(employeesMap);

		// keys are duplicate
		employeeList = new ArrayList<>(
				Arrays.asList(new Employee(1, "A", 100), new Employee(2, "A", 200), new Employee(3, "B", 300),
						new Employee(4, "B", 400), new Employee(5, "C", 500), new Employee(6, "C", 600)));

		Map<String, List<Employee>> employeesMap1 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getName));

		System.out.println(employeesMap1);
	}

	private static void traverseStreamMultipleTimes() {
		 List<Integer> tokens = Arrays.asList(1, 2, 3, 4, 5);
         
	        //first use
	        Optional<Integer> result = tokens.stream().max(Integer::compareTo);
	        System.out.println(result.get());
	         
	        //second use
	        result = tokens.stream().min(Integer::compareTo);
	        System.out.println(result.get());
	         
	        //third use
	        long count = tokens.stream().count();
	        System.out.println(count);
	}
}
