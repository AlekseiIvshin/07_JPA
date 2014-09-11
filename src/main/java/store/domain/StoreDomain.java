package store.domain;

import car.domain.CarDomain;

public interface StoreDomain {

	int getId();
	void setId(int id);
	CarDomain getCar();
	void setCar(CarDomain car);
	int getQuantity();
	void setQuantity(int quantity);
	float getPrice();
	void setPrice(float price);
	boolean canTestDrive();
	void setCanTestDrive(boolean canTestDrive);
}
