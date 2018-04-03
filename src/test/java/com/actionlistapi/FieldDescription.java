package com.actionlistapi;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.PayloadDocumentation;

import graphql.schema.GraphQLScalarType;


public class FieldDescription {

	public FieldDescription() {
		//empty constructor		
	}


    
//    public static FieldDescriptor[] findAllIntegrationTestFields() {
//    	  
//	    	return new FieldDescriptor[]{
//	    			PayloadDocumentation.fieldWithPath("[0]").description("The Krew Action Item Object")
//	    			.andWithPrefix("[0]",FieldDescription.FindAllActionItemIntegrationTestFields())
//	    			
//	    		};
//    }

    
//	PayloadDocumentation.fieldWithPath("findActionItem.id").description("The Krew Action Item Document type Label")
//        				PayloadDocumentation.fieldWithPath("findActionItem.creationDate").type(GraphQLScalarType.class).description("The Krew Action Item Creation Date")
//                  		PayloadDocumentation.fieldWithPath("findActionItem.id").description("The Krew Action Item Identifier")
    

	
    public static FieldDescriptor[] FindActionItemIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("id").description("Identifier. Must be Unique"),
        				   PayloadDocumentation.fieldWithPath("title").description("Title describing the item"),
        				   PayloadDocumentation.fieldWithPath("documentTypeLabel").description("Label denoting type of the document"),
        				   PayloadDocumentation.fieldWithPath("documentUrl").description("Document URL"),
        				   PayloadDocumentation.fieldWithPath("documentTypeName").description("Document Type Name"),
        				   PayloadDocumentation.fieldWithPath("requestCode").description("Request Code assigned to the item"),
        				   PayloadDocumentation.fieldWithPath("requestLabel").description("Request Label synchronous to the Request Code"),
        				   PayloadDocumentation.fieldWithPath("routeLogUrl").description("Route Log URL"), 
        				   PayloadDocumentation.fieldWithPath("creationDate").type(GraphQLScalarType.class).description("Date of creation"),
        				   PayloadDocumentation.fieldWithPath("document.id").description("Document Identifier"),
        				   PayloadDocumentation.fieldWithPath("document.routeStatusCode").description("Document Route Status Code"),
        				   PayloadDocumentation.fieldWithPath("document.routeStatusLabel").description("Document Route Status Label synchronous to the Route Status Code "),
        				   PayloadDocumentation.fieldWithPath("document.lastApprovedDate").type(GraphQLScalarType.class).description("Last Approved Date for Document"),
        				   PayloadDocumentation.fieldWithPath("requestedOf.universityId").description("University Identifier of the authorised user"),
        				   PayloadDocumentation.fieldWithPath("requestedOf.networkId").description("Network Identifier of the authorised user"),
        				   PayloadDocumentation.fieldWithPath("requestedOf.defaultDisplayName").description("Default Display Name of the authorised user"),
        				   PayloadDocumentation.fieldWithPath("requestedOf.personUrl").description("Person URL"),
        				   PayloadDocumentation.fieldWithPath("requestedOf.active").description("Activity Status of the authorised user"),
        				   PayloadDocumentation.fieldWithPath("requestedOf.lastUpdateDate").type(GraphQLScalarType.class).description("Last Updated Date"),
        				   PayloadDocumentation.fieldWithPath("group.id").description("Group Identifier"),
        				   PayloadDocumentation.fieldWithPath("group.name").description("Group Name corresponding to the Group Identifier"),
        				   PayloadDocumentation.fieldWithPath("group.nameSpace").description("Group Name Space corresponding to the Group Identifier"),
        				   PayloadDocumentation.fieldWithPath("group.description").description("Group description"),
        				   PayloadDocumentation.fieldWithPath("group.groupUrl").description("Group URL"),
        				   PayloadDocumentation.fieldWithPath("group.active").description("Group Status denoting Activity"),
        				   PayloadDocumentation.fieldWithPath("group.lastUpdateDate").type(GraphQLScalarType.class).description("Last Updated Date for Group")
		};
    }
    
	
    public static FieldDescriptor[] KrewActionItemIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].id").description("Identifier. Must be Unique"),
        				   PayloadDocumentation.fieldWithPath("[0].title").description("Title describing the item"),
        				   PayloadDocumentation.fieldWithPath("[0].documentTypeLabel").description("Label denoting type of the document"),
        				   PayloadDocumentation.fieldWithPath("[0].documentUrl").description("Document URL"),
        				   PayloadDocumentation.fieldWithPath("[0].documentTypeName").description("Document Type Name"),
        				   PayloadDocumentation.fieldWithPath("[0].requestCode").description("Request Code assigned to the item"),
        				   PayloadDocumentation.fieldWithPath("[0].requestLabel").description("Request Label synchronous to the Request Code"),
        				   PayloadDocumentation.fieldWithPath("[0].routeLogUrl").description("Route Log URL"), 
        				   PayloadDocumentation.fieldWithPath("[0].creationDate").type(GraphQLScalarType.class).description("Date of creation")
        				   

		};
    }
    
    public static FieldDescriptor[] KrewDocumentHeaderIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].document.id").description("Document Identifier"),
        				   PayloadDocumentation.fieldWithPath("[0].document.routeStatusCode").description("Document Route Status Code"),
        				   PayloadDocumentation.fieldWithPath("[0].document.routeStatusLabel").description("Document Route Status Label synchronous to the Route Status Code "),
        				   PayloadDocumentation.fieldWithPath("[0].document.lastApprovedDate").type(GraphQLScalarType.class).description("Last Approved Date for Document")

    
		};
    }
    
    public static FieldDescriptor[] KrimPrincipalIntegrationTestFields() {
    	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].requestedOf.universityId").description("University Identifier for the requestedOf"),
        				   PayloadDocumentation.fieldWithPath("[0].requestedOf.networkId").description("Network Identifier for the requestedOf"),
        				   PayloadDocumentation.fieldWithPath("[0].requestedOf.defaultDisplayName").description("Default Display Name for the requestedOf"),
        				   PayloadDocumentation.fieldWithPath("[0].requestedOf.personUrl").description("Person URL"),
        				   PayloadDocumentation.fieldWithPath("[0].requestedOf.active").description("Activity Status for the requestedOf"),
        				   PayloadDocumentation.fieldWithPath("[0].requestedOf.lastUpdateDate").type(GraphQLScalarType.class).description("Last Updated Date")
    
		};
    }
    
    public static FieldDescriptor[] KrimGroupIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].group.id").description("Group Identifier"),
        				   PayloadDocumentation.fieldWithPath("[0].group.name").description("Group Name corresponding to the Group Identifier"),
        				   PayloadDocumentation.fieldWithPath("[0].group.nameSpace").description("Group Name Space corresponding to the Group Identifier"),
        				   PayloadDocumentation.fieldWithPath("[0].group.description").description("Group description"),
        				   PayloadDocumentation.fieldWithPath("[0].group.groupUrl").description("Group URL"),
        				   PayloadDocumentation.fieldWithPath("[0].group.active").description("Group Status denoting Activity"),
        				   PayloadDocumentation.fieldWithPath("[0].group.lastUpdateDate").type(GraphQLScalarType.class).description("Last Updated Date for Group")
    
		};
    }
    
    
    
    
}  