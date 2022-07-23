package com.grocerysystem.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VegetablePanel extends JPanel {
	
	JLabel romaineHearts, broccoli, lettuce, pepper, asparagus, onion, ginger;
	JLabel romaineHeartsPrice, broccoliPrice, lettucePrice, pepperPrice, asparagusPrice, onionPrice, gingerPrice;
	JPanel romaineHeartsPanel, broccoliPanel, lettucePanel, pepperPanel, asparagusPanel, onionPanel, gingerPanel;
	JButton romaineHeartsBttn, broccoliBttn, lettuceBttn, pepperBttn, asparagusBttn, onionBttn, gingerBttn;


	public VegetablePanel() {
		// Ginger Button
		gingerBttn = new JButton("Add to Cart");
		gingerBttn.setVisible(true);
		gingerBttn.setFocusable(false);
		gingerBttn.setForeground(new Color(210, 105, 30));
		gingerBttn.setBackground(Color.white);

		// Ginger Icon, Label and Price
		ImageIcon gingerIcon = new ImageIcon(getClass().getResource("/images/Ginger.jpg"));
		gingerIcon.setImage(gingerIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ginger = new JLabel("Ginger");
		ginger.setIcon(gingerIcon);
		ginger.setHorizontalTextPosition(JLabel.CENTER);
		ginger.setVerticalTextPosition(JLabel.BOTTOM);
		ginger.setFont(new Font("Arial Black", Font.BOLD, 15));
		gingerPrice = new JLabel("$1.99/lb");

		// Ginger Panel
		gingerPanel = new JPanel();
		gingerPanel.setVisible(true);
		gingerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		gingerPanel.setPreferredSize(new Dimension(200, 200));
		gingerPanel.add(ginger);
		gingerPanel.add(gingerPrice);
		gingerPanel.add(gingerBttn);
		gingerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Onion Button
		onionBttn = new JButton("Add to Cart");
		onionBttn.setVisible(true);
		onionBttn.setFocusable(false);
		onionBttn.setForeground(new Color(210, 105, 30));
		onionBttn.setBackground(Color.white);

		// Onion Icon, Label and Price
		ImageIcon onionIcon = new ImageIcon(getClass().getResource("/images/Onion.jpg"));
		onionIcon.setImage(onionIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		onion = new JLabel("Onion");
		onion.setIcon(onionIcon);
		onion.setHorizontalTextPosition(JLabel.CENTER);
		onion.setVerticalTextPosition(JLabel.BOTTOM);
		onion.setFont(new Font("Arial Black", Font.BOLD, 15));
		onionPrice = new JLabel("$1.00/lb");

		// Onion Panel
		onionPanel = new JPanel();
		onionPanel.setVisible(true);
		onionPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		onionPanel.setPreferredSize(new Dimension(200, 200));
		onionPanel.add(onion);
		onionPanel.add(onionPrice);
		onionPanel.add(onionBttn);
		onionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Asparagus Button
		asparagusBttn = new JButton("Add to Cart");
		asparagusBttn.setVisible(true);
		asparagusBttn.setFocusable(false);
		asparagusBttn.setForeground(new Color(210, 105, 30));
		asparagusBttn.setBackground(Color.white);

		// Asparagus Icon, Label and Price
		ImageIcon asparagusIcon = new ImageIcon(getClass().getResource("/images/Asparagus.jpg"));
		asparagusIcon.setImage(asparagusIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		asparagus = new JLabel("Asparagus");
		asparagus.setIcon(asparagusIcon);
		asparagus.setHorizontalTextPosition(JLabel.CENTER);
		asparagus.setVerticalTextPosition(JLabel.BOTTOM);
		asparagus.setFont(new Font("Arial Black", Font.BOLD, 15));
		asparagusPrice = new JLabel("$5.12/465g");

		// Asparagus Panel
		asparagusPanel = new JPanel();
		asparagusPanel.setVisible(true);
		asparagusPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		asparagusPanel.setPreferredSize(new Dimension(200, 200));
		asparagusPanel.add(asparagus);
		asparagusPanel.add(asparagusPrice);
		asparagusPanel.add(asparagusBttn);
		asparagusPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Pepper Button
		pepperBttn = new JButton("Add to Cart");
		pepperBttn.setVisible(true);
		pepperBttn.setFocusable(false);
		pepperBttn.setForeground(new Color(210, 105, 30));
		pepperBttn.setBackground(Color.white);

		// Pepper Icon, Label and Price
		ImageIcon pepperIcon = new ImageIcon(getClass().getResource("/images/Pepper.jpg"));
		pepperIcon.setImage(pepperIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		pepper = new JLabel("Pepper");
		pepper.setIcon(pepperIcon);
		pepper.setHorizontalTextPosition(JLabel.CENTER);
		pepper.setVerticalTextPosition(JLabel.BOTTOM);
		pepper.setFont(new Font("Arial Black", Font.BOLD, 15));
		pepperPrice = new JLabel("$1.49/ea");

		// Pepper Panel
		pepperPanel = new JPanel();
		pepperPanel.setVisible(true);
		pepperPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		pepperPanel.setPreferredSize(new Dimension(200, 200));
		pepperPanel.add(pepper);
		pepperPanel.add(pepperPrice);
		pepperPanel.add(pepperBttn);
		pepperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Lettuce Button
		lettuceBttn = new JButton("Add to Cart");
		lettuceBttn.setVisible(true);
		lettuceBttn.setFocusable(false);
		lettuceBttn.setForeground(new Color(210, 105, 30));
		lettuceBttn.setBackground(Color.white);

		// Lettuce Icon, Label and Price
		ImageIcon lettuceIcon = new ImageIcon(getClass().getResource("/images/Lettuce.jpg"));
		lettuceIcon.setImage(lettuceIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lettuce = new JLabel("Lettuce");
		lettuce.setIcon(lettuceIcon);
		lettuce.setHorizontalTextPosition(JLabel.CENTER);
		lettuce.setVerticalTextPosition(JLabel.BOTTOM);
		lettuce.setFont(new Font("Arial Black", Font.BOLD, 15));
		lettucePrice = new JLabel("$2.99/ea");

		// Lettuce Panel
		lettucePanel = new JPanel();
		lettucePanel.setVisible(true);
		lettucePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		lettucePanel.setPreferredSize(new Dimension(200, 200));
		lettucePanel.add(lettuce);
		lettucePanel.add(lettucePrice);
		lettucePanel.add(lettuceBttn);
		lettucePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Broccoli Button
		broccoliBttn = new JButton("Add to Cart");
		broccoliBttn.setVisible(true);
		broccoliBttn.setFocusable(false);
		broccoliBttn.setForeground(new Color(210, 105, 30));
		broccoliBttn.setBackground(Color.white);

		// Broccoli Icon, Label and Price
		ImageIcon broccoliIcon = new ImageIcon(getClass().getResource("/images/Broccoli.jpg"));
		broccoliIcon.setImage(broccoliIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		broccoli = new JLabel("Broccoli");
		broccoli.setIcon(broccoliIcon);
		broccoli.setHorizontalTextPosition(JLabel.CENTER);
		broccoli.setVerticalTextPosition(JLabel.BOTTOM);
		broccoli.setFont(new Font("Arial Black", Font.BOLD, 15));
		broccoliPrice = new JLabel("$1.85/ea");

		// Broccoli Panel
		broccoliPanel = new JPanel();
		broccoliPanel.setVisible(true);
		broccoliPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		broccoliPanel.setPreferredSize(new Dimension(200, 200));
		broccoliPanel.add(broccoli);
		broccoliPanel.add(broccoliPrice);
		broccoliPanel.add(broccoliBttn);
		broccoliPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Romaine Hearts Button
		romaineHeartsBttn = new JButton("Add to Cart");
		romaineHeartsBttn.setVisible(true);
		romaineHeartsBttn.setFocusable(false);
		romaineHeartsBttn.setForeground(new Color(210, 105, 30));
		romaineHeartsBttn.setBackground(Color.white);

		// Romaine Hearts Icon, Label and Price
		ImageIcon romaineHeartsIcon = new ImageIcon(getClass().getResource("/images/RomaineHearts.jpg"));
		romaineHeartsIcon.setImage(romaineHeartsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		romaineHearts = new JLabel("Romaine Hearts");
		romaineHearts.setIcon(romaineHeartsIcon);
		romaineHearts.setHorizontalTextPosition(JLabel.CENTER);
		romaineHearts.setVerticalTextPosition(JLabel.BOTTOM);
		romaineHearts.setFont(new Font("Arial Black", Font.BOLD, 15));
		romaineHeartsPrice = new JLabel("$3.99/bag");

		// Romaine Hearts Panel
		romaineHeartsPanel = new JPanel();
		romaineHeartsPanel.setVisible(true);
		romaineHeartsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		romaineHeartsPanel.setPreferredSize(new Dimension(200, 200));
		romaineHeartsPanel.add(romaineHearts);
		romaineHeartsPanel.add(romaineHeartsPrice);
		romaineHeartsPanel.add(romaineHeartsBttn);
		romaineHeartsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Vegetable Panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 1200));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));

		this.add(romaineHeartsPanel);
		this.add(broccoliPanel);
		this.add(lettucePanel);
		this.add(pepperPanel);
		this.add(asparagusPanel);
		this.add(onionPanel);
		this.add(gingerPanel);
	}
}
