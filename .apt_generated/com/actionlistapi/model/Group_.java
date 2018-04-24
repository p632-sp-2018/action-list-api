package com.actionlistapi.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Group.class)
public abstract class Group_ {

	public static volatile SingularAttribute<Group, Date> lastUpdateDate;
	public static volatile SingularAttribute<Group, String> name;
	public static volatile SingularAttribute<Group, String> description;
	public static volatile SingularAttribute<Group, String> active;
	public static volatile SingularAttribute<Group, String> id;
	public static volatile SingularAttribute<Group, String> nameSpace;

}

