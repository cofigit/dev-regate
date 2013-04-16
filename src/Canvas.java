import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;


public class Canvas extends JFrame {
	
	public Canvas(Game game) {
		initUI(game);
	}
	
	public void initUI(Game game){
	    JFrame frame = new JFrame();
		setTitle("Régate virtuelle");
		//TODO use field information?
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		//getContentPane().add(mainPanel);
		frame.add(mainPanel);
		
		ImageIcon exitIcon = new ImageIcon(getClass().getResource("icons/Close.png"));
		JMenuBar menubar = new JMenuBar();
		JMenu fichier = new JMenu("Fichier");
		fichier.setMnemonic(KeyEvent.VK_F);
		JMenu settings = new JMenu("Configuration");
		settings.setMnemonic(KeyEvent.VK_C);
		
		// Démarrer nouvelle partie
		
		// Ajouter joueur
		JMenuItem addPlayerItem = new JMenuItem ("Ajouter joueur...");
		addPlayerItem.setMnemonic(KeyEvent.VK_A);
		addPlayerItem.setToolTipText("Ajouter un joueur.");
		addPlayerItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//game.subscribePlayer();
			}
		});
		
		// Quitter
		JMenuItem exitMenuItem = new JMenuItem("Quitter", exitIcon);
		exitMenuItem.setMnemonic(KeyEvent.VK_Q);
		exitMenuItem.setToolTipText("Quitter le jeu.");
		exitMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// Settings
		JMenuItem fieldSizeItem = new JMenuItem("Taille de la régate.");
		JMenuItem generateRandomlyItem = new JMenuItem("Placer les bouées.");
		settings.add(fieldSizeItem);
		settings.add(generateRandomlyItem);
		
		fichier.add(addPlayerItem);
		fichier.add(exitMenuItem);
		menubar.add(fichier);
		menubar.add(settings);
		frame.add(menubar);
	}
}
