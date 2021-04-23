package Java;

public class Wolves 
{
	private int xPos;
	private int yPos;
	private int moveCount;
	private int eatCount; 
	private boolean alive; 
	
	public Wolves(int number)
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
			wellFed(1,0);
		}
		else if(xPos >= 40)
		{
			xPos = xPos - 40;
			wellFed(1,0);
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
			wellFed(1,0);
		}
		else if(yPos >= 40)
		{
			yPos = yPos - 40; 
			wellFed(1,0);
		}
	}
	public int getYpos()
	{
		setYpos();
		return yPos; 
	}
	public void wellFed(int moveCount, int eatCount)
	{
		this.moveCount = this.moveCount + moveCount;
		this.eatCount = this.eatCount + eatCount; 
		
		if(this.moveCount > ((this.eatCount+1)*150))
		{
			setAlive(false);
		}
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
