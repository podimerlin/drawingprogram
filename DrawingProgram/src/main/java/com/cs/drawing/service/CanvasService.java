package main.java.com.cs.drawing.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import main.java.com.cs.drawing.impl.IShape;
import main.java.com.cs.drawing.model.Line;
import main.java.com.cs.drawing.model.Point;
import main.java.com.cs.drawing.model.Rectangle;
import main.java.com.cs.drawing.model.Shape;
import main.java.com.cs.drawing.util.StringConstants;

/*
 * Canvas drawing here 
 */
public class CanvasService {
	
	private Character canvas[][];
	private List<IShape> shapeList = new ArrayList<>();
	
	public CanvasService() {
		
	}

	public CanvasService(int hor, int ver) {
		canvas = new Character[ver][hor];
		fillCanvas();
	}
	
	public CanvasService(int[] inputArray) {
		initCanvas(inputArray);
	}
	
	public void initCanvas(int[] inputArray) {
		if (inputArray.length > 2) {
			throw new ArrayIndexOutOfBoundsException();
		}
		canvas = new Character[inputArray[1]][inputArray[0]];
		fillCanvas();
	}
	
	public Character[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(Character[][] canvas) {
		this.canvas = canvas;
	}

	public List<IShape> getShapeList() {
		return shapeList;
	}

	public void setShapeList(List<IShape> shapeList) {
		this.shapeList = shapeList;
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
	
	private void drawShapeInCanvas() {		
		for(IShape s : shapeList) {
			s.renderStrokes();
    		s.drawOntoCanvas(canvas);
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
				s.getEndY() <= 0 ) {
			return false;
		}
		return true;
	}

	public void fillCanvas(String[] fillArray) {
		drawShapeInCanvas();
		int x = 0;
		int y = 0;
		Character fill = ' ';
		
		try {
			x = Integer.parseInt(fillArray[0]) - 1;
			y = Integer.parseInt(fillArray[1]) - 1;
			fill = fillArray[2].toCharArray()[0];
			if (x < 0 || y <0) {
				return;
			}
		} catch (NumberFormatException e) {
			//invalid inputs
			return;
		}
		
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		Integer[] first = {y, x};
		try {
    		if (canvas[first[0]][first[1]] == ' ') {
    			canvas[first[0]][first[1]] = fill;
    	    	queue.add(first);
    		}
		} catch (ArrayIndexOutOfBoundsException aio) {
			//out of canvas
			return;
		}

	    //[ver][hor]
	    while (!queue.isEmpty()) 
	    {
	    	Integer[] p = queue.remove();
        	//left
    		Integer[] left = {p[0], p[1] - 1};
    		try {
    			if (canvas[left[0]][left[1]] == ' ') {
	    			canvas[left[0]][left[1]] = fill;
	        		queue.add(left);
	    		}
	    	} catch (ArrayIndexOutOfBoundsException aio) {
	    		//out of canvas
	    	}
            //right
            Integer[] right = {p[0], p[1] + 1};
            try {
            	if (canvas[right[0]][right[1]] == ' ') {
	            	canvas[right[0]][right[1]] = fill;
	            	queue.add(right);
	            }
	           } catch (ArrayIndexOutOfBoundsException aio) {
	           	//out of canvas
	           }
            //top
            Integer[] top = {p[0]-1, p[1]};
            try {
            	if (canvas[top[0]][top[1]] == ' ') {
	            	canvas[top[0]][top[1]] = fill;
	            	queue.add(top);
	            }
	           } catch (ArrayIndexOutOfBoundsException aio) {
	           	//out of canvas
	           }
            //bot
            Integer[] bot = {p[0]+1, p[1]};
            try {
            	if (canvas[bot[0]][bot[1]] == ' ') {
	            	canvas[bot[0]][bot[1]] = fill;
	            	queue.add(bot);
            	}
	       } catch (ArrayIndexOutOfBoundsException aio) {
	       	//out of canvas
	       }             
	    }
		
	}
}
