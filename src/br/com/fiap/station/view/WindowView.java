package br.com.fiap.station.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.com.fiap.station.controller.ChargingStationController;
import br.com.fiap.station.view.util.ListingPanel;
import br.com.fiap.station.view.util.RegisterEditPanel;

import java.io.Serial;

public class WindowView extends JFrame{
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private final JTabbedPane tabs = new JTabbedPane();
	
	private final ChargingStationController chargingStationController = new ChargingStationController(this);
	
	private final RegisterEditPanel editPanel = new RegisterEditPanel(chargingStationController);

	private final ListingPanel listingPanel = new ListingPanel(chargingStationController);
	
	public WindowView() {
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void init() {
		
		editPanel.init();
		listingPanel.init();
		
		tabs.add(editPanel, "Cadastro");
		tabs.add(listingPanel, "Lista" );
		add(tabs);
		setVisible(true);
	}

	public ListingPanel getListing() { return listingPanel; }
	
	public RegisterEditPanel getEditPanel() { return editPanel; }
}
