import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

import javax.swing.*;


public class Canvas extends JFrame {
	private Game game;
	private Field field;
	private JPanel regateGraph;
	private JTextField newCap = new JTextField(3);
	private Boat currentBoat;
	private JComboBox boatComboBox;
	private JLabel infoCurrentSpeed = new JLabel("0 knots");
	private JLabel infoCurrentCap = new JLabel("0 deg");
	private JMenuItem startGameItem = new JMenuItem ("Démarrer partie!");
	private JMenuItem addPlayerItem = new JMenuItem ("Ajouter joueur...");
	private JButton submitButton = new JButton("Valider");
	private JTextField HUD = new JTextField();
	
	public Canvas(Game pGame){
		this.game = pGame;
		this.field = pGame.getField();
		boatComboBox = new JComboBox();
		boatComboBox.addActionListener(getSelectedBoat());
		boatComboBox.setForeground(Color.blue);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel main = new JPanel(new BorderLayout());
		Box userInput = Box.createVerticalBox();
		userInput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		JPanel fieldPanel = new JPanel();
		fieldPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		fieldPanel.setBackground(new java.awt.Color(255,255,255));

		/*
		 * HUD
		 * ***
		 */
		HUD.setText("Wind direction : " + game.getWind().getDirection() +
					" Wind speed : " + game.getWind().getSpeed());
		HUD.setEditable(false);
		
		/*
		 * USER INPUT FORM
		 */
		userInput.add(boatComboBox);
		JPanel infoSpeed = new JPanel(new BorderLayout());
		infoSpeed.add(new JLabel("Vitesse : "),BorderLayout.CENTER);
		infoSpeed.add(infoCurrentSpeed,BorderLayout.EAST);
		userInput.add(infoSpeed);
		
		JPanel infoCap = new JPanel(new BorderLayout());
		infoCap.add(new JLabel("Cap actuel : "),BorderLayout.CENTER);
		infoCap.add(infoCurrentCap,BorderLayout.EAST);
		userInput.add(infoCap);
		
		JPanel setCap = new JPanel(new BorderLayout());
		setCap.add(new JLabel("Nouveau cap : "),BorderLayout.CENTER);
		setCap.add(newCap,BorderLayout.EAST);
		setCap.add(submitButton,BorderLayout.SOUTH);
		submitButton.setEnabled(false);
		submitButton.addActionListener(submitActionListener());
		userInput.add(setCap);
		
		/*
		 *  MENU
		 *  ****
		 */
		ImageIcon exitIcon = new ImageIcon(getClass().getResource("icons/Close.png"));
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("Fichier");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu settingsMenu = new JMenu("Configuration");
		settingsMenu.setMnemonic(KeyEvent.VK_C);
		
		// Démarrer nouvelle partie
		startGameItem.setMnemonic(KeyEvent.VK_D);
		startGameItem.addActionListener(startNewGame());
		
		// Ajouter joueur
		addPlayerItem.setEnabled(true);
		addPlayerItem.setMnemonic(KeyEvent.VK_A);
		addPlayerItem.addActionListener(subscribePlayer());
		
		// Quitter
		JMenuItem exitMenuItem = new JMenuItem("Quitter", exitIcon);
		exitMenuItem.setMnemonic(KeyEvent.VK_Q);
		exitMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// Settings
		JMenuItem fieldSizeItem = new JMenuItem("Taille de la régate.");
		JMenuItem generateRandomlyItem = new JMenuItem("Placer les bouées.");
		settingsMenu.add(fieldSizeItem);
		settingsMenu.add(generateRandomlyItem);
		fileMenu.add(startGameItem);
		fileMenu.add(addPlayerItem);
		fileMenu.add(exitMenuItem);
		menubar.add(fileMenu);
		menubar.add(settingsMenu);
		
		// TODO remove when publishing
		/* Debug */
		JMenu debugMenu = new JMenu("Debug");
		JMenuItem dumpBookItem = new JMenuItem("Dump phone book");
		dumpBookItem.addActionListener(dumpPhoneBook());
		JMenuItem dumpCurrentBoatItem = new JMenuItem("Dump current boat");
		dumpCurrentBoatItem.addActionListener(dumpCurrentBoatItem());
		debugMenu.add(dumpCurrentBoatItem);
		debugMenu.add(dumpBookItem);
		menubar.add(debugMenu);
		
		// Pack GUI
		main.add(HUD, BorderLayout.NORTH);
		main.add(fieldPanel, BorderLayout.CENTER);
		main.add(userInput, BorderLayout.EAST);
		panel.add(menubar, BorderLayout.NORTH);
		panel.add(main, BorderLayout.CENTER);
		
		regateGraph = new RegateGraph(game);
		fieldPanel.add(regateGraph);
		
		add(panel);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Regate virtuelle de la mort !!!");
		setSize(850,600);
		setVisible(true);
		setResizable(false);
	}
	
	private ActionListener getSelectedBoat() {
		ActionListener getSelectedBoat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentBoat = (Boat) boatComboBox.getSelectedItem();
				//int speed = currentBoat.getSpeed();
				infoCurrentSpeed.setText("x" + " knots");
				infoCurrentCap.setText("y" +" deg");
			}
		};
		return getSelectedBoat;
	}

	private void loadComboBox() {
		boatComboBox.removeAllItems();
		Iterator<IObserver> it = game.getObservers().iterator();
		while ( it.hasNext()){
			boatComboBox.addItem(it.next());
		}
	}

	private ActionListener submitActionListener() {
		ActionListener submitActionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Fetch new cap
				String newCapString = newCap.getText();
				// Update boat
				currentBoat.setCap(Integer.parseInt(newCapString));
				currentBoat.setReady();
			}		
		};
		return submitActionListener;
	}

	// TODO Fix issue : can't click during game
	private ActionListener startNewGame() {
		ActionListener startNewGame = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Refactor by creating private method changeGameState()
				submitButton.setEnabled(true);
				addPlayerItem.setEnabled(false);
				startGameItem.setEnabled(false);
				game.setGameStarted();
				game.notifyObserver();
			}
		};
		return startNewGame;
	}

	private ActionListener subscribePlayer(){
		ActionListener subscribePlayer = new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String boatName = JOptionPane.showInputDialog(null, "Saisir le nom du bateau : ", "Inscription du bateau", 1);
				if(boatName != null) {
					new Boat(game, field, boatName);
					loadComboBox();
					JOptionPane.showMessageDialog(null, "Le bateau " + boatName + " a été inscrit.", "Inscription du bateau", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Inscription annulée.", "Annulation", 1);
				}
			}
		};
		return subscribePlayer;
	}

	private ActionListener dumpCurrentBoatItem() {
		ActionListener dumpCurrentBoatItem = new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println(currentBoat + " has speed of " + currentBoat.getSpeed() + ", cap of " + currentBoat.getCap() +
						", posX : " + currentBoat.getPosX() + ", posY : " + currentBoat.getPosY() + ".");
			}
		};
		return dumpCurrentBoatItem;
	}

	private ActionListener dumpPhoneBook(){
		ActionListener dumpPhoneBook = new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				game.dumpAnnuaire();
			}
		};
		return dumpPhoneBook;
	}

	public void drawBoat() {
		regateGraph.repaint();
	}
}
