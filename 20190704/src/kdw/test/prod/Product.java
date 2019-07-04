package kdw.test.prod;

public class Product {
	private String name;
	private String model;
	private int values;
	private int qty;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int values) {
		
		this.values = values;
	}
	
	public Product(String name, String model, int values) {
		super();
		this.name = name;
		this.model = model;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getValues() {
		return values;
	}

	public void setValues(int values) {
		this.values = values;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}
