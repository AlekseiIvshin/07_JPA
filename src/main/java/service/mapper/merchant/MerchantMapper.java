package service.mapper.merchant;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import service.mapper.Mapper;

public abstract class MerchantMapper<FromClass, ToClass> 
		implements Mapper<FromClass, ToClass>{

	protected MapperFactory mapperFactory;
	protected Class<?> toClass;
	

	public MerchantMapper(Class<FromClass> fromClass, Class<ToClass> toClass){
		mapperFactory = new DefaultMapperFactory
				.Builder().build();
		mapperFactory.classMap(fromClass, toClass)
				.field("name", "name")
				.field("surname", "surname")
				.field("patronymic", "patronymic")
				.field("id", "id")
				.register();
	}
	

	public abstract ToClass map(FromClass object, Class<ToClass> toClass);

	public abstract List<ToClass> mapAsList(List<FromClass> object,	Class<ToClass> toClass);

}
