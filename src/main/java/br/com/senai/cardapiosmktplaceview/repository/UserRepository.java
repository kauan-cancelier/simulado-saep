package br.com.senai.cardapiosmktplaceview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senai.cardapiosmktplaceview.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u "
			+ "FROM User u "
			+ "WHERE "
			+ "u.email = :email "
			+ "AND u.password = :password")
	
	public User findUserBy(String email, String password);
	
	
}
