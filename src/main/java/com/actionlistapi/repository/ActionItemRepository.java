package com.actionlistapi.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.actionlistapi.model.ActionItem;


public interface ActionItemRepository extends JpaRepository<ActionItem,String>, JpaSpecificationExecutor<ActionItem>{
	List<ActionItem> findAllByPrincipalId(String principalId);
	Page<ActionItem> findAllByPrincipalId(String principalId, Pageable page );
	ActionItem findByIdAndPrincipalId(String id, String principalId);
}
