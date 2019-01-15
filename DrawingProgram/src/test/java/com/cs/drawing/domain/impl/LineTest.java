package test.java.com.cs.drawing.domain.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import main.java.com.cs.drawing.domain.Point;
import main.java.com.cs.drawing.domain.impl.Line;

public class LineTest {
	@Test
	public void createLine() {
		//L x1 y1 x2 y2
		int[] lineArray = {1, 2, 6, 2};
		Line line = new Line(lineArray);
		
		Assert.assertEquals(1, line.getStartX());
		Assert.assertEquals(2, line.getStartY());
		Assert.assertEquals(6, line.getEndX());
		Assert.assertEquals(2, line.getEndY());
	}
	
	@Test
	public void checkInvalidParamsForCreateLine() {
		int[] lineArray1 = {1, 2, 62};
		int[] lineArray2 = {1, 2, 6, 5, 2};
		
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Line(lineArray1));
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Line(lineArray2));
	}
	
	@Test
	public void checkHorizontalLine() {
		int[] lineArray = {1, 2, 6, 2};
		Line line = new Line(lineArray);
		line.renderStrokes();
		
		Assert.assertEquals(6, line.getStroke().size());
		for (Point p : line.getStroke()) {
			Assert.assertEquals(2, p.getY());
		}
	}
	
	@Test
	public void checkVerticalLine() {
		int[] lineArray = {4, 2, 4, 10};
		Line line = new Line(lineArray);
		line.renderStrokes();
		Assert.assertEquals(9, line.getStroke().size());
		for (Point p : line.getStroke()) {
			Assert.assertEquals(4, p.getX());
		}
	}
		
}
