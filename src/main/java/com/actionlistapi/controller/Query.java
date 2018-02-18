package com.actionlistapi.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

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
		return krewItmActnListRepository.findAll();
	}
	
	public KrewActnItmT findKrewActnItmT(String id) {
		return krewItmActnListRepository.findOne(id);
	}
	
	public Iterable<KrewActnItmT> pageKrewActnItmT(Integer page, Integer count){
		
		return krewItmActnListRepository.findAll(new PageRequest(page,count));
	}
	
}
