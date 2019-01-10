package test.java;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.Drawing;

public class DrawingTest {

	@Test
	public void callPrintMethod() {
		Drawing draw = new Drawing();
		String emptyCanvas = "--" + "\n" +
							"--";
		emptyCanvas = emptyCanvas.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		Assert.assertEquals(emptyCanvas, draw.printCanvas());
	}
	
	@Test
	public void printCanvas() {
		Drawing draw = new Drawing();
		String testStr = 
				"----------------------" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw.createCanvas(20, 4);
				
		Assert.assertEquals(testStr, draw.printCanvas());

	}
	
	@Test
	public void printLine() {
		//L x1 y1 x2 y2
		
		Drawing draw = new Drawing();
		String test1Str = 
				"----------------------" + "\n" +
				"|                    |" + "\n" +
				"|xxxxxx              |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw.createCanvas(20, 4);
		int[] lineArray = {1, 2, 6, 2}; 
		draw.drawLine(lineArray);
		
		Assert.assertEquals(test1Str, draw.printCanvas());
		
		Drawing draw2 = new Drawing();
		test1Str = 
				"----------------------" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw2.createCanvas(20, 4);
		int[] lineArray2 = {6, 1, 6, 4}; 
		draw2.drawLine(lineArray2);
		
		Assert.assertEquals(test1Str, draw2.printCanvas());
		
		//reverse the number
		Drawing draw3 = new Drawing();
		test1Str = 
				"----------------------" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw3.createCanvas(20, 4);
		int[] lineArray3 = {6, 4, 6, 1}; 
		draw3.drawLine(lineArray3);
		
		Assert.assertEquals(test1Str, draw3.printCanvas());
		
	
		//reverse the number
		Drawing draw4 = new Drawing();
		test1Str = 
				"----------------------" + "\n" +
				"|                    |" + "\n" +
				"|xxxxxx              |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw4.createCanvas(20, 4);
		int[] lineArray4 = {6, 2, 1, 2}; 
		draw4.drawLine(lineArray4);
		
		Assert.assertEquals(test1Str, draw4.printCanvas());
	}
	
	@Test
	public void printContinousLine() {
		Drawing draw = new Drawing();
		String test1Str = 
				"----------------------" + "\n" +
				"|                    |" + "\n" +
				"|xxxxxx              |" + "\n" +
				"|     x              |" + "\n" +
				"|     x              |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw.createCanvas(20, 4);
		int[] lineArray = {1, 2, 6, 2}; 
		draw.drawLine(lineArray);
		int[] lineArray2 = {6, 3, 6, 4};
		draw.drawLine(lineArray2);
		
		Assert.assertEquals(test1Str, draw.printCanvas());
	}
	
	@Test 
	public void printRectangle() {
		Drawing draw = new Drawing();
		String test1Str = 
				"----------------------" + "\n" +
				"|             xxxxx  |" + "\n" +
				"|             x   x  |" + "\n" +
				"|             xxxxx  |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw.createCanvas(20, 4);
		int[] rectArray = {14, 1, 18, 3};
		draw.drawRectangle(rectArray);
		
		Assert.assertEquals(test1Str, draw.printCanvas());
		
	}
	
	@Test 
	public void printContinousRectangle() {
		Drawing draw = new Drawing();
		String test1Str = 
				"----------------------" + "\n" +
				"|             xxxxx  |" + "\n" +
				"|xxxxxx       x   x  |" + "\n" +
				"|     x       xxxxx  |" + "\n" +
				"|     x              |" + "\n" +
				"----------------------";
		test1Str = test1Str.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		draw.createCanvas(20, 4);
		int[] lineArray = {1, 2, 6, 2}; 
		draw.drawLine(lineArray);
		int[] lineArray2 = {6, 3, 6, 4};
		draw.drawLine(lineArray2);
		int[] rectArray = {14, 1, 18, 3};
		draw.drawRectangle(rectArray);
		
		Assert.assertEquals(test1Str, draw.printCanvas());
	}
	
	@Test
	public void usePrintCanvasCommand() {
		Drawing draw = new Drawing();
		String testStr = 
				"----------------------" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command = "C 20 4";
				
		Assert.assertEquals(testStr, draw.run(command));
	}
	
	@Test
	public void useDrawLineCommand() {
		Drawing draw = new Drawing();
		String testStr = 
				"----------------------" + "\n" +
				"|                    |" + "\n" +
				"|xxxxxx              |" + "\n" +
				"|                    |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command1 = "C 20 4";
		draw.run(command1);
		String command2 = "L 1 2 6 2";
				
		Assert.assertEquals(testStr, draw.run(command2));
	}
	
	@Test
	public void useDrawRectangleCommand() {
		Drawing draw = new Drawing();
		String testStr = 
				"----------------------" + "\n" +
				"|             xxxxx  |" + "\n" +
				"|             x   x  |" + "\n" +
				"|             xxxxx  |" + "\n" +
				"|                    |" + "\n" +
				"----------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command1 = "C 20 4";
		draw.run(command1);
		String command2 = "R 14 1 18 3";
		
		Assert.assertEquals(testStr, draw.run(command2));
	}
	
	@Test
	public void fillEmptyCanvas() {
		Drawing draw = new Drawing();
		String testStr = 
				"--------------------" + "\n" +
				"|cccccccccccccccccc|" + "\n" +
				"|cccccccccccccccccc|" + "\n" +
				"--------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command1 = "C 18 2";
		draw.run(command1);
		String[] fillArray = {"1", "1", "c"};
		draw.floodFill(fillArray);
		
		Assert.assertEquals(testStr, draw.printCanvas());
	}
	
	@Test
	public void fillWithinLine() {
		Drawing draw2 = new Drawing();
		String testStr = 
				"--------------------" + "\n" +
				"|ccx               |" + "\n" +
				"|ccx               |" + "\n" +
				"--------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command1 = "C 18 2";
		draw2.run(command1);
		String command2 ="L 3 1 3 2";
		draw2.run(command2);
		String[] fillArray2 = {"1", "1", "c"};
		draw2.floodFill(fillArray2);
		
		Assert.assertEquals(testStr, draw2.printCanvas());
	}
	
	@Test
	public void fillOnLine() {
		Drawing draw2 = new Drawing();
		String testStr = 
				"--------------------" + "\n" +
				"|  x               |" + "\n" +
				"|  x               |" + "\n" +
				"--------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command1 = "C 18 2";
		draw2.run(command1);
		String command2 ="L 3 1 3 2";
		draw2.run(command2);
		String[] fillArray2 = {"3", "1", "c"};
		draw2.floodFill(fillArray2);
		
		Assert.assertEquals(testStr, draw2.printCanvas());
	}
	
	@Test
	public void callFillCommandOnEmptyCanvas() {
		Drawing draw = new Drawing();
		String testStr = 
				"--------------------" + "\n" +
				"|cccccccccccccccccc|" + "\n" +
				"|cccccccccccccccccc|" + "\n" +
				"--------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String command1 = "C 18 2";
		draw.run(command1);
		String command2 = "B 1 1 c";
		
		Assert.assertEquals(testStr, draw.run(command2));
	}
	
	@Test 
	public void callFillCommandWithExistingLines() {
		Drawing draw = new Drawing();
		String testStr =
				"----------------------" + "\n" +
				"|oooooooooooooxxxxxoo|" + "\n" +
				"|xxxxxxooooooox   xoo|" + "\n" +
				"|     xoooooooxxxxxoo|" + "\n" +
				"|     xoooooooooooooo|" + "\n" +
				"----------------------";
		testStr = testStr.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		String cmd1 = "C 20 4";
		String cmd2 = "L 1 2 6 2";
		String cmd3 = "L 6 3 6 4";
		String cmd4 = "R 14 1 18 3";
		String cmd5 = "B 10 3 o";
		draw.run(cmd1);
		draw.run(cmd2);
		draw.run(cmd3);
		draw.run(cmd4);
		
		Assert.assertEquals(testStr, draw.run(cmd5));
	}
}
