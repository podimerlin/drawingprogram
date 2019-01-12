package test.java.com.cs.drawing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.java.com.cs.drawing.model.Point;
import main.java.com.cs.drawing.model.Rectangle;

public class RectangleTest {
	@Test
	public void createRectangle() {
		int[] rectArray = {14, 1, 18, 3};
		Rectangle rect = new Rectangle(rectArray);
		
		Assert.assertEquals(14, rect.getStartX());
		Assert.assertEquals(1, rect.getStartY());
		Assert.assertEquals(18, rect.getEndX());
		Assert.assertEquals(3, rect.getEndY());
		
	}

	/*
	"----------------------"
	"|             xxxxx  |"
	"|             x   x  |"
	"|             xxxxx  |"
	"|                    |"
	"----------------------";
	*/
	
	@Test
	public void checkPerimeterLines() {
		int[] rectArray = {14, 1, 18, 3};
		Rectangle rect = new Rectangle(rectArray);
		rect.render();
		List<Integer> xArr = new ArrayList<>();
		List<Integer> yArr = new ArrayList<>();

		Integer[] y = {1, 2, 3};
		Integer[] x = {14, 15, 16, 17, 18};
		
		for (Point p : rect.getStroke()) {
			if (!yArr.contains(p.getY())) {
				yArr.add(p.getY());
			}
			if (!xArr.contains(p.getX())) {
				xArr.add(p.getX());
			}
		}
		Collections.sort(xArr);
		Collections.sort(yArr);
		
		Assert.assertArrayEquals(x, xArr.toArray(new Integer[0]));
		Assert.assertArrayEquals(y, yArr.toArray(new Integer[0]));
	}
}
