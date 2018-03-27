package com.actionlistapi.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.actionlistapi.ActionListApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ActionListApiApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public class CustomUserDetailsServiceTest {
	
//	@Autowired
//    private PrincipalRepository principalRepository;
//	
	String username1;
	String username2;
	
	@Autowired
    CustomUserDetailsService userDetailsService;
	
	@Before
	public void setUp() throws Exception {
		
		username1 = "pid1";
		username2 = "random-value";
		//customUserDetailsService = new CustomUserDetailsService();
	}
	
	@Test
	public void testLoadUserByUsernameForValidUser() {
		
		UserDetails user = userDetailsService.loadUserByUsername(username1);
		assertEquals(username1,user.getUsername());
		assertEquals(username1,user.getPassword());
		
	}
	
	@Test
	public void testLoadUserByUsernameForInValidUser() {
		
		UserDetails user = userDetailsService.loadUserByUsername(username2);
		assertEquals(null,user);
		
	}
	
}
