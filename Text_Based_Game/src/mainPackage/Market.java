/*
 * The store where the user can buy power ups with money
 * April 20, 2024
 */

package mainPackage;

import java.util.Scanner;

public class Market 
{
	static Scanner scan = new Scanner(System.in); // scanner
	static String playerAnswer; // the player's answer
	static boolean playerMadeChoice = false; // checks whether the user made a choice yet
	static String[] itemsToBuy = {"+15 Hp", "Attack Potion (-2 hp)", "Magical Barrier (+2 hp)"}; // an array tracking the items
	static String[] inputs = {"h", "p", "m"}; // the inputs to get the items
	static int[] costOfItems = {600, 600, 500}; // the cost of items
	static boolean[] itemIsAvailable = {true, true, true}; // tracks whether items are available
	
	public Market() 
	{
		
	}
	
	public static void generateItems()
	{
		playerMadeChoice = false; // set back to false
		System.out.println("Welcome to the store!");
		System.out.println("This is what's available in the store:");
		System.out.println("Your money: $" + Driver.player.getPlayerMoney()); // prints amount of money
		
		for (int i = 0; i < itemsToBuy.length; i++)
		{
			if (itemIsAvailable[i]) // if the item was not bought yet
			{
				System.out.println("    " + itemsToBuy[i] + " (" + inputs[i]+ ") : $" + costOfItems[i]); // the item is printed
			}
		}
		
		System.out.println("    Nothing (n)");
		System.out.println("What do you want to buy?");
		
		while (!playerMadeChoice) // while the player hasn't made a choice
		{
			playerAnswer = scan.nextLine(); // prompts the player
			switch(playerAnswer)
			{
				case "h": // add 15 hp
					checkIfUserCanBuyItem(0); // program checks to see if the player can buy it
					playerMadeChoice = true; // the player made a choice
					break;
					
				case "p": // potion
					checkIfUserCanBuyItem(1);
					playerMadeChoice = true;
					break;
					
				case "m": // magic barrier
					checkIfUserCanBuyItem(2);
					playerMadeChoice = true;
					break;
					
				case "n": // nothing
					System.out.println("Thank you for visiting the store!");
					playerMadeChoice = true;
					break;
					
				default: // invalid input
					System.out.println("Not a valid input. Try again");
					break;
			}
		}
	}
	
	public static void checkIfUserCanBuyItem(int item)
	{
		if (Driver.player.getPlayerMoney() >= costOfItems[item]) // if the player has enough money
		{
			System.out.println("Congrats, you bought " + itemsToBuy[item] + "!");
			Driver.player.setPlayerMoney(costOfItems[item]*-1); // amount is taken out of player's account

			if (item == 0) // health
			{
				Driver.player.setPlayerHealth(Driver.player.getPlayerHealth()+15); // player's health is changed
			}
			else 
			{
				Driver.player.addObjectToInventory(itemsToBuy[item]); // added to inventory
			}
			itemIsAvailable[item] = false; // the item is no longer available
		}
		
		else // if the player doesn't have enough money
		{
			System.out.println("Sorry, you cannot buy this item");
		}
		
		System.out.println("Thank you for visiting the store!");
	}
}
