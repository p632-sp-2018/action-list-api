package com.actionlistapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.HttpMethod;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import org.springframework.restdocs.payload.RequestFieldsSnippet.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ActionListApiApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public class ActionListApiApplicationTests {
	
	private MockMvc mockMvc;
	
	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
	
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setUp() throws IOException {
		
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
	    			.apply(MockMvcRestDocumentation.documentationConfiguration(this.restDocumentation))
	    			.build();
	}
	
	@Test
	public void findAllIntegrationTest() throws Exception {
		String query ="{ "
				+ "findAllKrewActionItem { "
				+ "id "
				+ "documentTypeLabel "
				+ "documentTypeName "
				+ "documentUrl "
				+ "title "
				+ "requestCode "
				+ "requestLabel "
				+ "routeLogUrl "
				
				+ "group { "
				+ "id "
				+ "name "
				+ "nameSpace "
				+ "active "
				+ "groupUrl "
				+ "description "
				+ "}"
				
				+ "initiator { "
				+ "universityId "
				+ "networkId "
				+ "defaultDisplayName "
				+ "personUrl "
				+ "active "
				+ "}"
				
				+ "document { "
				+ "id "
				+ "routeStatus "
				+ " }"
				+ " }"
				+ " }";
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].id").value("aid1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].documentTypeLabel").value("i20_lbl"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].documentTypeName").value("20"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].documentUrl").value("http://localhost:8080/workflow/documents/aid1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].title").value("action_list"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].requestCode").value("A"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].requestLabel").value("Approve"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].routeLogUrl").value("http://localhost:8080/workflow/documents/aid1/log"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.id").value("a1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.name").value("nightwatchers"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.nameSpace").value("nmspc_grp1")) 
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.active").value("Y"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.groupUrl").doesNotExist())
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.description").value("Group working for UITS in OOSM course"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].initiator.universityId").value("pid1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].initiator.networkId").value("prncpl1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].initiator.defaultDisplayName").doesNotExist())
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].initiator.personUrl").doesNotExist())
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].initiator.active").value("y"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].document.id").value("dhid1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].document.routeStatus").value("I"))
         .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}",
        		         		
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllKrewActionItem.").withSubsectionId("KrewActionItemTable"),
        		         				 FieldDescription.KrewActionItemIntegrationTestFields()),
         
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllKrewActionItem.").withSubsectionId("KrewDocumentHeaderTable"),
        		         				 FieldDescription.KrewDocumentHeaderIntegrationTestFields()),
        		         		 
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllKrewActionItem.").withSubsectionId("KrimPrincipalTable"),
        		         				 FieldDescription.KrimGroupIntegrationTestFields()),
        		         		 
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllKrewActionItem.").withSubsectionId("KrimGroupTable"),
        		         				 FieldDescription.KrimPrincipalIntegrationTestFields())
        		 
        		 ) )
         ;
		 
		 
	
	}
	
	@Test
	public void findOneIntegrationTest() throws Exception {
		String query ="{ "
				+ "findKrewActionItem ( id:\"aid10\" ) " 
				+ "{ "
				+ "documentTypeLabel "
				+ "} "
				+ "}"; 
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.findKrewActionItem.documentTypeLabel").value("credit card"))
         .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}",
	         		
         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("findKrewActionItem").withSubsectionId("KrewActionItemTable"),
      				   PayloadDocumentation.fieldWithPath("documentTypeLabel")
      				   .description("The Krew Action Item Document Type Label"))

 
        		 ) )
         ;
		
	}
	
	@Test
	public void PageResultsIntegrationTest() throws Exception {
		String query ="{ "
				+ "pageKrewActionItem ( offset: 1, limit: 1 )" 
				+ "{ "
				+ "id "
				+ "documentTypeLabel "
				+ "documentTypeName "
				+ "documentUrl "
				+ "title "
				+ "requestCode "
				+ "requestLabel "
				+ "routeLogUrl "
				
				+ "group { "
				+ "id "
				+ "name "
				+ "nameSpace "
				+ "active "
				+ "groupUrl "
				+ "description "
				+ "}"
				
				+ "initiator { "
				+ "universityId "
				+ "networkId "
				+ "defaultDisplayName "
				+ "personUrl "
				+ "active "
				+ "}"
				
				+ "document { "
				+ "id "
				+ "routeStatus "
				+ " }"
				+ " }"
				+ " }"; 
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.pageKrewActionItem.[0].id").value("aid2"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].documentTypeLabel").value("i30_lbl"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].documentTypeName").value("40"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].documentUrl").value("http://localhost:8080/workflow/documents/aid2"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].title").value("data_api"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].requestCode").value("C"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].requestLabel").value("Complete"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].routeLogUrl").value("http://localhost:8080/workflow/documents/aid2/log"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].group").doesNotExist())
         .andExpect(jsonPath("$.pageKrewActionItem.[0].initiator.universityId").value("pid2"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].initiator.networkId").value("prncpl2"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].initiator.defaultDisplayName").doesNotExist())
         .andExpect(jsonPath("$.pageKrewActionItem.[0].initiator.personUrl").doesNotExist())
         .andExpect(jsonPath("$.pageKrewActionItem.[0].initiator.active").value("n"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].document.id").value("dhid2"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].document.routeStatus").value("S"))
         .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}",
	         		
         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("pageKrewActionItem.").withSubsectionId("KrewActionItemTable"),
         				 FieldDescription.KrewActionItemIntegrationTestFields()),

         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("pageKrewActionItem.").withSubsectionId("KrewDocumentHeaderTable"),
         				 FieldDescription.KrewDocumentHeaderIntegrationTestFields()),
         		 
         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("pageKrewActionItem.").withSubsectionId("KrimPrincipalTable"),
         				 FieldDescription.KrimPrincipalIntegrationTestFields())  
         		 

         
        		 ))
         ;
		
	}
	
	private ResultActions performGraphQlPost(String query) throws Exception {
        return performGraphQlPost(query, null);
    }

    private ResultActions performGraphQlPost(String query, Map variables) throws Exception {
        return mockMvc.perform(post("/graphql")
                .contentType(MediaType.APPLICATION_JSON)
       //         .content(generateRequest(query, variables))
                .content(query)
        );
    }

    private String generateRequest(String query, Map variables) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("query", query);

        if (variables != null) {
            jsonObject.put("variables", Collections.singletonMap("input", variables));
        }

        return jsonObject.toString();
    }
}
