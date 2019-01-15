package test.java.com.cs.drawing;

import org.junit.Assert;
import org.junit.Test;

import main.java.com.cs.drawing.CanvasController;
import main.java.com.cs.drawing.util.StringConstants;

public class CanvasControllerTest {
	
	@Test
	public void canReadCommand() {
		CanvasController cc = new CanvasController();
		String commandStr = "C 20 4";
		String testStr = 
				"----------------------" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"----------------------";
		
		Assert.assertEquals(testStr, cc.run(commandStr));
	}
	
	@Test
	public void canReadLineCommand() {
		CanvasController cc = new CanvasController();
		String canvasCommand = "C 20 4";
		String commandStr = "L 1 1 4 1";
		String testStr = 
				"----------------------" + StringConstants.NL.getValue() +
				"|xxxx                |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"----------------------";
		cc.run(canvasCommand);
		Assert.assertEquals(testStr, cc.run(commandStr));
	}
	
	@Test
	public void canReadRectangleCommand() {
		CanvasController cc = new CanvasController();
		String canvasCommand = "C 20 4";
		String commandStr = "R 1 1 4 4";
		String testStr = 
				"----------------------" + StringConstants.NL.getValue() +
				"|xxxx                |" + StringConstants.NL.getValue() +
				"|x  x                |" + StringConstants.NL.getValue() +
				"|x  x                |" + StringConstants.NL.getValue() +
				"|xxxx                |" + StringConstants.NL.getValue() +
				"----------------------";
		cc.run(canvasCommand);
		Assert.assertEquals(testStr, cc.run(commandStr));
	}
	
	@Test
	public void canReadFillCommand() {
		CanvasController cc = new CanvasController();
		String canvasCommand = "C 20 4";
		String commandStr = "B 1 1 c";
		String testStr = 
				"----------------------" + StringConstants.NL.getValue() +
				"|cccccccccccccccccccc|" + StringConstants.NL.getValue() +
				"|cccccccccccccccccccc|" + StringConstants.NL.getValue() +
				"|cccccccccccccccccccc|" + StringConstants.NL.getValue() +
				"|cccccccccccccccccccc|" + StringConstants.NL.getValue() +
				"----------------------";
		cc.run(canvasCommand);
		Assert.assertEquals(testStr, cc.run(commandStr));
	}
}
