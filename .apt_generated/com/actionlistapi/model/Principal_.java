package com.actionlistapi.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Principal.class)
public abstract class Principal_ {

	public static volatile SingularAttribute<Principal, String> universityId;
	public static volatile SingularAttribute<Principal, Date> lastUpdateDate;
	public static volatile SingularAttribute<Principal, String> active;
	public static volatile SingularAttribute<Principal, String> networkId;
	public static volatile SingularAttribute<Principal, EntityName> entity;

}

