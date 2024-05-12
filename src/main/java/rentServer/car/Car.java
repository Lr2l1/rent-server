package rentServer.car;

import java.security.Timestamp;

public class Car {
	private String code;
	private String name;
	private String brand;
	private String type;
	private String fuel;
	private String seater;
	private String price;
	private Timestamp regDate;
	private Timestamp modDate;
	
	public Car(String code, String name, String brand, String type, String fuel, String seater, String price,
			Timestamp regDate, Timestamp modDate) {
		super();
		this.code = code;
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.fuel = fuel;
		this.seater = seater;
		this.price = price;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public String getType() {
		return type;
	}
	public String getFuel() {
		return fuel;
	}
	public String getSeater() {
		return seater;
	}
	public String getPrice() {
		return price;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public Timestamp getModDate() {
		return modDate;
	}	
	
	
	
}
