import java.awt.*;
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
		setPreferredSize(new Dimension(600,400));
		
	}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

		Dimension d = super.getSize();
		int xPixel = d.width / field.getWidth();
		int yPixel = d.height / field.getHeight();
		
		// Place start line and finish line
		g.drawLine(game.field.getStart().getStartX() * xPixel,
					game.field.getStart().getStartY() * yPixel,
					game.field.getStart().getEndX() * xPixel,
					game.field.getStart().getEndY() * yPixel);
		g.drawLine(game.field.getFinish().getStartX() * xPixel,
				game.field.getFinish().getStartY() * yPixel,
				game.field.getFinish().getEndX() * xPixel,
				game.field.getFinish().getEndY() * yPixel);
        
        g.drawString("blh", 20, 20);
        g.drawRect(200, 200, 200, 200);
    }
	/*
	public void paint(Graphics g){
		Dimension d = super.getSize();
		int xPixel = d.width / field.getWidth();
		int yPixel = d.height / field.getHeight();
		
		// Place start line and finish line
		g.drawLine(game.field.getStart().getStartX() * xPixel,
					game.field.getStart().getStartY() * yPixel,
					game.field.getStart().getEndX() * xPixel,
					game.field.getStart().getEndY() * yPixel);
		g.drawLine(game.field.getFinish().getStartX() * xPixel,
				game.field.getFinish().getStartY() * yPixel,
				game.field.getFinish().getEndX() * xPixel,
				game.field.getFinish().getEndY() * yPixel);
		
		// Place buoys
		// Draw one boat
		
	}
	*/
}


