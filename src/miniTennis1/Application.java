package miniTennis1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Application implements ActionListener{
	
	
	JFrame MenuFrame = new JFrame("Game Menu");
	
	public Application() {
		GUI();
	}
	
	public void GUI() {
		MenuFrame.getContentPane().setLayout(null);
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(87, 79, 97, 25);
		MenuFrame.getContentPane().add(btnPlay);
		
		JButton btnHighScore = new JButton("High Score");
		btnHighScore.setBounds(87, 133, 97, 25);
		MenuFrame.getContentPane().add(btnHighScore);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(87, 187, 97, 25);
		MenuFrame.getContentPane().add(btnExit);
		
		
		MenuFrame.setSize(300, 400);
		
		MenuFrame.setVisible(true);
		
		
		MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnHighScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("Check high score");
				
				JFrame scoreFrame = new JFrame("Score");	
				
				//scoreFrame.getContentPane().setLayout(null);
		    	
				scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
				scoreFrame.setSize(300, 400);
				
				
				//JTextArea tarea = new JTextArea(10, 10);
				
				 JLabel mylabel = new JLabel(); 
				 JTextPane tp = new JTextPane();
				 
			
				try {
			          BufferedReader input = new BufferedReader(new InputStreamReader(
			              new FileInputStream("Score.txt")));
			          
			          //mylabel.setText((String) input);
			          tp.read(input,null);
			          tp.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 30));
			          //tarea.read(input, "READING FILE :-)");
			        } catch (Exception ex) {
			          ex.printStackTrace();
			        }
				//tp.setBounds(87, 133, 97, 25);
				//tp.setBounds(100, 133, 100, 100);
				scoreFrame.getContentPane().add(tp, BorderLayout.CENTER);
				
				
				scoreFrame.setVisible(true);
				
			   } //end actionPerformed
			
		});	
		
		
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Exit");
				System.exit(0);
			}
		});	
				
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String comStr = e.getActionCommand();
			    System.out.println(comStr + " Selected");
			   // MenuFrame.dispose();
			   	
			    	System.out.println(" Playing");
			    	JFrame frame = new JFrame("Mini Tennis");	
			    	
			    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    	frame.setSize(300, 400);
			    
			    	frame.setVisible(true);
			    	
			    	Game game = new Game();
			    	
			    	frame.getContentPane().add(game);
			    	
			    	
			    	while (true) {
			    		
						game.move();
						game.repaint();
					//	frame.invalidate();
						frame.revalidate();
						frame.repaint();
						
						
						try {
							
							Thread.sleep(10);

						} catch (InterruptedException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						
					  }//while end
			    
			}

			
		});
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Application app =new Application();
		
	 }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

	


