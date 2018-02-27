package com.actionlistapi.controller;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actionlistapi.constants.ActionListConstants;
import com.actionlistapi.model.ActionType;
import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.repository.KrewItmActnListRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver{
	private KrewItmActnListRepository krewItmActnListRepository;
	
	public Query(KrewItmActnListRepository krewItmActnListRepository) {
		this.krewItmActnListRepository = krewItmActnListRepository;
	}
	
	
	public Iterable<KrewActnItmT> findAllKrewActnItmT(){
		Iterable<KrewActnItmT> list = krewItmActnListRepository.findAll();
		for(KrewActnItmT k : list ) {
			k.setRequestLabel(getRequestCodeLabel(k.getRequestCode()));
			k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		}
		return list;
	}
	
	public KrewActnItmT findKrewActnItmT(String id) {
		KrewActnItmT k = krewItmActnListRepository.findOne(id);
		k.setRequestLabel(getRequestCodeLabel(k.getRequestCode()));
		k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		return k;
	}
	
	public Iterable<KrewActnItmT> pageKrewActnItmT(Integer page, Integer count){
		Iterable<KrewActnItmT> kList = krewItmActnListRepository.findAll(new PageRequest(page,count)); 
		for(KrewActnItmT k : kList ) {
			k.setRequestLabel(getRequestCodeLabel(k.getRequestCode()));
			k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		}
		return kList; 
	}
	
	
	public String getRequestCodeLabel(String requestCode) {
		return ActionType.fromCode(requestCode).getLabel();
	}
	
}
