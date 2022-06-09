package br.com.fiap.station.controller;

import java.util.List;

import br.com.fiap.station.domain.Address;
import br.com.fiap.station.domain.ChargingStation;
import br.com.fiap.station.service.ChargingStationService;
import br.com.fiap.station.view.WindowView;

public class ChargingStationController {

	ChargingStationService chargingStationService;
	WindowView view;
	
	public ChargingStationController(WindowView view) {
		chargingStationService = new ChargingStationService();
		this.view = view;
	}

	public List<ChargingStation> listStations() {
		return chargingStationService.listAll();
	}

	public void save(String name, String street, String district, String city, String state, List<String> plugs, int rating, Double price) {
		ChargingStation chargingStation = new ChargingStation();
		chargingStation.setName(name);
		chargingStation.setAddress(new Address(street, district, city, state));
		chargingStation.setPlugs(plugs);
		chargingStation.setRating(rating);
		chargingStation.setPrice(price);

		chargingStationService.insert(chargingStation);
		view.getListing().update();
	}
	
	public void delete(Long id) {
		ChargingStation chargingStation = new ChargingStation();
		chargingStation.setId(id);
		
		chargingStationService.delete(chargingStation);
		view.getListing().update();
	}



}
