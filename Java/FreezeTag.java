package Java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FreezeTag extends JPanel {
	private static final long serialVersionUID = 1L;
	static int x = 282;
	static int y = 282; 
	static int lastKey = 0;
	static int keyNum = 0;
	
	static int[]aiPosition_x = {242,322,242,322};
	static int[]aiPosition_y = {122,122,202,202};
	static boolean[]moving = {true,true,true,true};
	
	
	public static void main(String[]args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		FreezeTag b1 = new FreezeTag();
		frame.add(b1);
		frame.setTitle("Freeze Tag");
		frame.setSize(600,620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(true)
		{
			movePlayer();
			moveAi();
			hitBoxes();
			frame.repaint();
			Thread.sleep(100);
		}
	}
	public FreezeTag()
	{
		KeyListener listener = new myKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}
	private static void movePlayer() 
	{
		if(keyNum==87){y=y-40;}
		if(keyNum==68){x=x+40;}
		if(keyNum==65){x=x-40;}
		if(keyNum==83){y=y+40;}
		if(y > 600){y = 2;}
		if(y < 0){y = 562;}
		if(x > 600){x = 2;}
		if(x < 0){x = 562;}
	}
	private static void moveAi()
	{
		for(int i=0; i<aiPosition_x.length; i++)
		{
			double random = Math.random(); 
			
			if(moving[i])
			{
				if(random < 0.25){aiPosition_x[i] += 40;}
				else if(random < 0.5){aiPosition_x[i] -= 40;}
				else if(random < 0.75){aiPosition_y[i] += 40;}
				else if(random < 1){aiPosition_y[i] -= 40;}
				if(aiPosition_y[i] > 600){aiPosition_y[i] = 2;}
				if(aiPosition_y[i] < 0){aiPosition_y[i] = 562;}
				if(aiPosition_x[i] > 600){aiPosition_x[i] = 2;}
				if(aiPosition_x[i] < 0){aiPosition_x[i] = 562;}
			}
		}
	}
	private static void hitBoxes()
	{
		for(int i=0; i<moving.length; i++)
		{
			if(x+14 > aiPosition_x[i] && x+14 < aiPosition_x[i]+38 &&
			   y+14 > aiPosition_y[i] && y+14 < aiPosition_y[i]+38)
			{
				moving[i] = false; 
			}
		}
	}
	public class myKeyListener implements KeyListener
	{
		public void keyPressed(KeyEvent e) 
		{
			keyNum = e.getKeyCode();
		}
		public void keyReleased(KeyEvent e) 
		{
            keyNum = 0;
		}
		public void keyTyped(KeyEvent e) {}
	}
	public void paint (Graphics g)
	{	
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		//y is 20 less than board
		g2.fillRect(0, 0, 600, 600);
		g2.setColor(Color.BLACK);
		//vertical black lines
		for(int i=0; i<=600; i=i+40)
		{
			g2.fillRect(i, 0, 1, 600);
		}
		//horizontal black lines
		for(int i=0; i<=600; i=i+40)
		{
			g2.fillRect(0, i, 600, 1);
		}
		//artificial intelligence
		for(int i=0; i<aiPosition_x.length; i++)
		{
			if(moving[i] == true)
			{
				g2.setColor(Color.RED);
				g2.fillRect(aiPosition_x[i], aiPosition_y[i], 38, 38);
			}
			else
			{
				g2.setColor(Color.MAGENTA);
				g2.fillRect(aiPosition_x[i], aiPosition_y[i], 38, 38);
			}
		}
		//cube
		g2.setColor(Color.GREEN);
		g2.fillRect(x, y, 38, 38);
	}
}