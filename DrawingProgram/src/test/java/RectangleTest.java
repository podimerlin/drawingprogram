package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.java.Rectangle;

public class RectangleTest {
	@Test
	public void createRectangle() {
		int[] rectArray = {14, 1, 18, 3};
		Rectangle rect = new Rectangle(rectArray);
		
		Assert.assertEquals(14, rect.getTopLX());
		Assert.assertEquals(1, rect.getTopLY());
		Assert.assertEquals(18, rect.getBotRX());
		Assert.assertEquals(3, rect.getBotRY());
		
	}
}
