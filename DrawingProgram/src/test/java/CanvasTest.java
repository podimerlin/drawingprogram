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
}
