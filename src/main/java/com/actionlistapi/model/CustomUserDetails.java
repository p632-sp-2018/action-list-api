package com.actionlistapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

// Provided Implementation of a custom userdetails class to be used by spring auth module

public class CustomUserDetails extends Principal implements UserDetails{

	private Principal user;
	
	public CustomUserDetails(final Principal user) {
		this.setUser(user);
	}
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
    	return user.getUniversityId();
    }

    @Override
    public String getUsername() {
        return user.getUniversityId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	public Principal getUser() {
		return user;
	}

	public void setUser(Principal user) {
		this.user = user;
	}
}
