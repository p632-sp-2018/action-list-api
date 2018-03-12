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

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ActionListApiApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public class ActionListApiApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setUp() throws IOException {
		
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void findAllIntegrationTest() throws Exception {
		String query ="{ "
				+ "findAllKrewActionItem { "
				+ "id "
				+ "group {"
				+ "id "
				+ "name "
				+ "description "
				+ "} } }";
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].id").value("aid1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.id").value("a1"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.name").value("nightwatchers"))
         .andExpect(jsonPath("$.findAllKrewActionItem.[0].group.description").value("Group working for UITS in OOSM course"))
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
         ;
		
	}
	
	@Test
	public void PageResultsIntegrationTest() throws Exception {
		String query ="{ "
				+ "pageKrewActionItem ( offset: 1, limit: 1 )" 
				+ "{ "
				+ "id "
				+ "documentTypeLabel "
				+ " }"
				+ " }"; 
		
		ResultActions postResult = performGraphQlPost(query);
		
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist())
         .andDo(print())
         .andExpect(jsonPath("$.pageKrewActionItem.[0].id").value("aid2"))
         .andExpect(jsonPath("$.pageKrewActionItem.[0].documentTypeLabel").value("i30_lbl"))
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
