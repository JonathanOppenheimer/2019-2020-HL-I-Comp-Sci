package Java;

import javax.swing.JOptionPane;

public class Stack_Team_Alliance_Client 
{
	String[]teams;
	int team_spot_counter = 0; 
	int alliance_spot_counter; 
	int length; 
	public Stack_Team_Alliance_Client(int length) 
	{
		teams = new String[length];
		this.length = length; 
		alliance_spot_counter = length-1; 
		menu();
	}
	public void menu()
	{
		int temp = Integer.parseInt(JOptionPane.showInputDialog("1] Add a team name" + "\n" + "2] Pick an alliance member" + "\n" + "3] See all teams in the queue" + "\n" + "4] Exit the program"));
		if(temp==1)
		{
			addTeam();
			menu();
		}
		else if(temp==2)
		{
			allianceChoose();
			menu();
		}
		else if(temp==3)
		{
			seeQueue();
			menu();
		}
		else if(temp==4)
		{
			quit();
		}		
	}
	public void addTeam()
	{
		if(team_spot_counter < length)
		{
			String team = JOptionPane.showInputDialog("What's the name of the team");
			teams[team_spot_counter] = team; 
			team_spot_counter++; 
		}
	}
	public void allianceChoose() 
	{
		
		if(alliance_spot_counter >= 0 && teams[alliance_spot_counter] != null)
		{
			String output = ""; 
			for(int i=0; i<teams.length; i++)
			{
				if(teams[i] !=null)
				{
					output = output + teams[i] + "\n";
				}
			}
			String team = JOptionPane.showInputDialog(teams[alliance_spot_counter] + ", who would you like to alliance with?" + "\n" + output);
			
			for(int i=0; i<length; i++)
			{
				if(teams[i] != null && team != null) 
				{
					if(teams[i].equals(team))
					{	
						JOptionPane.showMessageDialog(null, teams[i] + " and " + teams[alliance_spot_counter] + " are alliance members.");
						teams[i] = null;
						teams[alliance_spot_counter] = null; 
					}
				}
			}
		}
		else
		{
			alliance_spot_counter--; 
			allianceChoose();
		}
	}
	public void seeQueue()
	{
		String output = ""; 
		for(int i=0; i<teams.length; i++)
		{
			if(teams[i] !=null)
			{
				output = output + teams[i] + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, output);
	}
	public void quit()
	{
		System.exit(0);
	}
}
