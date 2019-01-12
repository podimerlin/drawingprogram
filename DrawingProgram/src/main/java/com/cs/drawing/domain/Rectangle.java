package main.java.com.cs.drawing.domain;

public class Rectangle extends Shape implements IShape{
	
	public Rectangle(int[] rectArray) {
		super(rectArray);
	}

	@Override
	public void init() {
		//drawing horizontals
		if (getStartX() < getEndX()) {
			for (int x = getStartX(); x<=getEndX(); x++) {
				appendStroke(x, getStartY());
				appendStroke(x, getEndY());
			}
		} else {
			for (int x = getStartX(); x>=getEndX(); x--) {
				appendStroke(x, getStartY());
				appendStroke(x, getEndY());
			}
		}
		
		//drawing verticals
		if (getStartY() < getEndY()) {
			for (int y = getStartY(); y<=getEndY(); y++) {
				appendStroke(getStartX(), y);
				appendStroke(getEndX(), y);
			}
		} else {
			for (int y = getStartY(); y>=getEndY(); y--) {
				appendStroke(getStartX(), y);
				appendStroke(getEndX(), y);
			}
		}
		
	}

}
