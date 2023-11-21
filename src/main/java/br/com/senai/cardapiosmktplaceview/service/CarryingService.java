package br.com.senai.cardapiosmktplaceview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.cardapiosmktplaceview.model.Carrying;
import br.com.senai.cardapiosmktplaceview.repository.CarriersRepository;

@Service
@Validated
public class CarryingService {
	
	@Autowired
	private CarriersRepository repository;
	
	public Carrying findBy(Integer idUser) {
		return repository.findByUser(idUser);
	}
}
