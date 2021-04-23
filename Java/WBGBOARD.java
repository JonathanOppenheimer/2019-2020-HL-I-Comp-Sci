package Java;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WBGBOARD extends JPanel
{
	static Grass [] grass = new Grass[400];
	static Bunny [] bunnies = new Bunny[20]; 
	static Wolves [] wolves = new Wolves[5]; 
	
	public static void main(String[]args) throws InterruptedException
	{
		for(int k=0; k<grass.length; k++)
		{
			grass[k] = new Grass(k);
		}
		for(int k=0; k<bunnies.length; k++)
		{
			bunnies[k] = new Bunny(k);
		}
		for(int k=0; k<wolves.length; k++)
		{
			wolves[k] = new Wolves(k);
		}
		
		JFrame frame = new JFrame("Wolves and Bunnies");
		WBGBOARD b1 = new WBGBOARD();
		frame.add(b1);
		frame.setSize(800,660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		while(true)
		{
			Thread.sleep(200);
			frame.repaint();
		}
		
	}
	public void paint(Graphics g)
	{
		collision();
		Graphics2D g2 = (Graphics2D)g; 
		for(int k=0; k<grass.length; k++)
		{
			Color c = new Color(grass[k].getRed(),grass[k].getGreen(),grass[k].getBlue());
			g2.setColor(c);
			g2.fillRect(grass[k].getXpos(), grass[k].getYpos(), 40, 40);
			
		}
		g2.setColor(Color.BLACK);
		for(int k=0; k<=40; k++)
		{
			g2.drawLine(0, k*40, 800, k*40);
			g2.drawLine(k*40, 0, k*40, 800);
		}
		g2.setColor(Color.DARK_GRAY);
		for(int k=0; k<bunnies.length; k++)
		{
			if(bunnies[k].getAlive()==true)
			{
				g2.fillRect(bunnies[k].getXpos(), bunnies[k].getYpos(), 40, 40);
			}
		}
		g2.setColor(Color.RED);
		for(int k=0; k<wolves.length; k++)
		{
			if(wolves[k].getAlive()==true)
			{
				g2.fillRect(wolves[k].getXpos(), wolves[k].getYpos(), 40, 40);
			}
		}	
	}
	static public void collision()
	{
		for(int k=0; k<wolves.length; k++)
		{
			for(int j=0; j<bunnies.length; j++)
			{
				if(wolves[k].getXpos()==bunnies[j].getXpos() && wolves[k].getYpos() == bunnies[j].getYpos())
				{
					bunnies[j].setAlive(false);
					wolves[k].wellFed(0, 1);
				}
			}
		}
		for(int k=0; k<grass.length; k++)
		{
			for(int j=0; j<bunnies.length; j++)
			{
				if(grass[k].getXpos()==bunnies[j].getXpos() && grass[k].getYpos()==bunnies[j].getYpos())
				{
					System.out.println("Grass x " + grass[k].getXpos() + " and Bunny x" + bunnies[j].getXpos() + "Grass y " + grass[k].getYpos() + " and Bunny y" + bunnies[j].getYpos());
					grass[k].setColor(true);		
				}
			}
		}
	}
}