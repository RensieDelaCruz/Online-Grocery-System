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

public class FruitPanel extends JPanel {

	JLabel banana, cherry, grapes, orange, strawberry, apple, mango;
	JLabel bananaPrice, cherryPrice, grapesPrice, orangePrice, strawberryPrice, applePrice, mangoPrice;
	JPanel bananaPanel, cherryPanel, grapesPanel, orangePanel, strawberryPanel, applePanel, mangoPanel;
	JButton bananaBttn, cherryBttn, grapesBttn, orangeBttn, strawberryBttn, appleBttn, mangoBttn;

	public FruitPanel() {
		// Mango Button
		mangoBttn = new JButton("Add to Cart");
		mangoBttn.setVisible(true);
		mangoBttn.setFocusable(false);
		mangoBttn.setForeground(new Color(210, 105, 30));
		mangoBttn.setBackground(Color.white);

		// Mango Icon, Label and Price
		ImageIcon mangoIcon = new ImageIcon(getClass().getResource("/images/Mango.jpg"));
		mangoIcon.setImage(mangoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		mango = new JLabel("Mango");
		mango.setIcon(mangoIcon);
		mango.setHorizontalTextPosition(JLabel.CENTER);
		mango.setVerticalTextPosition(JLabel.BOTTOM);
		mango.setFont(new Font("Arial Black", Font.BOLD, 15));
		mangoPrice = new JLabel("$2.49/ea");

		// Mango Panel
		mangoPanel = new JPanel();
		mangoPanel.setVisible(true);
		mangoPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		mangoPanel.setPreferredSize(new Dimension(200, 200));
		mangoPanel.add(mango);
		mangoPanel.add(mangoPrice);
		mangoPanel.add(mangoBttn);
		mangoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Apple Button
		appleBttn = new JButton("Add to Cart");
		appleBttn.setVisible(true);
		appleBttn.setFocusable(false);
		appleBttn.setForeground(new Color(210, 105, 30));
		appleBttn.setBackground(Color.white);

		// Apple Icon, Label and Price
		ImageIcon appleIcon = new ImageIcon(getClass().getResource("/images/Apple.jpg"));
		appleIcon.setImage(appleIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		apple = new JLabel("Apple");
		apple.setIcon(appleIcon);
		apple.setHorizontalTextPosition(JLabel.CENTER);
		apple.setVerticalTextPosition(JLabel.BOTTOM);
		apple.setFont(new Font("Arial Black", Font.BOLD, 15));
		applePrice = new JLabel("$0.84/ea");

		// Apple Panel
		applePanel = new JPanel();
		applePanel.setVisible(true);
		applePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		applePanel.setPreferredSize(new Dimension(200, 200));
		applePanel.add(apple);
		applePanel.add(applePrice);
		applePanel.add(appleBttn);
		applePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Strawberry Button
		strawberryBttn = new JButton("Add to Cart");
		strawberryBttn.setVisible(true);
		strawberryBttn.setFocusable(false);
		strawberryBttn.setForeground(new Color(210, 105, 30));
		strawberryBttn.setBackground(Color.white);

		// Strawberry Icon, Label and Price
		ImageIcon strawberryIcon = new ImageIcon(getClass().getResource("/images/Strawberry.jpg"));
		strawberryIcon.setImage(strawberryIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		strawberry = new JLabel("Strawberry");
		strawberry.setIcon(strawberryIcon);
		strawberry.setHorizontalTextPosition(JLabel.CENTER);
		strawberry.setVerticalTextPosition(JLabel.BOTTOM);
		strawberry.setFont(new Font("Arial Black", Font.BOLD, 15));
		strawberryPrice = new JLabel("$4.99/lb");

		// Strawberry Panel
		strawberryPanel = new JPanel();
		strawberryPanel.setVisible(true);
		strawberryPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		strawberryPanel.setPreferredSize(new Dimension(200, 200));
		strawberryPanel.add(strawberry);
		strawberryPanel.add(strawberryPrice);
		strawberryPanel.add(strawberryBttn);
		strawberryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Orange Button
		orangeBttn = new JButton("Add to Cart");
		orangeBttn.setVisible(true);
		orangeBttn.setFocusable(false);
		orangeBttn.setForeground(new Color(210, 105, 30));
		orangeBttn.setBackground(Color.white);

		// Orange Icon, Label and Price
		ImageIcon orangeIcon = new ImageIcon(getClass().getResource("/images/Orange.jpg"));
		orangeIcon.setImage(orangeIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		orange = new JLabel("Orange");
		orange.setIcon(orangeIcon);
		orange.setHorizontalTextPosition(JLabel.CENTER);
		orange.setVerticalTextPosition(JLabel.BOTTOM);
		orange.setFont(new Font("Arial Black", Font.BOLD, 15));
		orangePrice = new JLabel("$7.99/bag");

		// Orange Panel
		orangePanel = new JPanel();
		orangePanel.setVisible(true);
		orangePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		orangePanel.setPreferredSize(new Dimension(200, 200));
		orangePanel.add(orange);
		orangePanel.add(orangePrice);
		orangePanel.add(orangeBttn);
		orangePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Grapes Button
		grapesBttn = new JButton("Add to Cart");
		grapesBttn.setVisible(true);
		grapesBttn.setFocusable(false);
		grapesBttn.setForeground(new Color(210, 105, 30));
		grapesBttn.setBackground(Color.white);

		// Grapes Icon, Label and Price
		ImageIcon grapesIcon = new ImageIcon(getClass().getResource("/images/Grapes.jpg"));
		grapesIcon.setImage(grapesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		grapes = new JLabel("Grapes");
		grapes.setIcon(grapesIcon);
		grapes.setHorizontalTextPosition(JLabel.CENTER);
		grapes.setVerticalTextPosition(JLabel.BOTTOM);
		grapes.setFont(new Font("Arial Black", Font.BOLD, 15));
		grapesPrice = new JLabel("$9.90/1kg");

		// Grapes Panel
		grapesPanel = new JPanel();
		grapesPanel.setVisible(true);
		grapesPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		grapesPanel.setPreferredSize(new Dimension(200, 200));
		grapesPanel.add(grapes);
		grapesPanel.add(grapesPrice);
		grapesPanel.add(grapesBttn);
		grapesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Cherry Button
		cherryBttn = new JButton("Add to Cart");
		cherryBttn.setVisible(true);
		cherryBttn.setFocusable(false);
		cherryBttn.setForeground(new Color(210, 105, 30));
		cherryBttn.setBackground(Color.white);

		// Cherry Icon, Label and Price
		ImageIcon cherryIcon = new ImageIcon(getClass().getResource("/images/Cherry.jpg"));
		cherryIcon.setImage(cherryIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		cherry = new JLabel("Cherry");
		cherry.setIcon(cherryIcon);
		cherry.setHorizontalTextPosition(JLabel.CENTER);
		cherry.setVerticalTextPosition(JLabel.BOTTOM);
		cherry.setFont(new Font("Arial Black", Font.BOLD, 15));
		cherryPrice = new JLabel("$9.99/lb");

		// Cherry Panel
		cherryPanel = new JPanel();
		cherryPanel.setVisible(true);
		cherryPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		cherryPanel.setPreferredSize(new Dimension(200, 200));
		cherryPanel.add(cherry);
		cherryPanel.add(cherryPrice);
		cherryPanel.add(cherryBttn);
		cherryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Banana Button
		bananaBttn = new JButton("Add to Cart");
		bananaBttn.setVisible(true);
		bananaBttn.setFocusable(false);
		bananaBttn.setForeground(new Color(210, 105, 30));
		bananaBttn.setBackground(Color.white);

		// Banana Icon, Label and Price
		ImageIcon bananaIcon = new ImageIcon(getClass().getResource("/images/Banana.jpg"));
		bananaIcon.setImage(bananaIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		banana = new JLabel("Banana");
		banana.setIcon(bananaIcon);
		banana.setHorizontalTextPosition(JLabel.CENTER);
		banana.setVerticalTextPosition(JLabel.BOTTOM);
		banana.setFont(new Font("Arial Black", Font.BOLD, 15));
		bananaPrice = new JLabel("$0.34/ea");

		// Banana Panel
		bananaPanel = new JPanel();
		bananaPanel.setVisible(true);
		bananaPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		bananaPanel.setPreferredSize(new Dimension(200, 200));
		bananaPanel.add(banana);
		bananaPanel.add(bananaPrice);
		bananaPanel.add(bananaBttn);
		bananaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Fruit Panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 1200));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));

		this.add(bananaPanel);
		this.add(cherryPanel);
		this.add(grapesPanel);
		this.add(orangePanel);
		this.add(strawberryPanel);
		this.add(applePanel);
		this.add(mangoPanel);
	}

}
