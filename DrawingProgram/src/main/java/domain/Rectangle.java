package main.java.domain;

public class Rectangle extends Shape{
	
	public Rectangle(int[] rectArray) {
		super(rectArray);
	}

	@Override
	public void init() {
		
		//drawing horizontals
		if (getStartX() < getEndX()) {
			for (int x = getStartX(); x<=getEndX(); x++) {
				Point p = new Point(x, getStartY());
				Point p2 = new Point(x, getEndY());
				super.appendStroke(p);
				super.appendStroke(p2);
			}
		} else {
			for (int x = getStartX(); x>=getEndX(); x--) {
				Point p = new Point(x, getStartY());
				Point p2 = new Point(x, getEndY());
				super.appendStroke(p);
				super.appendStroke(p2);
			}
		}
		
		//drawing verticals
		if (getStartY() < getEndY()) {
			for (int y = getStartY(); y<=getEndY(); y++) {
				Point p = new Point(getStartX(), y);
				Point p2 = new Point(getEndX(), y);
				super.appendStroke(p);
				super.appendStroke(p2);
			}
		} else {
			for (int y = getStartY(); y>=getEndY(); y--) {
				Point p = new Point(getStartX(), y);
				Point p2 = new Point(getEndX(), y);
				super.appendStroke(p);
				super.appendStroke(p2);
			}
		}
		
	}

}
