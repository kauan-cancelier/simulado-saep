package br.com.senai.cardapiosmktplaceview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.cardapiosmktplaceview.model.Delivery;
import br.com.senai.cardapiosmktplaceview.repository.DeliveryRepository;

public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	public List<Delivery> findAll() {
		return deliveryRepository.findAll();
	}

}
