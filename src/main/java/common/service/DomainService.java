package common.service;

import java.util.List;

import sales.domain.SalesDomain;

public interface DomainService <DomainClass, IdType>{

	List<DomainClass> getAll();
	DomainClass change(DomainClass changedData);
	DomainClass create(DomainClass newData);
	DomainClass get(IdType id);
	List<DomainClass> get(int offset, int limit);
}
