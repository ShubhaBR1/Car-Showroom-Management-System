
public class Employee {
	    private String id;
	    private String name;
	    private String role;
	    private String phone;

	    public Employee(String id, String name, String role, String phone) {
	        this.id = id;
	        this.name = name;
	        this.role = role;
	        this.phone = phone;
	    }

	    public String getId() { return id; }
	    public String getName() { return name; }
	    public String getRole() { return role; }
	    public String getPhone() { return phone; }

	    public void setName(String name) { this.name = name; }
	    public void setRole(String role) { this.role = role; }
	    public void setPhone(String phone) { this.phone = phone; }
	}
	
