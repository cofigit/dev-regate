import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class Canvas extends JFrame {
	
	public Canvas(Game game){
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel main = new JPanel(new BorderLayout());
		Box userInput = Box.createVerticalBox();
		
		/*
		 * HUD
		 * ***
		 */
		JTextField HUD = new JTextField();
		HUD.setText("This is the HUD. You'll get all sorts of useful information here!");
		HUD.setEditable(false);
		
		/*
		 * USER INPUT FORM
		 */
		
		JPanel infoSpeed = new JPanel(new BorderLayout());
		infoSpeed.add(new JLabel("Vitesse : "),BorderLayout.CENTER);
		JLabel infoCurrentSpeed = new JLabel("xy knots");
		infoSpeed.add(infoCurrentSpeed,BorderLayout.EAST);
		userInput.add(infoSpeed);
		
		JPanel infoCap = new JPanel(new BorderLayout());
		infoCap.add(new JLabel("Cap actuel : "),BorderLayout.CENTER);
		JLabel infoCurrentCap = new JLabel("xy deg");
		infoCap.add(infoCurrentCap,BorderLayout.EAST);
		userInput.add(infoCap);
		
		JPanel setCap = new JPanel(new BorderLayout());
		setCap.add(new JLabel("Nouveau cap : "),BorderLayout.CENTER);
		setCap.add(new JTextField(3),BorderLayout.EAST);
		setCap.add(new JButton("Valider"),BorderLayout.SOUTH);
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
		JMenuItem startGameItem = new JMenuItem ("Démarrer partie!");
		startGameItem.setMnemonic(KeyEvent.VK_D);
		startGameItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//game.startGame();
			}
		});
		
		// Ajouter joueur
		JMenuItem addPlayerItem = new JMenuItem ("Ajouter joueur...");
		addPlayerItem.setMnemonic(KeyEvent.VK_A);
		addPlayerItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//game.subscribePlayer();
			}
		});
		
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
		
		
		// Pack GUI
		main.add(HUD, BorderLayout.NORTH);
		//main.add(fieldPanel, BorderLayout.CENTER);
		main.add(userInput, BorderLayout.EAST);
		panel.add(menubar, BorderLayout.NORTH);
		panel.add(main, BorderLayout.CENTER);
		
		add(panel);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Reygate de la mort!");
		setSize(800,600);
		setVisible(true);
	}

}
