package main.java.com.cs.drawing.model;

import java.util.ArrayList;
import java.util.List;

import main.java.com.cs.drawing.service.ShapeService;
import main.java.com.cs.drawing.util.StringConstants;

public abstract class Shape implements ShapeService {
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private List<Point> stroke = new ArrayList<>();
	
	public Shape(int[] inputArray) {
		startX = inputArray[0];
		startY = inputArray[1];
		endX = inputArray[2];
		endY = inputArray[3];
	}
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	public int getEndX() {
		return endX;
	}
	
	public void setEndX(int endX) {
		this.endX = endX;
	}
	
	public int getEndY() {
		return endY;
	}
	
	public void setEndY(int endY) {
		this.endY = endY;
	}
	
	public List<Point> getStroke() {
		return stroke;
	}
	
	public void setStroke(List<Point> stroke) {
		this.stroke = stroke;
	}
	
	public void appendStroke(Point p) {
		stroke.add(p);
	}
	
	public void appendStroke(int x,  int y) {
		Point p = new Point(x, y);
		stroke.add(p);
	}
	
	public void drawOntoCanvas(Character[][] canvas) {
		for (Point p : stroke) {
			if (canvas[p.getY()-1][p.getX()-1] == StringConstants.BLANK.getValue().charAt(0)) {
				canvas[p.getY()-1][p.getX()-1] = StringConstants.STROKE.getValue().charAt(0);
			}
		}
	}
	
}
