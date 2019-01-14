package main.java.com.cs.drawing.domain.impl;

/*
 * Should create a new rectangle, whose upper left corner is (x1,y1) and
 * lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
 * using the 'x' character. 
 */
public class Rectangle extends Shape{
	
	public Rectangle(int[] rectArray) {
		super(rectArray);
	}

	@Override
	public void renderStrokes() {
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
