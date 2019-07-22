package com.accenture.opinologos2.opinologos2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.repository.UserRepository;

@Service
public class UserService {
	//Conoce la logica del negocio y la base de datos. Service se comunica con los DAO
	

		@Autowired
		private UserRepository userRepo;
		
		@Autowired
		private BCryptPasswordEncoder passEncoder;
		
		public void save(User s) {
			userRepo.save(s);
		}
		
		public User saveAndEncrypt(User s) {
			s.setPassword(passEncoder.encode(s.getPassword()));
			return userRepo.save(s);
		}
		
		public List<User> findAll(){
			return userRepo.findAll();
		}
		
		public User findByNick(String nick) {
			return userRepo.findByUserNameIgnoreCase(nick);
		}
		public User findByMail(String mail) {
			return userRepo.findByMail(mail);
		}
		
		public User findByUserNameAndPassword(String userName, String password) {
			String pass = passEncoder.encode(password);			
			System.out.println(userName + pass);
			return userRepo.findByUserNameAndPassword(userName, pass);
			
		}
		
		public User getLoggedUser() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			if(currentPrincipalName != null) {
				return userRepo.findByUserNameIgnoreCase(currentPrincipalName);
			}
			return null;
		}
		

	}
