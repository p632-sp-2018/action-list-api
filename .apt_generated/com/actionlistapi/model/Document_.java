package com.actionlistapi.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Document.class)
public abstract class Document_ {

	public static volatile SingularAttribute<Document, String> routeStatusCode;
	public static volatile SingularAttribute<Document, Date> lastApprovedDate;
	public static volatile SingularAttribute<Document, Principal> initiator;
	public static volatile SingularAttribute<Document, String> id;

}

