package br.com.fiap.station.view.util;

import br.com.fiap.station.controller.ChargingStationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterEditPanel extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;

	private final JLabel image = new JLabel(new ImageIcon("src/images/tesla.jpeg"));
	
	private final DefaultLabel name = new DefaultLabel("Nome do Estabelecimento");
	private final DefaultTextField nameText = new DefaultTextField();
	
	private final DefaultLabel street = new DefaultLabel("Rua");
	private final DefaultTextField streetText = new DefaultTextField();

	private final DefaultLabel district = new DefaultLabel("Bairro");
	private final DefaultTextField districtText = new DefaultTextField();

	private final DefaultLabel city = new DefaultLabel("Cidade");
	private final DefaultTextField cityText = new DefaultTextField();

	private final DefaultLabel price = new DefaultLabel("Preço (kWh)");
	private final DefaultTextField priceText = new DefaultTextField();

	private final DefaultLabel state = new DefaultLabel("Estado");
	private final JComboBox<String> stateCheckBox
			= new JComboBox<>(new String[]{"AC", "AL", "AP","AM", "BA", "CE", "DF", "ES", "GO",
			"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC",
			"SP", "SE", "TO"});

	private final DefaultLabel plug = new DefaultLabel("Tipos de Plug");

	private final DefaultLabel rating = new DefaultLabel("Avaliação");
	
	private final JButton save = new JButton();
	private final JButton cancel = new JButton();
	
	private final ChargingStationController chargingStationController;
	
	public RegisterEditPanel(ChargingStationController chargingStationController) {
		setLayout(null);
		this.chargingStationController = chargingStationController;
	}
	
	public void init() {
	    
		image.setBounds(40, 35, 280, 250);
		resizeImage(image);
		this.add(image);

		name.setBounds(
				image.getX() + image.getWidth() + 50, 28, 200, 15);
		this.add(name);

		nameText.setBounds(
				name.getX(),
				name.getY()+ name.getHeight() +10,250,29);
		this.add(nameText);

		street.setBounds(
				nameText.getX(),
				nameText.getY()+ nameText.getHeight() +20, 100, 15);
		this.add(street);

		streetText.setBounds(
				street.getX(),
				street.getY()+ street.getHeight() +10, 250, 29);
		this.add(streetText);

		district.setBounds(
				streetText.getX(),
				streetText.getY()+ streetText.getHeight() + 15, 100, 15);
		this.add(district);

		districtText.setBounds(
				district.getX(),
				district.getY()+ district.getHeight() + 10, 250, 29);
		this.add(districtText);

		city.setBounds(
				districtText.getX(),
				districtText.getY()+ districtText.getHeight() + 15, 100, 15);
		this.add(city);

		cityText.setBounds(
				city.getX(),
				city.getY()+ city.getHeight() + 10, 250, 29);
		this.add(cityText);

		state.setBounds(
				districtText.getX(),
				districtText.getY() + districtText.getHeight()+85, 100, 15);
		this.add(state);

		stateCheckBox.setBounds(
				state.getX(),
				state.getY()+ state.getHeight()+10, 250, 29);

		stateCheckBox.setFont(new Font("Arial", Font.BOLD, 16));

		this.add(stateCheckBox);
		
		save.setBounds(
				stateCheckBox.getX(),
				stateCheckBox.getY()+ stateCheckBox.getHeight()+20, 100,38);
		save.setFont(new Font("Arial", Font.BOLD, 14));
		save.setText("Save");
		this.add(save);
		
		cancel.setBounds(
				save.getX()+ save.getWidth()+15,
				save.getY(), 140, 38);
		cancel.setFont(new Font("Arial", Font.BOLD, 14));
		cancel.setText("Cancel");
		this.add(cancel);

		plug.setBounds(
				nameText.getX() + nameText.getWidth() + 50,
				name.getY(),150, 15);
		this.add(plug);
		
        JRadioButton radio1 = new JRadioButton();
        radio1.setText("CCS2");
        radio1.setBounds(
        		plug.getX(),
        		plug.getY() + plug.getHeight() + 15, 150, 15);

        radio1.setFont(new Font("Arial", Font.BOLD, 15));

        JRadioButton radio2 = new JRadioButton();
        radio2.setText("CHAdeMO");
        radio2.setBounds(
        		radio1.getX(),
        		radio1.getY() + radio1.getHeight() + 10, 150, 15);

        radio2.setFont(new Font("Arial", Font.BOLD, 15));

        JRadioButton radio3 = new JRadioButton();
        radio3.setText("Tipo 1");
        radio3.setBounds(
        		radio2.getX(),
        		radio2.getY() + radio2.getHeight() + 10, 150, 15);

        radio3.setFont(new Font("Arial", Font.BOLD, 15));

		JRadioButton radio4 = new JRadioButton();
		radio4.setText("Tipo 2");
		radio4.setBounds(
				radio3.getX(),
				radio3.getY() + radio3.getHeight() + 10, 150, 15);

		radio4.setFont(new Font("Arial", Font.BOLD, 15));

        this.add(radio1);
        this.add(radio2);
        this.add(radio3);
		this.add(radio4);

        JCheckBox watched = new JCheckBox("Watched");
        watched.setBounds(
        		radio3.getX(),
        		radio3.getY() + radio3.getHeight() + 30, 150, 15);
        watched.setFont(new Font("Arial", Font.BOLD, 15));

        rating.setBounds(
        		watched.getX(),
        		watched.getY() + watched.getHeight() + 20, 150, 15);
        this.add(rating);
        
        StarRater starRatingField = new StarRater(5);
        starRatingField.setBounds(
        		rating.getX(),
        		rating.getY() + rating.getHeight() + 15, 150, 15);
        this.add(starRatingField);

		price.setBounds(
				rating.getX(),
				rating.getY()+ rating.getHeight() + 50, 100, 15);
		this.add(price);

		priceText.setBounds(
				price.getX(),
				price.getY()+ price.getHeight() + 10, 250, 29);
		this.add(priceText);

		save.addActionListener((ActionEvent e)->{
			boolean invalid = nameText.getText().equalsIgnoreCase("");
			invalid = invalid || streetText.getText().equalsIgnoreCase("");
			invalid = invalid || districtText.getText().equalsIgnoreCase("");
			invalid = invalid || cityText.getText().equalsIgnoreCase("");
			invalid = invalid || ((String) Objects.requireNonNull(stateCheckBox.getSelectedItem())).equalsIgnoreCase("");
			invalid = invalid || !( radio1.isSelected()
					|| radio2.isSelected()
					|| radio3.isSelected()
					|| radio4.isSelected());
			invalid = invalid || starRatingField.getSelection() == 0;
			invalid = invalid || priceText.getText().equalsIgnoreCase("");
			
			if(invalid) {
				JOptionPane.showMessageDialog(null, "Informe todos os campos!");
				return;
			}

			List<String> plugsList = new ArrayList<>();

			if(Objects.nonNull(radio1.isSelected() ? radio1.getText() : null)){
				plugsList.add(radio1.getText());
			}

			if(Objects.nonNull(radio2.isSelected() ? radio2.getText() : null)){
				plugsList.add(radio2.getText());
			}

			if(Objects.nonNull(radio3.isSelected() ? radio3.getText() : null)){
				plugsList.add(radio3.getText());
			}

			if(Objects.nonNull(radio4.isSelected() ? radio4.getText() : null)){
				plugsList.add(radio4.getText());
			}

			boolean commaIsFound = priceText.getText().contains(",");

			if(commaIsFound){
				priceText.setText(priceText.getText().replace(",", "."));
			}

			chargingStationController.save(
					nameText.getText(),
					streetText.getText().trim(),
					districtText.getText().trim(),
					cityText.getText().trim(),
					(String) stateCheckBox.getSelectedItem(),
					plugsList,
					starRatingField.getSelection(),
					Double.valueOf(priceText.getText())
					);	
		});
		cancel.addActionListener((ActionEvent e)->{
			nameText.setText("");
			streetText.setText("");
			districtText.setText("");
			stateCheckBox.setSelectedIndex(0);
			starRatingField.setSelection(0);
			watched.setSelected(false);
 		});
		setVisible(true);
	}
	
	public void resizeImage(JLabel imagem) {
		imagem.setBounds(imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight());
		ImageIcon myImage = (ImageIcon) imagem.getIcon();
        Image image = myImage.getImage();
        Image scaledImage = image.getScaledInstance(imagem.getWidth(), imagem.getHeight(),Image.SCALE_SMOOTH);
        imagem.setIcon( new ImageIcon(scaledImage) );
	}
}
