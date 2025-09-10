
	import java.time.LocalDate;

	public class sale {
	    private String id;
	    private String carId;
	    private String customerName;
	    private double salePrice;
	    private LocalDate date;

	    public sale(String id, String carId, String customerName, double salePrice, LocalDate date) {
	        this.id = id;
	        this.carId = carId;
	        this.customerName = customerName;
	        this.salePrice = salePrice;
	        this.date = date;
	    }

	    public String getId() { return id; }
	    public String getCarId() { return carId; }
	    public String getCustomerName() { return customerName; }
	    public double getSalePrice() { return salePrice; }
	    public LocalDate getDate() { return date; }
	}
