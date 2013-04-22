
public class Wind {
	// We use constants at this stage.
	//
	// We may give this role to an administrator
	// or generate them randomly at each step.
	private final static double MAX_DIRECTION = 360.0;
	private final static double MAX_SPEED = Field.getWidth() / 2; // not bigger than the canvas!
	
	private double windDirection;
	private double windSpeed;
	private int iteration;
	
	
	//Contructeur par default
	public Wind(){
		iteration = 0;
		generateWind();
	}

	//Déclaration getters
	
	public double getDirection() {
		return windDirection;
	}
	
	public double getSpeed() {
		return windSpeed;
	}
	
	/* Generate wind REALLY randomly...
	public void generateWind() {
		if ( iteration == 0 ) { // 1st iteration
			this.windDirection = 0 + (double) (Math.random() * ((MAX_DIRECTION - 0) +1 ));
			this.windSpeed = 0 + (double) (Math.random() * ((MAX_SPEED - 0) +1 ));
		} else { // purpose limit random factor
			this.windDirection = (this.windDirection-50) + (double) (Math.random() * (((this.windDirection+50) - (this.windDirection-50)) +1 ));
			this.windSpeed = (this.windSpeed-50) + (double) (Math.random() * (((this.windSpeed+50) - (this.windSpeed-50)) +1 ));
		}
		iteration++;
	}
	*/
	
	// Generate wind statically...
	public void generateWind(){
		this.windDirection = 180;
		this.windSpeed = 50;
	}
	
}