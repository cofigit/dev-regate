import java.awt.*;
import java.util.Iterator;

import javax.swing.*;


public class RegateGraph extends JPanel {
	private Game game;
	private Field field;
	
	public RegateGraph(Game game){
		this.game = game;
		this.field = game.getField();
		int parentWidth = super.getSize().width;
		int parentHeight = super.getSize().height;
		setPreferredSize(new Dimension(640,515));
        setBackground(new java.awt.Color(200,200,255));
		
	}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		Dimension d = super.getSize();
		int xPixel = d.width / field.getWidth();
		int yPixel = d.height / field.getHeight();
		
		// Place start line and finish line
		g.setColor(Color.RED);
		g.drawLine(game.getField().getStart().getStartX() * d.width / field.getWidth(),
					game.getField().getStart().getStartY() * d.height / field.getHeight(),
					game.getField().getStart().getEndX() * d.width / field.getWidth(),
					game.getField().getStart().getEndY() * d.height / field.getHeight());
		
		g.drawLine(game.getField().getFinish().getStartX() * d.width / field.getWidth()-1,
					game.getField().getFinish().getStartY() * d.height / field.getHeight(),
					game.getField().getFinish().getEndX() * d.width / field.getWidth()-1,
					game.getField().getFinish().getEndY() * d.height / field.getHeight());

		// Place buoys
		Iterator<Buoy> itBuoy = game.getField().getBuoyList().iterator();

    	Graphics2D g2d = (Graphics2D) g;
		while ( itBuoy.hasNext() ){
			Buoy currentBuoy = itBuoy.next();
	    	ImageIcon buoySprite = new ImageIcon (getClass().getResource("icons/Move.png"),""+currentBuoy.getBuoyNumber());
	    	Image buoyImage = buoySprite.getImage();
	    	g2d.drawImage(buoyImage,
	    			currentBuoy.getPosX() * d.width / field.getWidth(),
					currentBuoy.getPosY() * d.height / field.getHeight(),
	    			this);
		}
		
		// Draw boats
		Iterator<IObserver> itBoat = game.getObservers().iterator();
		while ( itBoat.hasNext() ){
			Boat currentBoat = (Boat) itBoat.next();
	    	ImageIcon boatSprite = new ImageIcon (getClass().getResource("icons/Boat.png"),currentBoat.getName());
	    	Image boatImage = boatSprite.getImage();
	    	g2d.drawImage(boatImage,
	    			currentBoat.getPosX() * d.width / field.getWidth(),
	    			currentBoat.getPosY() * d.height / field.getHeight(),
	    			this);
	    	
		}
    	repaint();
    }
}


