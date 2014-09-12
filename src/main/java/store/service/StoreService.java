package store.service;

import store.domain.StoreDomain;
import java.util.List;

public interface StoreService {

	List<StoreDomain> getAll();
	StoreDomain change(StoreDomain changedDomainStore);
	StoreDomain create(StoreDomain newStore);
	StoreDomain decrementQuanity(StoreDomain store);
}
