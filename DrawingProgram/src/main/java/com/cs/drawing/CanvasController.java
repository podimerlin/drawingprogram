package main.java.com.cs.drawing;

import java.util.Arrays;
import java.util.List;

import main.java.com.cs.drawing.service.CanvasService;
import main.java.com.cs.drawing.util.StringConstants;

/*
 * Determines Canvas commands from user input
 */
public class CanvasController {
	
	CanvasService canvas = new CanvasService();
	
	
	public String run(String commandStr) {
		String command[] = commandStr.split(" ");
		String method = command[0];
		String[] lineArray = new String[command.length-1];
		System.arraycopy(command, 1, lineArray, 0, command.length-1);
		int[] inputs;
		
		try {
			switch (method) {
				//create canvas
				case "C":
				case "c":
					inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
					canvas.initCanvas(inputs);
					break;
				case "Q":
				case "q":
					return "q";
				case "B":
				case "b":
					canvas.fillCanvas(lineArray);
					break;
				//add shapes
				default:
					inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
					try {
						addShape(method, inputs);
					} catch (Exception e) {
						//invalid command
						return e.getMessage();
					}
			}
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException an) {
			return StringConstants.ERROR_INVALID_PARAM.getValue();
		}
		return canvas.printCanvas();
	}
	
	private void addShape(String shape, int[] inputs) throws Exception, ArrayIndexOutOfBoundsException {
		if (canvas == null) {
			throw new Exception(StringConstants.ERROR_NO_CANVAS.getValue());
		}
		List<String> shapesCmd = Arrays.asList(StringConstants.SHAPES_COMMAND.getValue().split(","));
		try {
			if (shapesCmd.contains(shape.toUpperCase())) {
				canvas.addShape(shape.charAt(0), inputs);
			} else {
				throw new Exception(StringConstants.ERROR_COMMAND_NOT_AVAI.getValue());
			}
		} catch (Exception e) {
			throw new Exception(StringConstants.ERROR_COMMAND_NOT_AVAI.getValue());
		}
	}
	
}
