package test.java;

import org.junit.Assert;
import org.junit.Test;
import main.java.Canvas;

public class CanvasTest {

	final String NL = System.getProperty("line.separator");
	@Test
	public void createEmptyCanvas() {
		Canvas canvas = new Canvas();
		String emptyCanvas = 
				"--" + NL +
				"--";
		Assert.assertNull(canvas.getCanvas());
		Assert.assertEquals(emptyCanvas, canvas.printCanvas());
	}
	
	@Test
	public void createBigCanvas() {
		Canvas canvas = new Canvas(20 , 4);
		String canvasStr = 
				"----------------------" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"----------------------";
		Assert.assertNotNull(canvas.getCanvas());
		Assert.assertEquals(canvasStr, canvas.printCanvas());
	}
	
	@Test
	public void createCanvasWithInput() {
		Canvas canvas = new Canvas();
		int[] inputArray = {20, 4};
		canvas.setCanvasByInput(inputArray);
		
		String canvasStr = 
				"----------------------" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"----------------------";
		Assert.assertNotNull(canvas.getCanvas());
		Assert.assertEquals(canvasStr, canvas.printCanvas());
	}
	
	@Test
	public void createShape() {
		Canvas c = new Canvas(20, 4);
		char shape = 'L';
		int[] inputArray = {1, 2, 6, 2};
		c.addShape(shape, inputArray);
		
		Assert.assertTrue(!c.getShapeList().isEmpty());
		
		c.addShape(shape, inputArray);
		Assert.assertEquals(2, c.getShapeList().size());
	}
	
	public void checkDontAddShapeIfDoesntFitInCanvas() {
		Canvas c = new Canvas(1, 1);
		char shape = 'L';
		int[] inputArray = {1, 2, 6, 2};
		c.addShape(shape, inputArray);
		Assert.assertTrue(c.getShapeList().isEmpty());
	}
	
	@Test
	public void drawLine() {
		String test1Str = 
				"----------------------" + NL +
				"|                    |" + NL +
				"|xxxxxx              |" + NL +
				"|                    |" + NL +
				"|                    |" + NL +
				"----------------------";
		
		Canvas c = new Canvas(20 , 4);
		char shape = 'L';
		int[] inputArray = {1, 2, 6, 2};
		
		c.addShape(shape, inputArray);
		
		Assert.assertEquals(1, c.getShapeList().size());
		Assert.assertEquals(6, c.getShapeList().get(0).getStroke().size());
		Assert.assertEquals(test1Str, c.printCanvas());
		
		String test2Str = 
				"----------------------" + NL +
				"|                    |" + NL +
				"|xxxxxx              |" + NL +
				"|xxxx                |" + NL +
				"|                    |" + NL +
				"----------------------";
		
		int[] inputArray2 = {1, 3, 4, 3};
		c.addShape(shape, inputArray2);
		
		Assert.assertEquals(2, c.getShapeList().size());
		Assert.assertEquals(test2Str, c.printCanvas());
		
		String test3Str = 
				"----------------------" + NL +
				"|     x              |" + NL +
				"|xxxxxx              |" + NL +
				"|xxxx x              |" + NL +
				"|     x              |" + NL +
				"----------------------";
		
		int[] inputArray3 = {6, 1, 6, 4};
		c.addShape(shape, inputArray3);
		
		Assert.assertEquals(test3Str, c.printCanvas());
	}
	
	@Test
	public void drawRectangle() {
		String test1Str = 
				"----------------------" + NL +
				"|             xxxxx  |" + NL +
				"|             x   x  |" + NL +
				"|             xxxxx  |" + NL +
				"|                    |" + NL +
				"----------------------";
		
		Canvas c = new Canvas(20 , 4);
		char shape = 'R';
		int[] inputArray = {18, 1, 14, 3};
		
		c.addShape(shape, inputArray);
		
		Assert.assertEquals(test1Str, c.printCanvas());
		
		String test2Str = 
				"----------------------" + NL +
				"|xxxxxxxxxxxxxxxxxx  |" + NL +
				"|x                x  |" + NL +
				"|x                x  |" + NL +
				"|xxxxxxxxxxxxxxxxxx  |" + NL +
				"----------------------";
		c = new Canvas(20 , 4);
		int[] inputArray2 = {1, 1, 18, 4};
		
		c.addShape(shape, inputArray2);
		Assert.assertEquals(test2Str, c.printCanvas());
		
	}
}
