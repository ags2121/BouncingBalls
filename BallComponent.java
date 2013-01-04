package bounce_ball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/** * The component that draws the balls. * @version 1.33 2007-05-17 * @author Cay Horstmann */
@SuppressWarnings("serial")
public class BallComponent extends JPanel {
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	/** * Add a ball to the component. * @param b the ball to add */
	public void add(Ball b) {
		balls.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // erase background
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<balls.size(); i++){
			for(int j=0; j<i; j++){
				if (balls.get(i).collide(balls.get(j))){
					balls.get(i).collision();
					balls.get(j).collision();
				}
			}
			
			g2.fill(balls.get(i).getShape());

		}

	}
}

