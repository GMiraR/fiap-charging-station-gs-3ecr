package br.com.fiap.station.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.station.domain.ChargingStation;

public class ChargingStationService {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("chargingStations");
	EntityManager manager = factory.createEntityManager();
	
	public void insert(ChargingStation chargingStation) {
		manager.getTransaction().begin();
		manager.persist(chargingStation);
		manager.getTransaction().commit();
	}
	
	public List<ChargingStation> listAll(){
		String jpql = "SELECT cs FROM ChargingStation cs";
		TypedQuery<ChargingStation> query = manager.createQuery(jpql , ChargingStation.class);
		return query.getResultList();
	}
	
	public void delete(ChargingStation chargingStation) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(chargingStation));
		manager.getTransaction().commit();
	}
	
	public void update(ChargingStation chargingStation) {
		manager.getTransaction().begin();
		manager.merge(chargingStation);
		manager.getTransaction().commit();
	}

}
