import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class determines the direction of the snake based on which keys 
 * have been pressed. W, A, S, and D as well as the UP, DOWN, LEFT, and RIGHT
 * arrows may be used. 
 * @author Caden Nelson
 *
 */
public class Direction implements KeyListener {
	
	private Grid grid;
	
	/**
	 * Constructor for Direction object
	 * @param grid 
	 */
	public Direction(Grid grid) {
		this.grid = grid;
	}
	
	/**
	 * Sets the direction of the snake
	 * @param KeyEvent e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			grid.setxDirection(0);
			grid.setyDirection(-60);
		} else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			grid.setxDirection(-60);
			grid.setyDirection(0);
		} else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			grid.setxDirection(0);
			grid.setyDirection(60);
		} else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			grid.setxDirection(60);
			grid.setyDirection(0);
		}
	}

	/**
	 * Must implement these methods
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Must implement this method
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
