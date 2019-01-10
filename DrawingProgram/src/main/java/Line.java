package main.java;

public class Line {
	private int startX = 0;
	private int startY = 0;
	private int endX = 0;
	private int endY = 0;
	
	public Line(int[] lineArray) {
		startX = lineArray[0];
		startY = lineArray[1];
		endX = lineArray[2];
		endY = lineArray[3];
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

}
