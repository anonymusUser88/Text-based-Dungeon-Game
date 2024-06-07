/*
 * This is the player class
 * All variable and methods related to the player are here 
 * April 22, 2024
 * */

package mainPackage;

import java.util.ArrayList;

public class Player 
{
	private int playerMoney = 0; // player's money
	private int playerHealth = 20; // player's health
	private ArrayList<String> playerInventory = new ArrayList<String>(); // player's inventory
	
	// 0 = they have it, 1 = they do not have it
	private int hasGems = 1;
	private int hasSword = 1;
	private int hasShield = 1;
	private int hasPotion = 1;
	private int hasBarrier = 1;
	private int hasSpear = 1;
	
	public Player()
	{
		playerInventory.add("Stick (-3 hp)"); // the player automatically gets a stick
	}
	
	public void addObjectToInventory(String object)
	{
		this.playerInventory.add(object); // adds object to inventory
		
		// checking what object it is
		if (object.equals("Sword (-3 hp)"))
		{
			this.hasSword = 0;
		}
		else if (object.equals("Gems (-1 hp)"))
		{
			this.hasGems = 0;
		}
		else if (object.equals("Shield (+1 hp)")) 
		{
			this.hasShield = 0;
		}
		else if (object.equals("Attack Potion (-2 hp)"))
		{
			this.hasPotion = 0;
		}
		else if (object.equals("Magical Barrier (+2 hp)"))
		{
			this.hasBarrier = 0;
		}
		else if (object.equals("Spear (-1 hp)"))
		{
			this.hasSpear = 0;
		}
	}
	
	public void printPlayerInventory()
	{
		System.out.println("You have: ");

		if (this.playerMoney > 0) // if the player has money
		{
			System.out.println("    $" + this.playerMoney); // it is printed
		}
		
		System.out.println("    Health: " + this.playerHealth);
		
		for (int i = 0; i < this.playerInventory.size(); i++) // prints the things in the inventory
		{
			System.out.println("    " + this.playerInventory.get(i));
		}
	}
	
	// accessor and mutator methods
	
	public void setPlayerMoney(int amountOfMoney)
	{
		this.playerMoney+=amountOfMoney;
	}
	
	public ArrayList<String> getPlayerInventory()
	{
		return this.playerInventory; 
	}
	
	public int getPlayerHealth()
	{
		return this.playerHealth;
	}
	
	public void setPlayerHealth(int health)
	{
		this.playerHealth = health;
	}
	
	public int getHasGems()
	{
		return this.hasGems;
	}
	
	public int getHasSword()
	{
		return this.hasSword;
	}
	
	public int getHasShield()
	{
		return this.hasShield;
	}
	
	public int getHasPotion()
	{
		return this.hasPotion;
	}
	
	public int getHasBarrier()
	{
		return this.hasBarrier;
	}
	
	public int getHasSpear()
	{
		return this.hasSpear;
	}
	
	public void setHasGems(int value)
	{
		this.hasGems = value;
	}
	
	public void setHasSword(int value)
	{
		this.hasSword = value;
	}
	
	public void setHasShield(int value)
	{
		this.hasShield = value;
	}
	
	public void setHasPotion(int value)
	{
		this.hasPotion = value;
	}
	
	public void setHasBarrier(int value) 
	{
		this.hasBarrier = value;
	}
	
	public void setHasSpear(int value)
	{
		this.hasShield = value;
	}
	
	public int getPlayerMoney()
	{
		return this.playerMoney;
	}
}
