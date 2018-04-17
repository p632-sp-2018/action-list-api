package com.actionlistapi.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ActionItem.class)
public abstract class ActionItem_ {

	public static volatile SingularAttribute<ActionItem, String> documentTypeLabel;
	public static volatile SingularAttribute<ActionItem, Principal> requestedOf;
	public static volatile SingularAttribute<ActionItem, String> documentUrl;
	public static volatile SingularAttribute<ActionItem, Document> document;
	public static volatile SingularAttribute<ActionItem, String> requestCode;
	public static volatile SingularAttribute<ActionItem, String> principalId;
	public static volatile SingularAttribute<ActionItem, String> id;
	public static volatile SingularAttribute<ActionItem, String> documentTypeName;
	public static volatile SingularAttribute<ActionItem, Date> creationDate;
	public static volatile SingularAttribute<ActionItem, String> title;
	public static volatile SingularAttribute<ActionItem, String> requestLabel;
	public static volatile SingularAttribute<ActionItem, Group> group;

}

