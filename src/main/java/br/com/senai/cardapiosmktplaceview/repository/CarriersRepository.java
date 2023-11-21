package br.com.senai.cardapiosmktplaceview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senai.cardapiosmktplaceview.model.Carrying;

public interface CarriersRepository extends JpaRepository<Carrying, Integer>{

	@Query("SELECT c FROM Carrying c, User u WHERE c.user = u AND u.id = :idUser")
	public Carrying findByUser(Integer idUser);
	
}
