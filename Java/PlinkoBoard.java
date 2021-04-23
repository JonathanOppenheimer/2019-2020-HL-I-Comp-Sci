package Java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner; 

public class PlinkoBoard extends JPanel {
	static int xPosition = 42;
	static int yPosition = 2; 
	static int starting_x; 
	
	static int times_left;
	static int maintain_total_times; 
	
	static int score = 0; 
	
	//set up for point values 
	static int[]pointPositions = {5,45,85,125,165,205,245,285,325,365};
	static String[]pointValues = {"0","10","50","100","1000","1000","100","50","10","0"};
	
	public static void main(String[]args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		PlinkoBoard b1 = new PlinkoBoard();
		frame.add(b1);
		frame.setTitle("JPlinko");
		frame.setSize(400,660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Set starting position from user input on console
		Scanner kb = new Scanner(System.in);
		System.out.println("How many times would you like to run the game?");
		times_left = kb.nextInt();
		maintain_total_times = times_left; 
		
		//Set starting position from user input on console
		System.out.println("What starting position would you like to start in? (1-10)");
		starting_x = kb.nextInt();
		starting_x = starting_x - 1;
		starting_x = starting_x * 40;
		starting_x = starting_x + 2;
		xPosition = starting_x; 
		
		while(times_left > 0)
		{
			movePlinko();
			frame.repaint();
			Thread.sleep(0);
		}
		
		System.out.println("The total number of points you gained was " + score);
		System.out.println("The average amount of points you gained was " + score/maintain_total_times);
		kb.close();
	}
	public void paint (Graphics g)
	{	
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		//y is 20 less than board
		g2.fillRect(0, 0, 400, 780);
		g2.setColor(Color.BLACK);
		//vertical black lines
		for(int i=0; i<=400; i=i+40)
		{
			g2.fillRect(i, 0, 1, 600);
		}
		//horizontal black lines
		for(int i=0; i<=600; i=i+40)
		{
			g2.fillRect(0, i, 400, 1);
		}
		//point values
		g2.setColor(Color.YELLOW);
		for(int i=0; i<pointPositions.length; i++)
		{
			g2.drawString(pointValues[i], pointPositions[i], 595);
		}
		//score and times left
		g2.drawString("Score: " + score, 30, 620);
		g2.drawString("Drop remaining: " + (times_left), 200, 620);
		//cube
		g2.setColor(Color.RED);
		g2.fillRect(xPosition, yPosition, 38, 38);
		
	}
	static void movePlinko()
	{
		double num = Math.random();
	
		yPosition+= 40; 
		if(num<.5)
		{
			if(xPosition < 395)
			{
				xPosition+=40; 
			}
			else
			{
				xPosition-=40; 
			}
		}
		else
		{
			if(xPosition > 5)
			{
				xPosition-=40; 
			}
			else
			{
				xPosition+=40; 
			}
		}
	
		if(yPosition > 600)
		{
			for(int i=0; i<pointPositions.length-1; i++)
			{
				if(xPosition > pointPositions[i] && xPosition <pointPositions[i+1])
				{
					score = score + Integer.parseInt(pointValues[i]); 
				}
			}
			times_left--; 
			xPosition = starting_x; 
			yPosition = 2; 
		}
	}
}