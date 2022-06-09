package br.com.fiap.station.view.util;

import java.awt.event.ActionEvent;
import java.io.Serial;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.station.controller.ChargingStationController;
import br.com.fiap.station.domain.ChargingStation;

public class ListingPanel extends JPanel {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private final String[] columns = {"id", "Nome", "Rua", "Bairro", "Cidade", "Estado", "Plugs", "Rating", "Preco"};
	private final DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	private final JTable table = new JTable(tableModel);
	private final JScrollPane scrollPanel = new JScrollPane(table);
	
	private final JButton deleteButton = new JButton("Delete");
	
	private final ChargingStationController chargingStationController;
	
	public ListingPanel(ChargingStationController chargingStationController) {
		this.chargingStationController = chargingStationController;
	}
	
	public void init() {
		setLayout(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPanel.setBounds(0 ,0,
				1000, 300);
		this.add(scrollPanel);
		
		deleteButton.setBounds(10, 300, 100, 30);
		deleteButton.addActionListener((ActionEvent e)->{
			String id = (String) table.getValueAt(table.getSelectedRow(), 0);
			chargingStationController.delete(Long.parseLong(id,10));
		});
		this.add(deleteButton);
		update();
	}
	
	public void update() {
		tableModel.setRowCount(0);
		List<ChargingStation> chargingStations = chargingStationController.listStations();
		chargingStations.forEach(chargingStation -> tableModel.addRow(chargingStation.getDataArray()));
	}
	

}
