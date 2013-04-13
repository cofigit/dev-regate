import java.util.ArrayList;

public class Field {
	private ArrayList<Buoy> buoyList;
	private final static int WIDTH=100;
	private final static int HEIGHT=100;
	private final static int NBBUOY=10;
	private Line start,finish;

	
	
	public Field() {
		defineCourse();
	}
	
	public ArrayList<Buoy> getBuoyList() {
		return buoyList;
	}
		
	//Procedure definition parcours
	
	public void defineCourse() {
		//Placer aleateorement X bouée
		int buoyPosX;
		int buoyPosY;
		Buoy buoy;
		this.start = new Line(0,0,0,HEIGHT);
		this.finish = new Line(WIDTH,0,WIDTH,HEIGHT);

		for (int i=0; i<=NBBUOY; i++) {
			buoyPosX=0+(int)(Math.random()*((WIDTH - 0) +1 ));
			buoyPosY=0+(int)(Math.random()*((HEIGHT - 0) +1 ));
			buoy=new Buoy(buoyPosX, buoyPosY);
			this.buoyList.add(buoy);
		}
	}


}
