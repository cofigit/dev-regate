import java.util.ArrayList;

public class Field {
	private final static int WIDTH=600;
	private final static int HEIGHT=450;
	private final static int NBBUOY=10;
	
	private Line start, finish;

	private ArrayList<Buoy> buoyList = new ArrayList<Buoy>();

	public Field() {
		defineCourse();
	}
	
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
	
	public ArrayList<Buoy> getBuoyList() {
		return buoyList;
	}
	
	public Line getStart() {
		return start;
	}

	public Line getFinish() {
		return finish;
	}
		
	//Procedure definition parcours
	public void defineCourse() {
		//Placer aleatoirement X bou�e
		int buoyPosX;
		int buoyPosY;
		Buoy buoy;
		this.start = new Line(0,0,0,HEIGHT);
		this.finish = new Line(WIDTH,0,WIDTH,HEIGHT);

		// The buoys are placed randomly. There is still
		// no sense of order at this stage.
		// We will need to refactor the algorithm to add
		// an order.
		// We may do this by dividing the field or by 
		// using a hierarchy when placing the buoys (indexed
		// array). Other algorithms welcome...
		for (int i=0 ; i<NBBUOY ; i++) {
			buoyPosX = 0 + (int) (Math.random() * ((WIDTH - 0) +1 ));
			buoyPosY = 0 + (int) (Math.random() * ((HEIGHT - 0) +1 ));
			buoy = new Buoy(buoyPosX, buoyPosY);
			this.buoyList.add(buoy);
		}
	}


}
