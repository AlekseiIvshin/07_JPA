package store.dao;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import car.dao.modifiacation.Modification;

@StaticMetamodel (Store.class)
public class Store_ {
	public static SingularAttribute<Store, Integer> id;
	public static SingularAttribute<Store, Modification> modification;
	public static SingularAttribute<Store, Integer> count;
	public static SingularAttribute<Store, Float> price;
	public static SingularAttribute<Store, Boolean> testDriveAvaible;

}
