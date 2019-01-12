package main.java.com.cs.drawing.domain;

import java.util.List;

public interface ShapeInterface {

	int getStartX();

	void setStartX(int startX);

	int getStartY();

	void setStartY(int startY);

	int getEndX();

	void setEndX(int endX);

	int getEndY();

	void setEndY(int endY);

	List<Point> getStroke();

	void setStroke(List<Point> stroke);

	void appendStroke(Point p);
	
	void appendStroke(int x,  int y);

	void init();

}