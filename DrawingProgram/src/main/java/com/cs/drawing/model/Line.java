package main.java.com.cs.drawing.model;

import main.java.com.cs.drawing.service.ShapeService;

public class Line extends Shape implements ShapeService{

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
