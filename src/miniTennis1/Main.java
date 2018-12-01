package miniTennis1;

import javax.swing.JFrame;

public class Main {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		JFrame frame = new JFrame("Mini Tennis");
		
			Game game = new Game();
			frame.add(game);
			frame.setSize(300, 400);
			
			frame.setVisible(true);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
			while (true) {
				game.move();
				game.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

}


