package main.java;

import java.util.Arrays;

import main.java.util.constants.StringConstants;

public class CanvasController {
	
	Canvas canvas;
	
	public String run(String commandStr) {
		String command[] = commandStr.split(" ");
		String method = command[0];
		String[] lineArray = new String[command.length-1];
		System.arraycopy(command, 1, lineArray, 0, command.length-1);
		int[] inputs;
		
		switch (method) {
			//create canvas
			case "C":
			case "c":
				inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
				canvas = new Canvas();
				canvas.setCanvasByInput(inputs);
				break;
			//add shapes
			case "L":
			case "l":
			case "R":
			case "r":
				inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
				canvas.addShape(method.charAt(0), inputs);	
				break;	
				
			case "Q":
			case "q":
				return "q";
				
			case "B":
			case "b":
				canvas.fillCanvas(lineArray);
				break;
			default:
				return StringConstants.ERROR_COMMAND_NOT_AVAI.getValue();
		}
		return canvas.printCanvas();
	}
	
}
