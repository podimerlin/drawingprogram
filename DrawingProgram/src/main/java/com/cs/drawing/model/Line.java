package main.java.com.cs.drawing.model;

/*
 * Should create a new line from (x1,y1) to (x2,y2). Currently only
 * horizontal or vertical lines are supported. Horizontal and vertical lines
 * will be drawn using the 'x' character.
 */
public class Line extends Shape{

	public Line(int[] inputArray) {
		super(inputArray);
	}

	@Override
	public void renderStrokes() {
		if (getStartX() == getEndX()) {
			//vertical
			if (getStartY() < getEndY()) {
				for (int y = getStartY(); y<=getEndY(); y++) {
					appendStroke(getStartX(), y);
				}
			} else {
				for (int y = getStartY(); y>=getEndY(); y--) {
					appendStroke(getStartX(), y);
				}
			}
		}
		
		if (getStartY() == getEndY()) {
			//horizontal
			if (getStartX() < getEndX()) {
				for (int x = getStartX(); x<=getEndX(); x++) {
					appendStroke(x, getStartY());
				}
			} else {
				for (int x = getStartX(); x>=getEndX(); x--) {
					appendStroke(x, getStartY());
				}
			}
		}
	}
}
