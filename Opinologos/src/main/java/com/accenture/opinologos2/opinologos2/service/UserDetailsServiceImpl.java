package com.accenture.opinologos2.opinologos2.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.opinologos2.opinologos2.model.Rol;
import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
	@Autowired
    private UserRepository userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nick) {
    	
        User user = userRepo.findByUserNameIgnoreCase(nick);
        if (user == null) throw new UsernameNotFoundException(nick);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        
        //TODO chicos aca tienen que cargar los roles que definan para la instancia User que tengan logueado
        for (Rol role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        System.out.println();
        
        UserDetails userP  = (UserDetails) new org.springframework.security.core.userdetails.User(nick, user.getPassword(), grantedAuthorities); //Usuario que se carga en sesion
		
		return userP;
    }
    
}