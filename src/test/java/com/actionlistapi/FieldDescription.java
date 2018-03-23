package com.actionlistapi;

import org.springframework.restdocs.payload.FieldDescriptor;

import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.payload.RequestFieldsSnippet;

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
    

	
//    public static FieldDescriptor[] FindAllActionItemIntegrationTestFields() {
//  	  
//		return new FieldDescriptor[]{
//
//        				   PayloadDocumentation.fieldWithPath("id").description("The Krew Action Item Document Identifier"),
//        				   PayloadDocumentation.fieldWithPath("title").description("The Krew Action Item Document Route Status"),
//        				   PayloadDocumentation.fieldWithPath("documentTypeLabel").description("The Krew Action Item Document Route Status"),
//        				   PayloadDocumentation.fieldWithPath("documentUrl").description("The Krew Action Item Document Route Status"),
//        				   PayloadDocumentation.fieldWithPath("documentTypeName").description("The Krew Action Item Document Route Status"),
//        				   PayloadDocumentation.fieldWithPath("requestCode").description("The Krew Action Item Document Route Status"),
//        				   PayloadDocumentation.fieldWithPath("requestLabel").description("The Krew Action Item Document Route Status"),
//        				   PayloadDocumentation.fieldWithPath("routeLogUrl").description("The Krew Action Item Document Route Status"), 
//		};
//    }
//    
	
    public static FieldDescriptor[] KrewActionItemIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].id").description("The Krew Action Item Document Identifier"),
        				   PayloadDocumentation.fieldWithPath("[0].title").description("The Krew Action Item title"),
        				   PayloadDocumentation.fieldWithPath("[0].documentTypeLabel").description("The Krew Action Item Document Type Label"),
        				   PayloadDocumentation.fieldWithPath("[0].documentUrl").description("The Krew Action Item Document URL"),
        				   PayloadDocumentation.fieldWithPath("[0].documentTypeName").description("The Krew Action Item Document Type Name"),
        				   PayloadDocumentation.fieldWithPath("[0].requestCode").description("The Krew Action Item Request Code"),
        				   PayloadDocumentation.fieldWithPath("[0].requestLabel").description("The Krew Action Item Request Label"),
        				   PayloadDocumentation.fieldWithPath("[0].routeLogUrl").description("The Krew Action Item Route Log URL"), 
        				   PayloadDocumentation.fieldWithPath("[0].creationDate").type(GraphQLScalarType.class).description("The Krew Action Item Creation Date")
		};
    }
    
    public static FieldDescriptor[] KrewDocumentHeaderIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].document.id").description("Document Identifier retrieved from KrewDocHdrT"),
        				   PayloadDocumentation.fieldWithPath("[0].document.routeStatusCode").description("Document Route Status Code retrieved from KrewDocHdrT"),
        				   PayloadDocumentation.fieldWithPath("[0].document.lastApprovedDate").type(GraphQLScalarType.class).description("Last Approved Date for Document retrieved from KrewDocHdrT")

    
		};
    }
    
    public static FieldDescriptor[] KrimPrincipalIntegrationTestFields() {
    	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].initiator.universityId").description("University Identifier retrieved from KrimPrncplT"),
        				   PayloadDocumentation.fieldWithPath("[0].initiator.networkId").description("Network Identifier retrieved from KrimPrncplT"),
        				   PayloadDocumentation.fieldWithPath("[0].initiator.defaultDisplayName").description("Default Display Name retrieved from KrimPrncplT"),
        				   PayloadDocumentation.fieldWithPath("[0].initiator.personUrl").description("Person URL retrieved from KrimPrncplT"),
        				   PayloadDocumentation.fieldWithPath("[0].initiator.active").description("Active Status retrieved from KrimPrncplT"),
        				   PayloadDocumentation.fieldWithPath("[0].initiator.lastUpdateDate").type(GraphQLScalarType.class).description("Last Updated Date for Document retrieved from KrewDocHdrT")
    
		};
    }
    
    public static FieldDescriptor[] KrimGroupIntegrationTestFields() {
  	  
		return new FieldDescriptor[]{

        				   PayloadDocumentation.fieldWithPath("[0].group.id").description("Group Identifier retrieved from KrimGrpT"),
        				   PayloadDocumentation.fieldWithPath("[0].group.name").description("Group Name retrieved from KrimGrpT"),
        				   PayloadDocumentation.fieldWithPath("[0].group.nameSpace").description("Group Name Space retrieved from KrimGrpT"),
        				   PayloadDocumentation.fieldWithPath("[0].group.description").description("Group description retrieved from KrimGrpT"),
        				   PayloadDocumentation.fieldWithPath("[0].group.groupUrl").description("Group URL retrieved from KrimGrpT"),
        				   PayloadDocumentation.fieldWithPath("[0].group.active").description("Group Active Status retrieved from KrimGrpT"),
        				   PayloadDocumentation.fieldWithPath("[0].group.lastUpdateDate").type(GraphQLScalarType.class).description("Last Updated Date for Document retrieved from KrewDocHdrT")
    
		};
    }
    
    
    
    
}  