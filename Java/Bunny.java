package Java;

public class Bunny {
	private int xPos, yPos;
	private boolean alive;
	
	public Bunny(int number)
	{
		xPos = number * 80;
		yPos = (int)(Math.random()*20)*40;
		alive = true; 
	}
	private void setXpos()
	{
		if(Math.random()<0.5 && xPos<780)
		{
			xPos = xPos + 40; 
		}
		else if(xPos >= 40)
		{
			xPos = xPos - 40;
		}
	}
	public int getXpos()
	{
		setXpos();
		return xPos; 
	}
	private void setYpos()
	{
		if(Math.random() < 0.5 && yPos < 640)
		{
			yPos = yPos + 40; 
		}
		else if(yPos >= 40)
		{
			yPos = yPos - 40; 
		}
	}
	public int getYpos()
	{
		setYpos();
		return yPos; 
		
	}
	public void setAlive(boolean alive)
	{
		this.alive = alive; 
	}
	public boolean getAlive()
	{
		return alive;
	}
}