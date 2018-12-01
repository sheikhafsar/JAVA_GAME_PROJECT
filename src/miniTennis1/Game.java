//program to move shapes(Animation)
package miniTennis1;
	
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Audio.Sound;



public class Game extends JPanel{
	
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	
	int speed = 1;

	private int getScore() {
		return speed - 1;
	}
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
		//Color c =new Color(100,0,0);
		//setBackground(new Color(0,102,0));
		setBackground(Color.green);
		//setBackground(Color.red);
		Sound.BACK.loop();
	}

	public void move() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.black);
		ball.paint(g2d);
		racquet.paint(g2d);
		
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
		
	}
	
	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		
		//write score in File
		 String nextLine;
	     int sc=0;
		 
		FileWriter fileWriter;
		try {
			
			 BufferedReader inFile = new BufferedReader(new FileReader("Score.txt"));
			
			 while((nextLine = inFile.readLine())!= null){
				 sc = Integer.parseInt(nextLine);
			 }
			 
			
			 
			// System.out.printf("sc: %d",sc);
			 
			 
			 //System.out.print(getScore());
			
			if(getScore()>sc)	//check if current score greater than highest score 
			{
				fileWriter = new FileWriter("Score.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print(getScore());
			   // printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1111);
			    printWriter.close();
			    
			    JOptionPane.showMessageDialog(this, "Congrats Your score " + getScore()+" is Highest.",
						"Game Over", JOptionPane.YES_NO_OPTION);
				System.exit(ABORT);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
		//JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(this, "Ohh, Your score is: " + getScore()+"\n Play Again.",
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

}
