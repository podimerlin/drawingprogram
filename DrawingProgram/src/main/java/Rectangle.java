package main.java;

public class Rectangle {
	
	private int topLX = 0;
	private int topLY = 0;
	private int botRX = 0;
	private int botRY = 0;

	public Rectangle(int[] rectArray) {
		topLX = rectArray[0];
		topLY = rectArray[1];
		botRX = rectArray[2];
		botRY = rectArray[3];
	}

	public int getTopLX() {
		return topLX;
	}

	public void setTopLX(int topLX) {
		this.topLX = topLX;
	}

	public int getTopLY() {
		return topLY;
	}

	public void setTopLY(int topLY) {
		this.topLY = topLY;
	}

	public int getBotRX() {
		return botRX;
	}

	public void setBotRX(int botRX) {
		this.botRX = botRX;
	}

	public int getBotRY() {
		return botRY;
	}

	public void setBotRY(int botRY) {
		this.botRY = botRY;
	}

}
