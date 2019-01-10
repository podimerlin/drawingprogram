package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Drawing {
	
	final String NL = System.getProperty("line.separator"); 

	final String ERROR_COMMAND_NOT_AVAIL = "Command not Available" + NL + 
									"Use the following commands: " + NL +
									"Command 		Description " + NL +
									"C w h\t\t\t\t\t Should create a new canvas of width w and height h." + NL +
                                    "L x1 y1 x2 y2\t\t\t\t\t Should create a new line from (x1,y1) to (x2,y2). Currently only" + NL +
                                    "\t\t\t\t\t\t\t horizontal or vertical lines are supported. Horizontal and vertical lines" + NL +
                                    "\t\t\t\t\t\t\t will be drawn using the 'x' character." + NL +
                                    "R x1 y1 x2 y2\t\t\t\t\t Should create a new rectangle, whose upper left corner is (x1,y1) and" + NL +
                                    "\t\t\t\t\t\t\t lower right corner is (x2,y2). Horizontal and vertical lines will be drawn" + NL +
                                    "\t\t\t\t\t\t\t using the 'x' character." + NL +
                                    "B x y c\t\t\t\t\t Should fill the entire area connected to (x,y) with \"colour\" c. The" + NL +
                                    " \t\t\t\t\t\t\t behaviour of this is the same as that of the \"bucket fill\" tool in paint" + NL +
                                    " \t\t\t\t\t\t\t programs." + NL +
                                    "Q\t\t\t\t\tShould quit the program.";
	
	final String ERROR_INVALID_PARAM = "Invalid Parameters";
	
	public Drawing() {
		
	}
	
	public static void main(String[] args) {
		Drawing draw = new Drawing();
		String p = "";
		Scanner sc = new Scanner(System.in);
		/*do {
			System.out.println("enter command: ");
			String command = sc.nextLine();
			p = draw.run(command);
			if (p != "q") {
				System.out.println(p);
			}
		} while (p != "q");*/
	}

	/*public void drawLine(int[] lineArray) throws Exception {
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
			throw new Exception("invalid param");
		}
		
		try {
			char check1 = canvas[startY][startX];
			char check2 = canvas[endY][endX];
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new Exception("not within canvas");
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

	public void drawRectangle(int[] rectArray) throws Exception {
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
			throw new Exception("invalid param");
		}
		
		try {
			char check1 = canvas[topLY][topLX];
			char check2 = canvas[botRY][botRX];
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new Exception("not within canvas");
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
		int[] inputs;
		
		switch (method) {
			case "C":
			case "c":
				try {
					if (lineArray.length > 2) {
						return ERROR_INVALID_PARAM;
					}
					this.createCanvas(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]));
				} catch (NegativeArraySizeException | NumberFormatException ne) {
					return ERROR_INVALID_PARAM;
				}
				break;
				
			case "L":
			case "l":
				try {
    				inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
    				this.drawLine(inputs);
				} catch (NumberFormatException nfe) {
					return ERROR_INVALID_PARAM;
				} catch (Exception e) {
					return e.getMessage();
				}
				break;
				
			case "R":
			case "r":
				try {
					inputs = Arrays.asList(lineArray).stream().mapToInt(Integer::parseInt).toArray();
					this.drawRectangle(inputs);
				}  catch (NumberFormatException nfe) {
					return ERROR_INVALID_PARAM;
				} catch (Exception e) {
					return e.getMessage();
				}
				break;	
				
			case "Q":
			case "q":
				return "q";
				
			case "B":
			case "b":
				this.floodFill(lineArray);
				break;
			default:
				return ERROR_COMMAND_NOT_AVAIL;
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
		Integer[] first = {y, x};
		try {
    		if (canvas[first[0]][first[1]] == ' ') {
    			canvas[first[0]][first[1]] = fill;
    	    	queue.add(first);
    		}
		} catch (ArrayIndexOutOfBoundsException aio) {
			//out of canvas
			return;
		}

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
		
	}*/


}
