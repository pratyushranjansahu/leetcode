package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		//traverseStreamMultipleTimes();
		List<Employee> empList=getEmpList();
		sortEmployeeListByMultipleCondition(empList);
		
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
	
	private static List<Employee> getEmpList(){
		List<Employee> listEmp=new ArrayList();
		
		listEmp = new ArrayList<>(
				Arrays.asList(new Employee(1, "A", 100), new Employee(2, "B", 200), new Employee(3, "C", 300),
						new Employee(4, "D", 400), new Employee(5, "RAM", 500), new Employee(6, "AAM", 500)));

		
		return listEmp;
	}
	//https://howtodoinjava.com/java/sort/sort-arraylist-objects-comparable-comparator/
	private static void sortEmployeeListByMultipleCondition(List<Employee> employees) {
		//Sort all employees by first name in reverse order
		Comparator<Employee> comparator = Comparator.comparing(e -> e.getName());
		employees.sort(comparator.reversed());
		System.out.println("Reverse order : "+employees);
		//Sorting on multiple fields; Group by.
				Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getAmount).thenComparing(Employee::getName);
				employees.sort(groupByComparator);	
				System.out.println(employees);
	}
	//OSG
	private void countElement() {
		List<Character> list=new ArrayList<Character>();
		list.add('A');
		list.add('B');
		list.add('C');
		list.add('A');
		list.add('Z');
		list.add('Y');
		Map<Character,Integer> m=list.stream().collect(Collectors.toMap(Function.identity(),null));
		System.out.println(m);

		
	}
	
	private void findDuplicateElementInList() {
		 Stream<Integer> stream
         = Stream.of(5, 13, 4,
                     21, 13, 27,
                     2, 59, 59, 34);
		 Set<Integer> idSet=stream
                 .collect(
                         Collectors.groupingBy(
                        		 Function.identity(),
                                 Collectors.counting()))

                 .entrySet()
                 .stream()
                 .filter(m -> m.getValue() > 1)
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toSet());
	}
}
