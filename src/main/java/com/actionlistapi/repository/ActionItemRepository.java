package com.actionlistapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.actionlistapi.model.ActionItem;



public interface ActionItemRepository extends PagingAndSortingRepository<ActionItem,String>{

}
