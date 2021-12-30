package dapp.models;

public class Product {
	private Integer type;
	private Integer id;
	private String name;
	private Float price;
	private Integer quantity;
	private Integer date;
	
	
	public Product() {
		
	}
	
	public Product(Integer type, Integer id, String name, Integer quantity, Integer date, Float price) {
		this.type = type;
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.price = price;
	}
	
	public Product(String name, Integer quantity, Integer date, Float price) {
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.price = price;
	}
	
	public Product(int i, int i2, String string, int j, String string2, Float price2) {
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
