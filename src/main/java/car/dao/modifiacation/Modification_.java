package car.dao.modifiacation;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import car.dao.model.Model;

@StaticMetamodel(Modification.class)
public class Modification_ {

	public static SingularAttribute<Modification, Integer> id;
	public static SingularAttribute<Modification, String> name;
	public static SingularAttribute<Modification, Model> model;
}
