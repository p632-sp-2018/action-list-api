package com.actionlistapi;

import static org.springframework.restdocs.payload.PayloadDocumentation.beneathPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ActionListApiApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public class ActionListApiApplicationTests extends TimeConfig{
	

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
	@WithMockUser(username="pid1",roles="USER")
	public void findAllIntegrationTest() throws Exception {
		String query ="{ "
				+ "findAllActionItems { "
				+ "id "
				+ "documentTypeLabel "
				+ "documentTypeName "
				+ "documentUrl "
				+ "title "
				+ "requestCode "
				+ "requestLabel "
				+ "routeLogUrl "
				+ "creationDate "
				
				+ "group { "
				+ "id "
				+ "name "
				+ "nameSpace "
				+ "active "
				+ "groupUrl "
				+ "description "
				+ "lastUpdateDate "
				+ "}"
				
				+ "initiator { "
				+ "universityId "
				+ "networkId "
				+ "defaultDisplayName "
				+ "personUrl "
				+ "active "
				+ "lastUpdateDate "
				+ "}"
				
				+ "document { "
				+ "id "
				+ "routeStatusCode "
				+ "routeStatusLabel "
				+ "lastApprovedDate"
				+ " }"
				+ " }"
				+ " }";
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.findAllActionItems.[0].id").value("aid1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].documentTypeLabel").value("i20_lbl"))
         .andExpect(jsonPath("$.findAllActionItems.[0].documentTypeName").value("20"))
         .andExpect(jsonPath("$.findAllActionItems.[0].documentUrl").value("http://localhost:8080/workflow/documents/aid1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].title").value("action_list"))
         .andExpect(jsonPath("$.findAllActionItems.[0].requestCode").value("A"))
         .andExpect(jsonPath("$.findAllActionItems.[0].requestLabel").value("Approve"))
         .andExpect(jsonPath("$.findAllActionItems.[0].routeLogUrl").value("http://localhost:8080/workflow/documents/aid1/log"))
         .andExpect(jsonPath("$.findAllActionItems.[0].creationDate").value("2018-02-09T15:50:25Z"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.id").value("a1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.name").value("nightwatchers"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.nameSpace").value("nmspc_grp1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.active").value("Y"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.groupUrl").value("http://localhost:8080/identity/groups/a1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.description").value("Group working for UITS in OOSM course"))
         .andExpect(jsonPath("$.findAllActionItems.[0].group.lastUpdateDate").value("2018-02-13T17:45:13Z"))
         .andExpect(jsonPath("$.findAllActionItems.[0].initiator.universityId").value("pid1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].initiator.networkId").value("prncpl1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].initiator.defaultDisplayName").value("Panchal, Sagar Suresh"))
         .andExpect(jsonPath("$.findAllActionItems.[0].initiator.personUrl").value("http://localhost:8080/identity/people/pid1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].initiator.active").value("y"))
         .andExpect(jsonPath("$.findAllActionItems.[0].initiator.lastUpdateDate").value("2018-02-13T17:45:13Z"))
         .andExpect(jsonPath("$.findAllActionItems.[0].document.id").value("dhid1"))
         .andExpect(jsonPath("$.findAllActionItems.[0].document.routeStatusCode").value("I"))
         .andExpect(jsonPath("$.findAllActionItems.[0].document.routeStatusLabel").value("Initiated"))
         .andExpect(jsonPath("$.findAllActionItems.[0].document.lastApprovedDate").value("2017-06-01T00:00:00Z"))
         .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}",
        		         		
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllActionItems.").withSubsectionId("KrewActionItemTable"),
        		         				 FieldDescription.KrewActionItemIntegrationTestFields()),

        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllActionItems.").withSubsectionId("KrewDocumentHeaderTable"),
        		         				 FieldDescription.KrewDocumentHeaderIntegrationTestFields()),
        		         		 
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllActionItems.").withSubsectionId("KrimPrincipalTable"),
        		         				 FieldDescription.KrimPrincipalIntegrationTestFields()),
        		         		 
        		         		 PayloadDocumentation.relaxedResponseFields(
        		         				 beneathPath("findAllActionItems.").withSubsectionId("KrimGroupTable"),
        		         				 FieldDescription.KrimGroupIntegrationTestFields())
        		 
        		 ) )
         ;
		 
		 
	
	}
	
	@Test
	@WithMockUser(username="pid1",roles="USER")
	public void findOneIntegrationTest() throws Exception {
		String query ="{ "
				+ "findActionItem ( id:\"aid10\" ) "
				+ "{ "
				+ "id "
				+ "documentTypeLabel "
				+ "documentTypeName "
				+ "documentUrl "
				+ "title "
				+ "requestCode "
				+ "requestLabel "
				+ "routeLogUrl "
				+ "creationDate "
				
				+ "group { "
				+ "id "
				+ "name "
				+ "nameSpace "
				+ "active "
				+ "groupUrl "
				+ "description "
				+ "lastUpdateDate "
				+ "}"
				
				+ "initiator { "
				+ "universityId "
				+ "networkId "
				+ "defaultDisplayName "
				+ "personUrl "
				+ "active "
				+ "lastUpdateDate "
				+ "}"
				
				+ "document { "
				+ "id "
				+ "routeStatusCode "
				+ "routeStatusLabel "
				+ "lastApprovedDate"
				+ " }"
				+ " }"
				+ "}"; 
		
		ResultActions postResult = performGraphQlPost(query);

		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.findActionItem.id").value("aid10"))
         .andExpect(jsonPath("$.findActionItem.documentTypeLabel").value("credit card"))
         .andExpect(jsonPath("$.findActionItem.documentTypeName").value("200"))
         .andExpect(jsonPath("$.findActionItem.documentUrl").value("http://localhost:8080/workflow/documents/aid10"))
         .andExpect(jsonPath("$.findActionItem.title").value("travis"))
         .andExpect(jsonPath("$.findActionItem.requestCode").value("A"))
         .andExpect(jsonPath("$.findActionItem.requestLabel").value("Approve"))
         .andExpect(jsonPath("$.findActionItem.routeLogUrl").value("http://localhost:8080/workflow/documents/aid10/log"))
         .andExpect(jsonPath("$.findActionItem.creationDate").value("2017-11-25T20:34:57Z"))
         .andExpect(jsonPath("$.findActionItem.group.id").value("a1"))
         .andExpect(jsonPath("$.findActionItem.group.name").value("nightwatchers"))
         .andExpect(jsonPath("$.findActionItem.group.nameSpace").value("nmspc_grp1"))
         .andExpect(jsonPath("$.findActionItem.group.active").value("Y"))
         .andExpect(jsonPath("$.findActionItem.group.groupUrl").value("http://localhost:8080/identity/groups/a1"))
         .andExpect(jsonPath("$.findActionItem.group.description").value("Group working for UITS in OOSM course"))
         .andExpect(jsonPath("$.findActionItem.group.lastUpdateDate").value("2018-02-13T17:45:13Z"))
         .andExpect(jsonPath("$.findActionItem.initiator.universityId").value("pid1"))
         .andExpect(jsonPath("$.findActionItem.initiator.networkId").value("prncpl1"))
         .andExpect(jsonPath("$.findActionItem.initiator.defaultDisplayName").value("Panchal, Sagar Suresh"))
         .andExpect(jsonPath("$.findActionItem.initiator.personUrl").value("http://localhost:8080/identity/people/pid1"))
         .andExpect(jsonPath("$.findActionItem.initiator.active").value("y"))
         .andExpect(jsonPath("$.findActionItem.initiator.lastUpdateDate").value("2018-02-13T17:45:13Z"))
         .andExpect(jsonPath("$.findActionItem.document.id").value("dhid2"))
         .andExpect(jsonPath("$.findActionItem.document.routeStatusCode").value("S"))
         .andExpect(jsonPath("$.findActionItem.document.routeStatusLabel").value("Saved"))
         .andExpect(jsonPath("$.findActionItem.document.lastApprovedDate").value("2017-07-01T00:00:00Z"))
         .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}",

         		 PayloadDocumentation.responseFields(
         				 beneathPath("findActionItem.").withSubsectionId("KrewActionItemTable"),
         				 FieldDescription.FindActionItemIntegrationTestFields())

        		 ) )
         ;
		
	}
	
	@Test
	@WithMockUser(username="pid2",roles="USER")
	public void PageResultsIntegrationTest() throws Exception {
		String query ="{ "
				+ "pageActionItems ( offset: 0, limit: 1 )"
				+ "{ "
				+ "id "
				+ "documentTypeLabel "
				+ "documentTypeName "
				+ "documentUrl "
				+ "title "
				+ "requestCode "
				+ "requestLabel "
				+ "routeLogUrl "
				+ "creationDate "
				
				+ "group { "
				+ "id "
				+ "name "
				+ "nameSpace "
				+ "active "
				+ "groupUrl "
				+ "description "
				+ "lastUpdateDate "
				+ "}"
				
				+ "initiator { "
				+ "universityId "
				+ "networkId "
				+ "defaultDisplayName "
				+ "personUrl "
				+ "active "
				+ "lastUpdateDate "
				+ "}"
				
				+ "document { "
				+ "id "
				+ "routeStatusCode "
				+ "routeStatusLabel "
				+ "lastApprovedDate"
				+ " }"
				+ " }"
				+ " }"; 
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.pageActionItems.[0].id").value("aid2"))
         .andExpect(jsonPath("$.pageActionItems.[0].documentTypeLabel").value("i30_lbl"))
         .andExpect(jsonPath("$.pageActionItems.[0].documentTypeName").value("40"))
         .andExpect(jsonPath("$.pageActionItems.[0].documentUrl").value("http://localhost:8080/workflow/documents/aid2"))
         .andExpect(jsonPath("$.pageActionItems.[0].title").value("data_api"))
         .andExpect(jsonPath("$.pageActionItems.[0].requestCode").value("C"))
         .andExpect(jsonPath("$.pageActionItems.[0].requestLabel").value("Complete"))
         .andExpect(jsonPath("$.pageActionItems.[0].routeLogUrl").value("http://localhost:8080/workflow/documents/aid2/log"))
         .andExpect(jsonPath("$.pageActionItems.[0].creationDate").value("2018-02-13T00:29:40Z"))
         .andExpect(jsonPath("$.pageActionItems.[0].group").doesNotExist())
         .andExpect(jsonPath("$.pageActionItems.[0].initiator.universityId").value("pid2"))
         .andExpect(jsonPath("$.pageActionItems.[0].initiator.networkId").value("prncpl2"))
         .andExpect(jsonPath("$.pageActionItems.[0].initiator.defaultDisplayName").doesNotExist())
         .andExpect(jsonPath("$.pageActionItems.[0].initiator.personUrl").value("http://localhost:8080/identity/people/pid2"))
         .andExpect(jsonPath("$.pageActionItems.[0].initiator.active").value("n"))
         .andExpect(jsonPath("$.pageActionItems.[0].initiator.lastUpdateDate").value("2018-01-24T16:05:32Z"))
         .andExpect(jsonPath("$.pageActionItems.[0].document.id").value("dhid2"))
         .andExpect(jsonPath("$.pageActionItems.[0].document.routeStatusCode").value("S"))
         .andExpect(jsonPath("$.pageActionItems.[0].document.routeStatusLabel").value("Saved"))
         .andExpect(jsonPath("$.pageActionItems.[0].document.lastApprovedDate").value("2017-07-01T00:00:00Z"))
         .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}",
	         		
         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("pageActionItems.").withSubsectionId("KrewActionItemTable"),
         				 FieldDescription.KrewActionItemIntegrationTestFields()),

         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("pageActionItems.").withSubsectionId("KrewDocumentHeaderTable"),
         				 FieldDescription.KrewDocumentHeaderIntegrationTestFields()),
         		 
         		 PayloadDocumentation.relaxedResponseFields(
         				 beneathPath("pageActionItems.").withSubsectionId("KrimPrincipalTable"),
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
                .content(query)
        );
    }

   }
