package com.grocerysystem.forms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import com.grocerysystem.classes.Administrator;
import com.grocerysystem.classes.Customer;
import com.grocerysystem.classes.Product;
import com.grocerysystem.classes.ProductsInCart;
import com.grocerysystem.classes.User;

public class MainForm extends JFrame implements ActionListener {

	private JPanel departmentsPanel, headerPanel, centerPanel;
	private JLabel departmentsLabel;
	public static JLabel subTotalLabel;
	private JButton meatsBttn, seafoodBttn, fruitsBttn, veggiesBttn, dairyBttn, eggBttn, viewCartBttn,
			viewOrderHistoryBttn;
	private JScrollPane meatScrollPane, seafoodScrollPane, fruitScrollPane, veggiesScrollPane, dairyScrollPane,
			eggScrollPane;
	private CardLayout cards;
	private Cursor cursor;

	private MeatPanel meatPanel = new MeatPanel();
	private SeafoodPanel seafoodPanel = new SeafoodPanel();
	private FruitPanel fruitPanel = new FruitPanel();
	private VegetablePanel veggiesPanel = new VegetablePanel();
	private DairyPanel dairyPanel = new DairyPanel();
	private EggPanel eggPanel = new EggPanel();

	private ViewCartPanel viewCartPanel = new ViewCartPanel();
	private ViewOrderHistoryPanel viewOrderHistoryPanel = new ViewOrderHistoryPanel();

	private User user;
	protected JButton manageBttn;
	protected JLabel welcomeLabel;

	private static MainForm main;

	public MainForm(User user) {
		main = this;
		this.user = user;

		// cursor for buttons
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Egg ScrollPane
		eggScrollPane = new JScrollPane(eggPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Dairy ScrollPane
		dairyScrollPane = new JScrollPane(dairyPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Vegetable ScrollPane
		veggiesScrollPane = new JScrollPane(veggiesPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Fruit ScrollPane
		fruitScrollPane = new JScrollPane(fruitPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Seafood ScrollPane
		seafoodScrollPane = new JScrollPane(seafoodPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Meat ScrollPane
		meatScrollPane = new JScrollPane(meatPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Eggs Button
		eggBttn = new JButton("Eggs");
		eggBttn.setFocusable(false);
		eggBttn.setFont(new Font("Arial", Font.BOLD, 15));
		eggBttn.setForeground(new Color(210, 105, 30));
		eggBttn.setBackground(null);
		eggBttn.setCursor(cursor);
		eggBttn.setBorder(null);
		eggBttn.addActionListener(this);

		// Dairies Button
		dairyBttn = new JButton("Dairies");
		dairyBttn.setFocusable(false);
		dairyBttn.setFont(new Font("Arial", Font.BOLD, 15));
		dairyBttn.setForeground(new Color(210, 105, 30));
		dairyBttn.setBackground(null);
		dairyBttn.setCursor(cursor);
		dairyBttn.setBorder(null);
		dairyBttn.addActionListener(this);

		// Veggies Button
		veggiesBttn = new JButton("Vegetables");
		veggiesBttn.setFocusable(false);
		veggiesBttn.setFont(new Font("Arial", Font.BOLD, 15));
		veggiesBttn.setForeground(new Color(210, 105, 30));
		veggiesBttn.setBackground(null);
		veggiesBttn.setCursor(cursor);
		veggiesBttn.setBorder(null);
		veggiesBttn.addActionListener(this);

		// Fruits Button
		fruitsBttn = new JButton("Fruits");
		fruitsBttn.setFocusable(false);
		fruitsBttn.setFont(new Font("Arial", Font.BOLD, 15));
		fruitsBttn.setForeground(new Color(210, 105, 30));
		fruitsBttn.setBackground(null);
		fruitsBttn.setCursor(cursor);
		fruitsBttn.setBorder(null);
		fruitsBttn.addActionListener(this);

		// Seafood Button
		seafoodBttn = new JButton("Seafoods");
		seafoodBttn.setBounds(35, 105, 105, 20);
		seafoodBttn.setFocusable(false);
		seafoodBttn.setFont(new Font("Arial", Font.BOLD, 15));
		seafoodBttn.setForeground(new Color(210, 105, 30));
		seafoodBttn.setBackground(null);
		seafoodBttn.setCursor(cursor);
		seafoodBttn.setBorder(null);
		seafoodBttn.addActionListener(this);

		// Meats Button
		meatsBttn = new JButton("Meats");
		meatsBttn.setFocusable(false);
		meatsBttn.setFont(new Font("Arial", Font.BOLD, 15));
		meatsBttn.setForeground(new Color(210, 105, 30));
		meatsBttn.setBackground(null);
		meatsBttn.setCursor(cursor);
		meatsBttn.setBorder(null);
		meatsBttn.addActionListener(this);

		// Header Panel components
		manageBttn = new JButton("Manage");
		manageBttn.setBackground(Color.white);
		manageBttn.setForeground(new Color(210, 105, 30));
		manageBttn.setFocusable(false);
		manageBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		manageBttn.setBounds(470, 60, 70, 20);
		manageBttn.addActionListener(this);
		manageBttn.setVisible(false);

		viewOrderHistoryBttn = new JButton("Order History");
		viewOrderHistoryBttn.setBackground(Color.white);
		viewOrderHistoryBttn.setForeground(new Color(210, 105, 30));
		viewOrderHistoryBttn.setFocusable(false);
		viewOrderHistoryBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		viewOrderHistoryBttn.setBounds(550, 60, 110, 20);
		viewOrderHistoryBttn.addActionListener(this);

		viewCartBttn = new JButton("View Cart ");
		viewCartBttn.setBackground(Color.white);
		viewCartBttn.setForeground(new Color(210, 105, 30));
		viewCartBttn.setFocusable(false);
		viewCartBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		viewCartBttn.setBounds(670, 60, 80, 20);
		viewCartBttn.addActionListener(this);

		subTotalLabel = new JLabel("Subtotal: ");
		subTotalLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		subTotalLabel.setBounds(760, 60, 200, 20);

		welcomeLabel = new JLabel();
		if (this.user instanceof Customer)
			welcomeLabel.setText("Welcome " + ((Customer) user).getFirstName());
		else
			welcomeLabel.setText("Welcome " + ((Administrator) user).getFirstName());
		welcomeLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		welcomeLabel.setForeground(new Color(139, 69, 19));
		welcomeLabel.setBounds(20, 30, 700, 20);

		// Header Panel
		headerPanel = new JPanel();
		headerPanel.setPreferredSize(new Dimension(100, 100));
		headerPanel.setVisible(true);
		headerPanel.setBackground(Color.white);
		headerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		headerPanel.setLayout(null);
		headerPanel.add(viewOrderHistoryBttn);
		headerPanel.add(viewCartBttn);
		headerPanel.add(manageBttn);
		headerPanel.add(subTotalLabel);
		headerPanel.add(welcomeLabel);

		// Center Panel with cards Layout to change the view if the user click on
		// certain department
		centerPanel = new JPanel();
		cards = new CardLayout();
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(cards);
		centerPanel.add(meatScrollPane, "meat");
		centerPanel.add(seafoodScrollPane, "seafood");
		centerPanel.add(fruitScrollPane, "fruit");
		centerPanel.add(veggiesScrollPane, "vegetable");
		centerPanel.add(dairyScrollPane, "dairy");
		centerPanel.add(eggScrollPane, "egg");
		centerPanel.add(viewCartPanel, "cart");
		centerPanel.add(viewOrderHistoryPanel, "orderhistory");

		// Departments Label
		departmentsLabel = new JLabel("Departments");
		departmentsLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		departmentsLabel.setForeground(new Color(139, 69, 19));

		// Departments Panel
		departmentsPanel = new JPanel();
		departmentsPanel.setPreferredSize(new Dimension(200, 300));
		departmentsPanel.setVisible(true);
		departmentsPanel.setBackground(Color.white);
		departmentsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		departmentsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
		departmentsPanel.add(departmentsLabel);
		departmentsPanel.add(meatsBttn);
		departmentsPanel.add(seafoodBttn);
		departmentsPanel.add(fruitsBttn);
		departmentsPanel.add(veggiesBttn);
		departmentsPanel.add(dairyBttn);
		departmentsPanel.add(eggBttn);

		// Main Frame
		ImageIcon mainIcon = new ImageIcon(getClass().getResource("/images/Cart Icon.jpg"));
		this.setTitle("Organic Grocery Store");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(200, 100, 100));
		this.setLayout(new BorderLayout(30, 10));
		this.setVisible(true);

		this.add(departmentsPanel, BorderLayout.WEST);
		this.add(headerPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == meatsBttn) {
			cards.show(centerPanel, "meat");
			this.add(centerPanel);
		}

		if (e.getSource() == seafoodBttn) {
			cards.show(centerPanel, "seafood");
			this.add(centerPanel);
		}

		if (e.getSource() == fruitsBttn) {
			cards.show(centerPanel, "fruit");
			this.add(centerPanel);
		}

		if (e.getSource() == veggiesBttn) {
			cards.show(centerPanel, "vegetable");
			this.add(centerPanel);
		}

		if (e.getSource() == dairyBttn) {
			cards.show(centerPanel, "dairy");
			this.add(centerPanel);
		}

		if (e.getSource() == eggBttn) {
			cards.show(centerPanel, "egg");
			this.add(centerPanel);
		}

		if (e.getSource() == viewCartBttn) {
			cards.show(centerPanel, "cart");
			this.add(centerPanel);
		}

		if (e.getSource() == viewOrderHistoryBttn) {
			cards.show(centerPanel, "orderhistory");
			this.add(centerPanel);
		}

		if (e.getSource() == manageBttn) {
			new ManageInventoryForm();
		}
	}

	// getInstance() method that will return this instance of MainFrame and use it
	// as a reference in Checkout Form to hide it everytime the user open the check
	// out form.
	public static MainForm getInstance() {
		return main;
	}

}
