package com.actionlistapi.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actionlistapi.datafetcher.ActionItemDataFetcher;
import com.actionlistapi.datafetcher.AllActionItemsDataFetcher;
import com.actionlistapi.datafetcher.PageActionItemDataFetcher;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@RestController
@RequestMapping(value="/graphql")
public class QueryController {

	@Value("classpath:/graphql/actionItm.graphqls")
	private Resource schemaResource;
	
	
	
	private GraphQL graphQL;
	

	@Autowired
	@Qualifier("graphQLDate")
	private GraphQLScalarType Date;


	
	@Autowired
	private AllActionItemsDataFetcher allActionItemsDataFetcher;
	
	@Autowired
	private ActionItemDataFetcher actionItemDataFetcher;
	

	@Autowired
	private PageActionItemDataFetcher pageActionItemDataFetcher;
	
	@PostConstruct
	public void loadSchema() throws IOException {
		File schemaFile = schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
		
	}

	private RuntimeWiring buildRuntimeWiring() {
		

		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
						.dataFetcher("findAllKrewActionItem", allActionItemsDataFetcher)
						.dataFetcher("findKrewActionItem", actionItemDataFetcher)
						.dataFetcher("pageKrewActionItem", pageActionItemDataFetcher))
						.scalar(Date)
						
				.build();
	}
	
	@PostMapping
	public ResponseEntity query(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return ResponseEntity.ok(result.getData());
		
	}
	
}
