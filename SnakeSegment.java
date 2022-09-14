import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class represents the position and color of 
 * a single segment of the snake
 * @author Caden Nelson
 *
 */
public class SnakeSegment extends JComponent {
	private Color segmentColor;
	private int yBox;
	private int xBox;
	
	/**
	 * Creates a snake segment at the specified position
	 * @param int xBox x position
	 * @param int yBox y position
	 */
	public SnakeSegment(int xBox, int yBox) {
		this.yBox = yBox;
		this.xBox = xBox;
		segmentColor = new Color(0,(int)(255-(60*Math.random())),0);
	}
	
	/**
	 * Paints snake segment
	 * @param Graphics g
	 */
	public void paintComponent(Graphics g) {
		g.setColor(segmentColor);
		g.fillRect(xBox, yBox, 54, 54);
	}

	/**
	 * Returns y position of snake chunk
	 * @return int y position of snake chunk
	 */
	public int getyBox() {
		return yBox;
	}

	/**
	 * Sets y position of snake chunk
	 * @param yBox int position of snake chunk
	 */
	public void setyBox(int yBox) {
		this.yBox = yBox;
	}

	/**
	 * Returns x position of snake chunk
	 * @return x int position of snake chunk
	 */
	public int getxBox() {
		return xBox;
	}

	/**
	 * Sets x position of snake chunk
	 * @param xBox int position of snake chunk
	 */
	public void setxBox(int xBox) {
		this.xBox = xBox;
	}
}
