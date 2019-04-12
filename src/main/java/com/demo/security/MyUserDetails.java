package com.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.dao.*;
import com.demo.model.Staff;

@Service
public class MyUserDetails {

	@Autowired
	private SecutityDao userDao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff account = userDao.getStaff(username);
		if (account == null) {
			return null;
		} else {
			return User.withUsername(username).password(account.getSchool())
					.roles(Integer.toString(account.getRoless())).accountExpired(false).accountLocked(false)
					.credentialsExpired(false).disabled(false).build();
		}

	}

}
