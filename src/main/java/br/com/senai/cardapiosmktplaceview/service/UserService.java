package br.com.senai.cardapiosmktplaceview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.cardapiosmktplaceview.model.User;
import br.com.senai.cardapiosmktplaceview.repository.UserRepository;

@Service
@Validated
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User login(String email, String password) {
		return repository.findUserBy(email, password);
	}
}
