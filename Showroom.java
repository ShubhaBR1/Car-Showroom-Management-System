
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Optional;

	public class Showroom {
	    private String name;
	    private String address;
	    private String managerName;

	    private final List<Car> cars = new ArrayList<>();
	    private final List<Employee> employees = new ArrayList<>();
	    private final List<sale> sales = new ArrayList<>();

	    public Showroom(String name, String address, String managerName) {
	        this.name = name;
	        this.address = address;
	        this.managerName = managerName;
	        // seed data
	        cars.add(new Car("C1","Maruti Swift","2022","Red","Petrol","Manual",700000));
	        cars.add(new Car("C2","Hyundai Creta","2023","White","Diesel","Automatic",1200000));
	        employees.add(new Employee("E1","Ramesh","Manager","9876543210"));
	        employees.add(new Employee("E2","Suresh","Sales","9876501234"));
	    }

	    // Cars
	    public List<Car> getCars() { return Collections.unmodifiableList(cars); }
	    public void addCar(Car c) { cars.add(c); }
	    public Optional<Car> findCarById(String id) { return cars.stream().filter(c -> c.getId().equals(id)).findFirst(); }
	    public boolean removeCar(String id) { return cars.removeIf(c -> c.getId().equals(id)); }

	    // Employees
	    public List<Employee> getEmployees() { return Collections.unmodifiableList(employees); }
	    public void addEmployee(Employee e) { employees.add(e); }
	    public boolean removeEmployee(String id) { return employees.removeIf(e -> e.getId().equals(id)); }

	    // Sales
	    public List<sale> getSales() { return Collections.unmodifiableList(sales); }
	    public void addSale(sale s) { sales.add(s); }

	    public String getName() { return name; }
	    public String getAddress() { return address; }
	    public String getManagerName() { return managerName; }
	}
