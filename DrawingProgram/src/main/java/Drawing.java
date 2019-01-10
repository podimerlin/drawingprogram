package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Drawing {
	
	
	final String NL = System.getProperty("line.separator"); 
	private Character canvas[][];
	
	public Drawing() {
		
	}
	
	public static void main(String[] args) {
		Drawing draw = new Drawing();
		String p = "";
		do {
			System.out.println("enter command: ");
			Scanner sc = new Scanner(System.in);
			String command = sc.nextLine();
			p = draw.run(command);
			if (p != "q") {
				System.out.println(p);
			}
		} while (p != "q");
	}
	
	public String printCanvas() {
		StringBuffer ret = new StringBuffer();
		String s = "-";
		int horizontalLength = 2;
		if (canvas != null) {
			horizontalLength += canvas[0].length;
		}
		String outlineX = IntStream.range(0, horizontalLength).mapToObj(i -> s).collect(Collectors.joining(""));
		ret.append(outlineX).append(NL);
		
		if (canvas != null) {
			for (int i=0; i<canvas.length; i++) {
				if (i > 0) {
					ret.append(NL);
				}
				ret.append("|");
				//print inner
				for (int j=0; j<canvas[i].length; j++) {
					ret.append(canvas[i][j]);
				}
				ret.append("|");
			}
			ret.append(NL);
		}
		
		ret.append(outlineX);
		
		return ret.toString();
	}

	public void createCanvas(int hor, int ver) {
		canvas = new Character[ver][hor];
		for (int i=0; i<canvas.length; i++) {
			for (int j=0; j<canvas[i].length; j++) {
				canvas[i][j] = ' ';
			}
		}
	}

	public void drawLine(int[] lineArray) {
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		try {
			startX = lineArray[0] - 1;
			startY = lineArray[1] - 1;
			endX = lineArray[2] - 1;
			endY = lineArray[3] - 1;
		} catch (NullPointerException npe) {
			//invalid arguments
			return;
		}
		
		try {
			char check1 = canvas[startY][startX];
			char check2 = canvas[endY][endX];
		} catch (ArrayIndexOutOfBoundsException ae) {
			
			return;
		}
		
		
		if (startX == endX) {
			//vertical
			if (startY < endY) {
				for (int y = startY; y<=endY; y++) {
					canvas[y][startX] = 'x';
				}
			} else {
				for (int y = startY; y>=endY; y--) {
					canvas[y][startX] = 'x';
				}
			}
			
		}
		
		if (startY == endY) {
			//horizontal
			if (startX < endX) {
				for (int x = startX; x<=endX; x++) {
					canvas[startY][x] = 'x';
				}
			} else {
				for (int x = startX; x>=endX; x--) {
					System.out.println(x);
					canvas[startY][x] = 'x';
				}
			}
		}
		
	}

	public void drawRectangle(int[] rectArray) {
		int topLX = 0;
		int topLY = 0;
		int botRX = 0;
		int botRY = 0;
		try {
			topLX = rectArray[0] - 1;
			topLY = rectArray[1] - 1;
			botRX = rectArray[2] - 1;
			botRY = rectArray[3] - 1;
		} catch (NullPointerException npe) {
			//invalid arguments
			return;
		}
		
		try {
			char check1 = canvas[topLY][topLX];
			char check2 = canvas[botRY][botRX];
		} catch (ArrayIndexOutOfBoundsException ae) {
			return;
		}
		
		
		for (int x = topLX; x<=botRX; x++) {
			//horizontal
			canvas[topLY][x] = 'x';
			canvas[botRY][x] = 'x';
		}
		
		for (int y = topLY; y<=botRY; y++) {
			//vertical
			canvas[y][topLX] = 'x';
			canvas[y][botRX] = 'x';
		}
		
	}

	public String run(String commandStr) {
		String command[] = commandStr.split(" ");
		String method = command[0];
		String[] lineArray = new String[command.length-1];
		System.arraycopy(command, 1, lineArray, 0, command.length-1);
		int[] inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
		
		switch (method) {
			case "C":
			case "c":
				this.createCanvas(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				break;
				
			case "L":
			case "l":
				this.drawLine(inputs);
				break;
				
			case "R":
			case "r":
				this.drawRectangle(inputs);
				break;	
				
			case "Q":
			case "q":
				return "q";
			default:
				return "Command not available";
		}
		return printCanvas();
	}

	public void floodFill(String[] fillArray) {
		int x = 0;
		int y = 0;
		Character fill = ' ';
		
		try {
			x = Integer.parseInt(fillArray[0]) - 1;
			y = Integer.parseInt(fillArray[1]) - 1;
			fill = fillArray[2].toCharArray()[0];
			if (x < 0 || y <0) {
				return;
			}
		} catch (Exception e) {
			//invalid inputs
			return;
		}
		
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		Integer[] first = {x, y};
		canvas[first[0]][first[1]] = fill;
	    queue.add(first);

	    //[ver][hor]
	    while (!queue.isEmpty()) 
	    {
	    	Integer[] p = queue.remove();
        	//left
    		Integer[] left = {p[0], p[1] - 1};
    		try {
    			if (canvas[left[0]][left[1]] == ' ') {
	    			canvas[left[0]][left[1]] = fill;
	        		queue.add(left);
	    		}
	    	} catch (ArrayIndexOutOfBoundsException aio) {
	    		//out of canvas
	    	}
            //right
            Integer[] right = {p[0], p[1] + 1};
            try {
            	if (canvas[right[0]][right[1]] == ' ') {
	            	canvas[right[0]][right[1]] = fill;
	            	queue.add(right);
	            }
	           } catch (ArrayIndexOutOfBoundsException aio) {
	           	//out of canvas
	           }
            //top
            Integer[] top = {p[0]-1, p[1]};
            try {
            	if (canvas[top[0]][top[1]] == ' ') {
	            	canvas[top[0]][top[1]] = fill;
	            	queue.add(top);
	            }
	           } catch (ArrayIndexOutOfBoundsException aio) {
	           	//out of canvas
	           }
            //bot
            Integer[] bot = {p[0]+1, p[1]};
            try {
            	if (canvas[bot[0]][bot[1]] == ' ') {
	            	canvas[bot[0]][bot[1]] = fill;
	            	queue.add(bot);
            	}
	       } catch (ArrayIndexOutOfBoundsException aio) {
	       	//out of canvas
	       }             
	    }
		
	}


}
