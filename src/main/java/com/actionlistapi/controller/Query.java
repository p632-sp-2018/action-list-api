package com.actionlistapi.controller;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;

import com.actionlistapi.model.ActionType;
import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.repository.KrewItmActnListRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Transactional
public class Query implements GraphQLQueryResolver{
	private KrewItmActnListRepository krewItmActnListRepository;
	
	public Query(KrewItmActnListRepository krewItmActnListRepository) {
		this.krewItmActnListRepository = krewItmActnListRepository;
	}
	
	public Iterable<KrewActnItmT> findAllKrewActnItmT(){
		Iterable<KrewActnItmT> list = krewItmActnListRepository.findAll();
		for(KrewActnItmT k : list ) {
			k.setRqstLbl(ActionType.fromCode(k.getRqstCd(),true).getLabel());
		}
		return list;
	}
	
	public KrewActnItmT findKrewActnItmT(String id) {
		return krewItmActnListRepository.findOne(id);
	}
	
	public Iterable<KrewActnItmT> pageKrewActnItmT(Integer page, Integer count){
		
		return krewItmActnListRepository.findAll(new PageRequest(page,count));
	}
	
}
