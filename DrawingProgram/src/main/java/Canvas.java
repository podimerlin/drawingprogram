package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Canvas {
	
	private Character canvas[][];
	final String NL = System.getProperty("line.separator"); 
	private List<Shape> shapeList = new ArrayList<>();
	
	public Canvas() {
		
	}

	public Canvas(int hor, int ver) {
		canvas = new Character[ver][hor];
		for (int i=0; i<canvas.length; i++) {
			for (int j=0; j<canvas[i].length; j++) {
				canvas[i][j] = ' ';
			}
		}
	}
	
	public Character[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(Character[][] canvas) {
		this.canvas = canvas;
	}

	public List<Shape> getShapeList() {
		return shapeList;
	}

	public void setShapeList(List<Shape> shapeList) {
		this.shapeList = shapeList;
	}

	public String printCanvas() {
		
		drawShapeInCanvas();
		
		StringBuffer ret = new StringBuffer();
		String s = "-";
		int horizontalLength = 2;
		if (canvas != null) {
			horizontalLength += canvas[0].length;
		}
		String outlineX = IntStream.range(0, horizontalLength).mapToObj(i -> s).collect(Collectors.joining(""));
		ret.append(outlineX).append(NL);
		
		if (canvas != null) {
			for (int i=0; i<canvas.length; i++) {
				if (i > 0) {
					ret.append(NL);
				}
				ret.append("|");
				//print inner
				for (int j=0; j<canvas[i].length; j++) {
					ret.append(canvas[i][j]);
				}
				ret.append("|");
			}
			ret.append(NL);
		}
		
		ret.append(outlineX);
		
		return ret.toString();
	}
	
	public void drawShapeInCanvas() {
		for(Shape s : shapeList) {
    		for (Point p : s.getStroke()) {
    			canvas[p.getY()-1][p.getX()-1] = 'x';
    		}
		}
	}
	
	public void addShape(char c , int[] inputArray) {
		Shape s = null;
		switch(c) {
			case 'L': 
				s = new Line(inputArray);
				break;
			default:
				break;
		}
		shapeList.add(s);
	}
}
