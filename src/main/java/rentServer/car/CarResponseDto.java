package rentServer.car;

import java.security.Timestamp;

public class CarResponseDto {
	private String code;
	private String name;
	private String brand;
	private String type;
	private String fuel;
	private String seater;
	private String price;
	private Timestamp regDate;
	private Timestamp modDate;
	
	
	public CarResponseDto(String code, String name, String brand, String type, String fuel, String seater, String price,
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
	
	public CarResponseDto(String code, String name, String brand, String type, String fuel, String seater, String price) {
		super();
		this.code = code;
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.fuel = fuel;
		this.seater = seater;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getSeater() {
		return seater;
	}

	public void setSeater(String seater) {
		this.seater = seater;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}
	
	
	
}
