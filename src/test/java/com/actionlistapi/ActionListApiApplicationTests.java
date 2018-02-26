package com.actionlistapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.annotation.WebInitParam;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {ActionListApiApplication.class})
@WebAppConfiguration
public class ActionListApiApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	@Before
	public void setUp() throws IOException {
		
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void ActionListIntegrationTest() throws Exception {
		String query ="{"
				+ " findAllKrewActnItmT { "
				+ " actnItmId "
				+ " }"
				+ " }"; 
		
		ResultActions postResult = performGraphQlPost(query);
		
		 postResult.andExpect(status().isOk())
         .andExpect(jsonPath("$.errors").doesNotExist());

		
	}
	
	
	private ResultActions performGraphQlPost(String query) throws Exception {
        return performGraphQlPost(query, null);
    }

    private ResultActions performGraphQlPost(String query, Map variables) throws Exception {
        return mockMvc.perform(post("/graphiql")
                .contentType(MediaType.APPLICATION_JSON)
                .content(generateRequest(query, variables))
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
