package main.java;

import java.util.Scanner;

public class Drawing {
	
	public Drawing() {
		
	}
	
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

	/*

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
