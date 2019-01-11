package main.java.domain;

public class Line extends Shape{

	public Line(int[] inputArray) {
		super(inputArray);
	}

	@Override
	public void init() {
		if (getStartX() == getEndX()) {
			//vertical
			if (getStartY() < getEndY()) {
				for (int y = getStartY(); y<=getEndY(); y++) {
					Point p = new Point(getStartX(), y);
					super.appendStroke(p);
				}
			} else {
				for (int y = getStartY(); y>=getEndY(); y--) {
					Point p = new Point(getStartX(), y);
					super.appendStroke(p);
				}
			}
		}
		
		if (getStartY() == getEndY()) {
			//horizontal
			if (getStartX() < getEndX()) {
				for (int x = getStartX(); x<=getEndX(); x++) {
					Point p = new Point(x, getStartY());
					super.appendStroke(p);
				}
			} else {
				for (int x = getStartX(); x>=getEndX(); x--) {
					Point p = new Point(x, getStartY());
					super.appendStroke(p);
				}
			}
		}
	}

}
