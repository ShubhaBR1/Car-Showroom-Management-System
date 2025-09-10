
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.time.LocalDate;

	public class ShowroomUI {
	    private final Showroom showroom;

	    public ShowroomUI() {
	        this.showroom = new Showroom("My Showroom", "MG Road, Bengaluru", "Anita");
	        createUI();
	    }

	    private void createUI() {
	        JFrame frame = new JFrame("Car Showroom Management System");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(900, 600);
	        frame.setLocationRelativeTo(null);

	        JTabbedPane tabs = new JTabbedPane();

	        // Cars Tab
	        JPanel carsPanel = new JPanel(new BorderLayout(10,10));
	        String[] carCols = {"ID","Name","Model","Color","Fuel","Trans","Price"};
	        DefaultTableModel carModel = new DefaultTableModel(carCols,0);
	        JTable carTable = new JTable(carModel);
	        refreshCars(carModel);

	        JPanel addCar = new JPanel(new GridLayout(2,7,8,8));
	        JTextField cId = new JTextField();
	        JTextField cName = new JTextField();
	        JTextField cModel = new JTextField();
	        JTextField cColor = new JTextField();
	        JTextField cFuel = new JTextField();
	        JTextField cTrans = new JTextField();
	        JTextField cPrice = new JTextField();
	        addCar.add(new LabeledField("ID", cId));
	        addCar.add(new LabeledField("Name", cName));
	        addCar.add(new LabeledField("Model", cModel));
	        addCar.add(new LabeledField("Color", cColor));
	        addCar.add(new LabeledField("Fuel", cFuel));
	        addCar.add(new LabeledField("Trans", cTrans));
	        addCar.add(new LabeledField("Price", cPrice));
	        JButton addCarBtn = new JButton("Add Car");
	        addCarBtn.addActionListener(e -> {
	            try {
	                double p = Double.parseDouble(cPrice.getText().trim());
	                showroom.addCar(new Car(cId.getText().trim(), cName.getText().trim(), cModel.getText().trim(),
	                        cColor.getText().trim(), cFuel.getText().trim(), cTrans.getText().trim(), p));
	                refreshCars(carModel);
	                cId.setText(""); cName.setText(""); cModel.setText(""); cColor.setText("");
	                cFuel.setText(""); cTrans.setText(""); cPrice.setText("");
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Enter a valid price");
	            }
	        });
	        JPanel carSouth = new JPanel(new BorderLayout());
	        carSouth.add(addCar, BorderLayout.CENTER);
	        carSouth.add(addCarBtn, BorderLayout.EAST);

	        carsPanel.add(new JScrollPane(carTable), BorderLayout.CENTER);
	        carsPanel.add(carSouth, BorderLayout.SOUTH);

	        // Employees Tab
	        JPanel empPanel = new JPanel(new BorderLayout(10,10));
	        String[] empCols = {"ID","Name","Role","Phone"};
	        DefaultTableModel empModel = new DefaultTableModel(empCols,0);
	        JTable empTable = new JTable(empModel);
	        refreshEmployees(empModel);
	        JPanel addEmp = new JPanel(new GridLayout(1,8,8,8));
	        JTextField eId = new JTextField();
	        JTextField eName = new JTextField();
	        JTextField eRole = new JTextField();
	        JTextField ePhone = new JTextField();
	        addEmp.add(new LabeledField("ID", eId));
	        addEmp.add(new LabeledField("Name", eName));
	        addEmp.add(new LabeledField("Role", eRole));
	        addEmp.add(new LabeledField("Phone", ePhone));
	        JButton addEmpBtn = new JButton("Add Employee");
	        addEmpBtn.addActionListener(ev -> {
	            showroom.addEmployee(new Employee(eId.getText().trim(), eName.getText().trim(), eRole.getText().trim(), ePhone.getText().trim()));
	            refreshEmployees(empModel);
	            eId.setText(""); eName.setText(""); eRole.setText(""); ePhone.setText("");
	        });
	        JPanel empSouth = new JPanel(new BorderLayout());
	        empSouth.add(addEmp, BorderLayout.CENTER);
	        empSouth.add(addEmpBtn, BorderLayout.EAST);
	        empPanel.add(new JScrollPane(empTable), BorderLayout.CENTER);
	        empPanel.add(empSouth, BorderLayout.SOUTH);

	        // Sales Tab
	        JPanel salesPanel = new JPanel(new BorderLayout(10,10));
	        String[] saleCols = {"ID","Car ID","Customer","Price","Date"};
	        DefaultTableModel saleModel = new DefaultTableModel(saleCols,0);
	        JTable saleTable = new JTable(saleModel);
	        refreshSales(saleModel);

	        JPanel addSale = new JPanel(new GridLayout(1,10,8,8));
	        JTextField sId = new JTextField();
	        JTextField sCarId = new JTextField();
	        JTextField sCustomer = new JTextField();
	        JTextField sPrice = new JTextField();
	        addSale.add(new LabeledField("ID", sId));
	        addSale.add(new LabeledField("Car ID", sCarId));
	        addSale.add(new LabeledField("Customer", sCustomer));
	        addSale.add(new LabeledField("Price", sPrice));
	        JButton addSaleBtn = new JButton("Record Sale");
	        addSaleBtn.addActionListener(e -> {
	            try {
	                double p = Double.parseDouble(sPrice.getText().trim());
	                showroom.addSale(new sale(sId.getText().trim(), sCarId.getText().trim(), sCustomer.getText().trim(), p, LocalDate.now()));
	                refreshSales(saleModel);
	                sId.setText(""); sCarId.setText(""); sCustomer.setText(""); sPrice.setText("");
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Enter a valid price");
	            }
	        });
	        JPanel salesSouth = new JPanel(new BorderLayout());
	        salesSouth.add(addSale, BorderLayout.CENTER);
	        salesSouth.add(addSaleBtn, BorderLayout.EAST);

	        salesPanel.add(new JScrollPane(saleTable), BorderLayout.CENTER);
	        salesPanel.add(salesSouth, BorderLayout.SOUTH);

	        tabs.add("Cars", carsPanel);
	        tabs.add("Employees", empPanel);
	        tabs.add("sales", salesPanel);

	        frame.add(tabs);
	        frame.setVisible(true);
	    }

	    private void refreshCars(DefaultTableModel model) {
	        model.setRowCount(0);
	        for (Car c : showroom.getCars()) {
	            model.addRow(new Object[]{c.getId(), c.getName(), c.getModel(), c.getColor(), c.getFuelType(), c.getTransmission(), c.getPrice()});
	        }
	    }

	    private void refreshEmployees(DefaultTableModel model) {
	        model.setRowCount(0);
	        for (Employee e : showroom.getEmployees()) {
	            model.addRow(new Object[]{e.getId(), e.getName(), e.getRole(), e.getPhone()});
	        }
	    }

	    private void refreshSales(DefaultTableModel model) {
	        model.setRowCount(0);
	        for (sale s : showroom.getSales()) {
	            model.addRow(new Object[]{s.getId(), s.getCarId(), s.getCustomerName(), s.getSalePrice(), s.getDate()});
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(ShowroomUI::new);
	    }

	    // Small helper component to label text fields neatly
	    static class LabeledField extends JPanel {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1;

			public LabeledField(String label, JTextField field) {
	            super(new BorderLayout(5,5));
	            add(new JLabel(label), BorderLayout.WEST);
	            add(field, BorderLayout.CENTER);
	        }
	    }
	}
