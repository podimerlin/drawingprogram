package test.java.domain;

import org.junit.Assert;
import org.junit.Test;

import main.java.domain.Line;
import main.java.domain.Point;

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
	public void checkHorizontalLine() {
		int[] lineArray = {1, 2, 6, 2};
		Line line = new Line(lineArray);
		
		Assert.assertEquals(6, line.getStroke().size());
		for (Point p : line.getStroke()) {
			Assert.assertEquals(2, p.getY());
		}
	}
	
	@Test
	public void checkVerticalLine() {
		int[] lineArray = {4, 2, 4, 10};
		Line line = new Line(lineArray);
		
		Assert.assertEquals(9, line.getStroke().size());
		for (Point p : line.getStroke()) {
			Assert.assertEquals(4, p.getX());
		}
	}
		
}
