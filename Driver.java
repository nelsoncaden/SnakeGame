import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * The Driver class is a child of the JFrame class. It includes a panel, score label, and option pane.
 * @author Caden Nelson (with assistance from professor Dr. Garrett Goodman of Miami University
 * on general procedure and certain methods)
 *
 */
public class Driver extends JFrame {
	public static final int WINDOW_WIDTH = 620;
	public static final int WINDOW_HEIGHT = 660;
	private int score;
	private JLabel scoreLabel = new JLabel("Score: " + score);
	private Grid panel;
	private boolean hitWall = false;
	private boolean hitSelf = false;
	private int slowDown = 0;
	private JOptionPane optionPane = new JOptionPane();
	
	/**
	 * Constructor builds a panel with a key listener and 
	 * various specifications.
	 */
	public Driver() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		panel = new Grid();
		panel.addKeyListener(new Direction(panel));
		panel.setFocusable(true);
		score = panel.getScore();
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.add(scoreLabel, BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		setTitle("The Snake Game");
		centerFrame(this);
	}
	
	/**
	 * My professor created most of this method.
	 */
	public void start() {
		panel.makeFruit();
		gameLoop();
	}
	
	/**
	 * This updates everything (such as the snake and fruit)
	 * and repaints the panel. It will halt the program when
	 * the snake hits itself or the wall.
	 */
	public void gameLoop() {
		while(true) {
			pauseGame();
			slowDown++;
			if(slowDown % 10 == 1) {
				panel.move();
				hitSelf = panel.hitSelf();
				hitWall = panel.hitWall();
				score = panel.getScore();
				scoreLabel.setText("Score: " + score);
				panel.repaint();
				panel.eat();
			}
			if (hitWall || hitSelf) {
				finishGame();
				break;
			}
		}  
	}
	
	/**
	 * This method is largely my professor's as well
	 */
	public void pauseGame() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Displays score and renders option pane when game has ended
	 */
	public void finishGame() {
		String finalScore = "Your final score is: " + score;
		optionPane.showMessageDialog(optionPane, finalScore);
		return;
	}
	
	/**
	 * This method is my professor's code
	 * @param frame The JFrame object to be centered.
	 */
	public void centerFrame(JFrame frame) {    
		int width = frame.getWidth();
		int height = frame.getHeight();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point center = ge.getCenterPoint();

		int xPosition = center.x - width/2, yPosition = center.y - height/2;
		frame.setBounds(xPosition, yPosition, width, height);
		frame.validate();
	}
	
	/**
	 * Creates a Driver object and starts the game loop.
	 * @param args
	 */
	public static void main(String[] args) {
		Driver main = new Driver();
		main.setVisible(true);
		main.start();
	}
}
