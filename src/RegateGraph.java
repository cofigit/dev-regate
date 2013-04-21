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
		// TODO Fix issue : can't get parent's container's size
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
		while ( itBuoy.hasNext() ){
			Buoy currentBuoy = itBuoy.next();
			g.drawString("#", currentBuoy.getPosX() * d.width / field.getWidth()-1,
						currentBuoy.getPosY() * d.height / field.getHeight()-1);
		}
		
		// Draw boats
		Iterator<IObserver> itBoat = game.getObservers().iterator();
		while ( itBoat.hasNext() ){
			Boat currentBoat = (Boat) itBoat.next();
	    	g.drawString("V",
	    			currentBoat.getPosX() * d.width / field.getWidth()-1 +10,
	    			currentBoat.getPosY() * d.height / field.getHeight()-1+10);
		}
    	repaint();
    }
}


