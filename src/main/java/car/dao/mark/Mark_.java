package car.dao.mark;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Mark.class)
public class Mark_ {

	public static SingularAttribute<Mark, Integer> id;
	public static SingularAttribute<Mark, String> name;
}
