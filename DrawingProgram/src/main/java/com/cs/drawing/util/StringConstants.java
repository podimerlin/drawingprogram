package main.java.com.cs.drawing.util;

public enum StringConstants {
	ERROR_COMMAND_NOT_AVAI("Command not Available"),
	ERROR_INVALID_PARAM("Invalid Parameters"),
	NL(System.getProperty("line.separator")), 
	HORIZONTAL_OUTLINE("-"), 
	VERTICAL_OUTLINE("|"), 
	STROKE("x"), 
	BLANK(" "),
	SHAPES_COMMAND("L,R"), 
	ERROR_NO_CANVAS("Create a canvas first with the command : C [width] [height]");
	
	String value;

	StringConstants(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
