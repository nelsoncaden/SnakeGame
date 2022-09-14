import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * JPanel child that moves the snake and allows it to eat the fruit
 * and hit things. It also creates the background
 * @author Caden Nelson
 *
 */
public class Grid extends JPanel {
	private int score;
	private ArrayList<SnakeSegment> chunk = new ArrayList<SnakeSegment>(0);
	private Fruit fruit;
	private int xDirection = 60;
	private int yDirection = 0;
	
	/**
	 * Constructor for Grid object
	 */
	public Grid() {
		this.score = 0;
		chunk.add(new SnakeSegment(306, 306));
	}
	
	/**
	 * Paints the background and snake
	 * @param Graphics g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, 606, 606);
		g.setColor(new Color(100, 200, 255));
		for (int i = 0; i < 600; i += 60) {
			for (int j = 0; j < 600; j += 60) {
				g.fillRect(i + 6, j + 6, 54, 54);
			}
		}
		fruit.paintComponent(g);
		for(int i = 0; i < chunk.size(); i++) {
			chunk.get(i).paintComponent(g);
		}
	}
	
	/**
	 * Returns current score
	 * @return int score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Returns true if the snake hit the wall
	 * @return Boolean true if hit wall
	 */
	public boolean hitWall() {
		if(chunk.get(0).getxBox() + 60 > 606 || chunk.get(0).getxBox() < 0 ||
				chunk.get(0).getyBox() + 60 > 606 || chunk.get(0).getyBox() < 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the snake hit itself
	 * @return Boolean true if hit self
	 */
	public boolean hitSelf() {
		for(int i = 1; i < chunk.size(); i++) {
			if(chunk.get(0).getxBox() == chunk.get(i).getxBox() &&
					chunk.get(0).getyBox() == chunk.get(i).getyBox()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Increases points and creates new fruit if eaten
	 */
	public void eat() {
		if(chunk.get(0).getxBox() == fruit.getxBox() && 
				chunk.get(0).getyBox() == fruit.getyBox()) {
			fruit = new Fruit(chunk);
			chunk.add(new SnakeSegment(chunk.get(chunk.size()-1).getxBox(), 
					chunk.get(chunk.size()-1).getyBox()));
			score++;
		}
	}
	
	/**
	 * Makes a new fruit
	 */
	public void makeFruit() {
		fruit = new Fruit(chunk);
	}
	
	/**
	 * Moves the snake along one chunk at a time
	 */
	public void move() {
		int xTemp = chunk.get(0).getxBox();
		int yTemp = chunk.get(0).getyBox();
		chunk.get(0).setxBox(xTemp + xDirection);
		chunk.get(0).setyBox(yTemp + yDirection);
		int x2Temp;
		int y2Temp;
		for (int i = 1; i < chunk.size(); i++) {
			x2Temp = chunk.get(i).getxBox();
			y2Temp = chunk.get(i).getyBox();
			chunk.get(i).setxBox(xTemp);
			chunk.get(i).setyBox(yTemp);
			xTemp = x2Temp;
			yTemp = y2Temp;
		}
	}

	/**
	 * Returns direction in x-axis
	 * @return int direction
	 */
	public int getxDirection() {
		return xDirection;
	}

	/**
	 * Sets direction in x-axis
	 * @param int xDirection
	 */
	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	/**
	 * Returns direction in y-axis
	 * @return int yDirection
	 */
	public int getyDirection() {
		return yDirection;
	}

	/**
	 * Sets direction in y-axis
	 * @param int yDirection
	 */
	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
}
