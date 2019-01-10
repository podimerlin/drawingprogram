package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.java.Line;

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
		
}
