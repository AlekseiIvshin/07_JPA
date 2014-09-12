package store.domain;

import car.domain.CarDomain;

public class StoreDomainImpl implements StoreDomain {

	private int id;
	private CarDomain car;
	private int quantity;
	private float price;
	private boolean canTestDrive;

	public boolean canSale() {
		return quantity > 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarDomain getCar() {
		return car;
	}

	public void setCar(CarDomain car) {
		this.car = car;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isCanTestDrive() {
		return canTestDrive;
	}

	public void setCanTestDrive(boolean canTestDrive) {
		this.canTestDrive = canTestDrive;
	}

	public boolean canTestDrive() {
		return canTestDrive;
	}

}
