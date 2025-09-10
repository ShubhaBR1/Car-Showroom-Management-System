
	import java.util.Objects;

	public class Car {
	    private String id;
	    private String name;
	    private String model;
	    private String color;
	    private String fuelType;
	    private String transmission;
	    private double price;

	    public Car(String id, String name, String model, String color, String fuelType, String transmission, double price) {
	        this.id = id;
	        this.name = name;
	        this.model = model;
	        this.color = color;
	        this.fuelType = fuelType;
	        this.transmission = transmission;
	        this.price = price;
	    }

	    public String getId() { return id; }
	    public String getName() { return name; }
	    public String getModel() { return model; }
	    public String getColor() { return color; }
	    public String getFuelType() { return fuelType; }
	    public String getTransmission() { return transmission; }
	    public double getPrice() { return price; }

	    public void setName(String name) { this.name = name; }
	    public void setModel(String model) { this.model = model; }
	    public void setColor(String color) { this.color = color; }
	    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
	    public void setTransmission(String transmission) { this.transmission = transmission; }
	    public void setPrice(double price) { this.price = price; }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Car)) return false;
	        Car car = (Car) o;
	        return Objects.equals(id, car.id);
	    }

	    @Override
	    public int hashCode() { return Objects.hash(id); }
	}
