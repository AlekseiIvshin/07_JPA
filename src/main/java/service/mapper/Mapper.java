package service.mapper;

import java.util.List;

public interface Mapper<FromClass, ToClass> {

	ToClass map(FromClass object, Class<ToClass> toClass);
	List<ToClass> mapAsList(List<FromClass> object, Class<ToClass> toClass);
}
