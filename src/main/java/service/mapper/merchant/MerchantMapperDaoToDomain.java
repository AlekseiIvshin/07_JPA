package service.mapper.merchant;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class MerchantMapperDaoToDomain<FromClass, ToClass> extends MerchantMapper<FromClass, ToClass>{
	
	public MerchantMapperDaoToDomain(Class<FromClass> fromClass,
			Class<ToClass> toClass) {
		super(fromClass, toClass);
	}

	@Override
	public ToClass map(FromClass object, Class<ToClass> toClass) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return (ToClass) mapperFacade.map(object, toClass);
	}

	@Override
	public List<ToClass> mapAsList(List<FromClass> object,
			Class<ToClass> toClass) {
		MapperFacade mapperFacade = mapperFactory.getMapperFacade();
		return  (List<ToClass>) mapperFacade.mapAsList(object, toClass);
	}

}
