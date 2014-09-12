package sales.service;

import sales.domain.SalesDomain;
import java.util.List;

public interface SalesService {

	List<SalesDomain> getAll();
	SalesDomain change(SalesDomain changedDomainSales);
	SalesDomain create(SalesDomain newSales);
}
