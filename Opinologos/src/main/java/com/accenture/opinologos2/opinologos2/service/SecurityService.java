package com.accenture.opinologos2.opinologos2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public class SecurityService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	public String findLoggedInUserName() {
		Object detail = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (detail instanceof UserDetails) {
			return ((UserDetails) detail).getUsername();
		}
		return null;
	};

	public void autoLogin(String nick, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(nick);
		System.out.println(nick + password);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

		}
	}
}
