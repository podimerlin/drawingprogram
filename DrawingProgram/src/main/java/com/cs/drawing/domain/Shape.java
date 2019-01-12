package main.java.com.cs.drawing.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape implements ShapeInterface {
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private List<Point> stroke = new ArrayList<>();;
	
	public Shape(int[] inputArray) {
		startX = inputArray[0];
		startY = inputArray[1];
		endX = inputArray[2];
		endY = inputArray[3];
		init();
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
	
	public abstract void init();
	
}
