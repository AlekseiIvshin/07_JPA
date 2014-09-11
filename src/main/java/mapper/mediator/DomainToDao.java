package mapper.mediator;

import java.util.List;

public interface DomainToDao<F,T> {

	List<T> map(List<F> fromObject);
	T map(F fromObject);
}
