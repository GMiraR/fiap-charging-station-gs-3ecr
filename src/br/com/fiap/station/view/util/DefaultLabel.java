package br.com.fiap.station.view.util;

import java.awt.Color;
import java.awt.Font;
import java.io.Serial;

import javax.swing.JLabel;


public class DefaultLabel extends JLabel {

	@Serial
	private static final long serialVersionUID = 1L;

	public DefaultLabel(String text) {
		this.setText(text);
		init();
	}
	
	private void init() {
		this.setForeground(new Color(80,80,80));
		this.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
