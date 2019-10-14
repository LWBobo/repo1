
public class Square extends Rectangle {

	/** ±ß³¤*/
	private double side;
	

	public Square(double length, double width, double side) {
		super(length, width);
		this.side = side;
	}
	public Square(double side) {
		this.side = side;
	}
	public Square(double length, double width) {
		super(length, width);
	}

	@Override
	public double getArea() {
	
		if(this.side != 0) {
			return this.side * this.side;
		}
		return super.getArea();
	}
	

}
