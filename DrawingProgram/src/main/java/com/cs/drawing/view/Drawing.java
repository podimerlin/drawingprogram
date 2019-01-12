package main.java.com.cs.drawing.view;

import java.util.Scanner;

import main.java.com.cs.drawing.controller.CanvasController;

public class Drawing {
	
	public static void main(String[] args) {
		CanvasController draw = new CanvasController();
		String p = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("enter command: ");
			String command = sc.nextLine();
			p = draw.run(command);
			if (p != "q") {
				System.out.println(p);
			}
		} while (p != "q");
	}
}
