import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * The fruit object contains the positions, shapes, and 
 * appearance of the fruits.
 * @author Caden Nelson
 *
 */
public class Fruit extends JComponent {
	private int yBox;
	private int xBox;
	private Color fruitColor;
	
	/**
	 * Determines the color of the fruit and gives it a random location
	 * @param chunk A segment of the snake
	 */
	public Fruit(ArrayList<SnakeSegment>chunk) {
		this.fruitColor = new Color(255, 0, 0);
		int underBelly = 0;
		int x = 60*(int)(Math.random() * 10) + 6;
		int y = 60*(int)(Math.random() * 10) + 6;
		this.xBox = x;
		this.yBox = y;
	}
	
	/**
	 * Paints the fruit
	 * @param Graphics g
	 */
	public void paintComponent(Graphics g) {
		g.setColor(fruitColor);
		g.fillOval(xBox, yBox, 54, 54);
		g.setColor(new Color(0, 255, 0));
		g.fillRect(xBox + 20, yBox + 20, 10, 10);
	}

	/**
	 * Returns the y position of fruit
	 * @return int y position of fruit
	 */
	public int getyBox() {
		return yBox;
	}

	/**
	 * Sets the y position of fruit
	 * @param yBox int y position of fruit
	 */
	public void setyBox(int yBox) {
		this.yBox = yBox;
	}

	/**
	 * Returns the x position of fruit
	 * @return int x position of fruit
	 */
	public int getxBox() {
		return xBox;
	}

	/**
	 * Sets the x position of fruit
	 * @param xBox int x position of fruit
	 */
	public void setxBox(int xBox) {
		this.xBox = xBox;
	}
}
