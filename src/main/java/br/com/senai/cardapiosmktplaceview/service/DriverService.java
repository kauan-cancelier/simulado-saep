package br.com.senai.cardapiosmktplaceview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.cardapiosmktplaceview.model.Driver;
import br.com.senai.cardapiosmktplaceview.repository.DriversRepository;

@Service
@Validated
public class DriverService {

	@Autowired
	private DriversRepository repository;
	
	public List<Driver> findAll() {
		return repository.findAll();
	}
	
}
