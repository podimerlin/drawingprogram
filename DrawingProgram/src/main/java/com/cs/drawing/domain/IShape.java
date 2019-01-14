package main.java.com.cs.drawing.domain;

/**
 * Defines features of Shape Objects
 * @author MerC
 *
 */

public interface IShape {	
	void renderStrokes();
	void drawOntoCanvas(Character[][] canvas);
}