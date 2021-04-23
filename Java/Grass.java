package Java;

public class Grass 
{
	private int xPos, yPos;
	private int red,green,blue;
	private int shade; 
	
	public Grass(int number)
	{
		int x = number%20;
		xPos = x*40;
		int y = number/20;
		yPos = y*40;
		red = 9;
		green = 244;
		blue = 9; 
		shade = 3; 
	}
	public int getXpos()
	{
		return xPos;
	}
	public int getYpos()
	{
		return yPos;
	}
	public int getRed()
	{
		return red; 
	}
	public int getBlue() 
	{
		return blue; 
	}
	public int getGreen()
	{
		return green; 
	}
	public void setColor(boolean hit)
	{
		if(hit==true)
		{
			shade--; 
		}
		if(shade==2)
		{
			green = 122; 
		}
		else if(shade==1)
		{
			green = 61; 
		}
		else if(shade<1)
		{
			green = 30; 
			red=30;
		}
	}
}