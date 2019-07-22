package com.accenture.opinologos2.opinologos2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.opinologos2.opinologos2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserNameIgnoreCase(String nick);
	public User findByMail(String mail);
	public User findByUserNameAndPassword(String userName, String password);
	public List<User> findByName(String name);
}
