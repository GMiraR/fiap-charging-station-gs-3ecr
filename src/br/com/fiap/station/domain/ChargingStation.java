package br.com.fiap.station.domain;

import java.util.List;
import java.util.Vector;

import javax.persistence.*;

@Entity
public class ChargingStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	private Double price;

	@ElementCollection
	private List<String> plugs;

	private int rating;
	
	public Vector<String> getDataArray() {
		Vector<String> data = new Vector<>();
		data.add(id.toString());
		data.add(name);
		data.add(address.getStreet());
		data.add(address.getDistrict());
		data.add(address.getCity());
		data.add(address.getState());
		data.add(String.valueOf(plugs));
		data.add(String.valueOf(rating));
		data.add(price.toString());

		return data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPlugs(List<String> plugs) {
		this.plugs = plugs;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
