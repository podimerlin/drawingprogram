package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import main.java.domain.Line;
import main.java.domain.Point;
import main.java.domain.Rectangle;
import main.java.domain.Shape;
import main.java.util.constants.StringConstants;

public class Canvas {
	
	private Character canvas[][];
	private List<Shape> shapeList = new ArrayList<>();
	
	public Canvas() {
		
	}

	public Canvas(int hor, int ver) {
		canvas = new Character[ver][hor];
		fillCanvas();
	}
	
	public void setCanvasByInput(int[] inputArray) {
		canvas = new Character[inputArray[1]][inputArray[0]];
		fillCanvas();
	}
	
	private void fillCanvas() {
		if (canvas != null) {
			for (int i=0; i<canvas.length; i++) {
				for (int j=0; j<canvas[i].length; j++) {
					canvas[i][j] = StringConstants.BLANK.getValue().charAt(0);
				}
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
		String s = StringConstants.HORIZONTAL_OUTLINE.getValue();
		int horizontalLength = 2;
		if (canvas != null) {
			horizontalLength += canvas[0].length;
		}
		String outlineX = IntStream.range(0, horizontalLength).mapToObj(i -> s).collect(Collectors.joining(""));
		ret.append(outlineX).append(StringConstants.NL.getValue());
		
		if (canvas != null) {
			for (int i=0; i<canvas.length; i++) {
				if (i > 0) {
					ret.append(StringConstants.NL.getValue());
				}
				ret.append(StringConstants.VERTICAL_OUTLINE.getValue());
				//print inner
				for (int j=0; j<canvas[i].length; j++) {
					ret.append(canvas[i][j]);
				}
				ret.append(StringConstants.VERTICAL_OUTLINE.getValue());
			}
			ret.append(StringConstants.NL.getValue());
		}
		
		ret.append(outlineX);
		return ret.toString();
	}
	
	public void drawShapeInCanvas() {		
		for(Shape s : shapeList) {			
    		for (Point p : s.getStroke()) {
    				if (canvas[p.getY()-1][p.getX()-1] == StringConstants.BLANK.getValue().charAt(0)) {
    					canvas[p.getY()-1][p.getX()-1] = StringConstants.STROKE.getValue().charAt(0);
    				}
    		}
		}
	}
	
	public void addShape(char c , int[] inputArray) {
		if (canvas != null) {
			Shape s = null;
			switch(c) {
				case 'L':
				case 'l':
					s = new Line(inputArray);
					break;
				case 'R':
				case 'r':
					s = new Rectangle(inputArray);
					break;
				default:
					break;
			}
			if(checkShapeFitsInCanvas(s)) {
				shapeList.add(s);
			}
		}
	}
	
	private boolean checkShapeFitsInCanvas(Shape s) {
		if (s.getStartX() > canvas[0].length ||
				s.getStartX() <= 0 ||
				s.getEndX() > canvas[0].length ||
				s.getEndX() <= 0 ||
				s.getStartY() > canvas.length ||
				s.getStartY() <= 0 ||
				s.getEndY() > canvas.length ||
				s.getEndY() <=0 ) {
			return false;
		}
		return true;
	}
}
