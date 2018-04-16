package com.actionlistapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ActionSpecification implements Specification<ActionItem> {

	private ActionItemFilter filter;
	
	public ActionSpecification(ActionItemFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<ActionItem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
		Path<String> documentTypeLabel = root.get(ActionItem_ .documentTypeLabel);
		Path<String> requestCode = root.get(ActionItem_ .requestCode);
		Path<Document> document = root.get(ActionItem_ .document);
		Path<String> routeStatusCode = document.get(Document_.routeStatusCode);
		Path<String> principalId = root.get(ActionItem_ .principalId);
	
		final List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(filter.getDocumentTypeLabel() != null) {
			predicates.add(cb.equal(documentTypeLabel, filter.getDocumentTypeLabel()));
		}
		
		if(filter.getRequestCode() != null) {
			predicates.add(cb.equal(requestCode, filter.getRequestCode()));
		}
		
		if(filter.getRouteStatusCode() != null) {
			predicates.add(cb.equal(routeStatusCode, filter.getRouteStatusCode()));
		}
		
		if(filter.getUserId() != null) {
			predicates.add(cb.equal(principalId, filter.getUserId()));
		}
		
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}
