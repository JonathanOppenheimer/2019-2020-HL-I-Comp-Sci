package Java;

import java.util.ArrayList;

public class MoneySimulator 
{
	public static void main(String[]args)
	{
		int real = 25;
		int counter = 0;
		boolean check = true;
		
		
		ArrayList<Integer> deposit = new ArrayList<Integer>(0); 
		for (int i=0; i<real; i++) 
		{
			deposit.add(1);
		}
		
		while(probability(deposit, check))
		{
			deposit.add(2);
			for(int i=0; i<deposit.size(); i++)
			{
				counter=0;
				if(deposit.get(i)==2)
				{
					counter++;
				}
				System.out.println(counter);
			}
		}	
	}
	public static boolean probability(ArrayList<Integer> deposit, boolean check)
	{
		int size = (int) (deposit.size()-25*.05)+1;
		for(int i=0; i<size; i++)
		{
			int temp = (int) (Math.random() * (3) + 1);
			if(temp==1)
			{
				check = false;
			}
		}
		return check;
	}
}