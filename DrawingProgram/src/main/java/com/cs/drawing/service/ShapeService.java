package main.java.com.cs.drawing.service;

/**
 * Defines features of Shape Objects
 * @author MerC
 *
 */

public interface ShapeService {	
	void renderStrokes();
	void drawOntoCanvas(Character[][] canvas);
}