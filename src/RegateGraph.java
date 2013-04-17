import java.awt.*;
import java.util.Iterator;

import javax.swing.*;


public class RegateGraph extends JPanel {
	private Game game;
	private Field field;
	
	public RegateGraph(Game game){
		this.game = game;
		this.field = game.field;
		int parentWidth = super.getSize().width;
		int parentHeight = super.getSize().height;
		System.out.println("1st try : " + parentWidth + " " + parentHeight);
		// TODO Fix issue : can't get parent's container's size
		setPreferredSize(new Dimension(600,450));
        setBackground(new java.awt.Color(100,100,255));
		
	}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		Dimension d = super.getSize();
		int xPixel = d.width / field.getWidth();
		int yPixel = d.height / field.getHeight();
		
		// Place start line and finish line

		g.drawLine(game.field.getStart().getStartX() * d.width / field.getWidth(),
					game.field.getStart().getStartY() * d.height / field.getHeight(),
					game.field.getStart().getEndX() * d.width / field.getWidth(),
					game.field.getStart().getEndY() * d.height / field.getHeight());
		
		g.drawLine(game.field.getFinish().getStartX() * d.width / field.getWidth()-1,
					game.field.getFinish().getStartY() * d.height / field.getHeight(),
					game.field.getFinish().getEndX() * d.width / field.getWidth()-1,
					game.field.getFinish().getEndY() * d.height / field.getHeight());

		// Place buoys
		Iterator<Buoy> it = game.field.getBuoyList().iterator();
		while ( it.hasNext() ){
			Buoy currentBuoy = it.next();
			g.drawString("#", currentBuoy.getPosX() * d.width / field.getWidth()-1,
						currentBuoy.getPosX() * d.height / field.getHeight()-1);
		}
		
		// Draw one boat
    }
}


