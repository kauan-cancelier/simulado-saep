package br.com.senai.cardapiosmktplaceview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cardapiosmktplaceview.model.Driver;

@Repository
public interface DriversRepository extends JpaRepository<Driver, Integer> {

}
