package store.service;

import store.domain.StoreDomain;

import java.util.List;

import car.domain.CarDomain;

public interface StoreService {

	List<StoreDomain> get(int offset, int count);
	StoreDomain change(StoreDomain changedDomainStore);
	StoreDomain create(StoreDomain newStore);
	StoreDomain get(CarDomain car);
}
