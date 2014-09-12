package common.mapper;

import java.util.List;

import ma.glasnost.orika.MapperFactory;

public interface Mapper {
	
	<FromClass, ToClass> ToClass  map(FromClass object, Class<ToClass> toClass);
	<FromClass, ToClass> List<ToClass> mapAsList(List<FromClass> object, Class<ToClass> toClass);
}
