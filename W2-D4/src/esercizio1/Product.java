package esercizio1;

public class Product {

	private long id=0;
	private String name;
	private String category;
	private double price;
	
	public Product( String name, String category, double price) {

		this.name = name;
		this.category = category;
		this.price = price;
		id++;
	}

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getCategory() {
		return category;
	}


	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
	
	
	
}
