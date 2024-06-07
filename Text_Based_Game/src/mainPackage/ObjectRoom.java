/*
 * This is the object room; it stores either an object or the special word
 * A subclass of Room
 * April 13, 2024
 * */

package mainPackage;

import java.util.Scanner;

public class ObjectRoom extends Room 
{
	private char typeOfRoom; // o = object, w = word
	private String riddle; // the riddle/problem the player has to solve
	private String[] answers; // the answers 
	private String objectStored; // what the object has 
	private boolean playerGotAnswerRight = false; // checks whether player got the answer right 
	private Scanner scan = new Scanner(System.in);
	private String playerAnswer; // the players answers
	
	public ObjectRoom(int room, int northExit, int eastExit, int southExit, int westExit, String text, char typeOfRoom, String riddle, String answers[], String objectStored) 
	{
		super(room, northExit, eastExit, southExit, westExit, text);
		this.typeOfRoom = typeOfRoom;
		this.riddle = riddle;
		this.answers = answers;
		this.objectStored = objectStored;
	}
	
	public void drawRoom()
	{
		super.drawRoom(); // generates room
		System.out.println("You have a riddle to solve to get something special:");
		System.out.println(this.riddle);
		this.playerAnswer = scan.nextLine(); // prompts user to answer
		this.checkplayerAnswer(this.playerAnswer); // checks answer
	}

	public void checkplayerAnswer(String playerAnswer)
	{
		for (int i = 0; i < this.answers.length; i++)
		{
			if (playerAnswer.toLowerCase().equals(this.answers[i])) // if the player got the question right 
			{
				this.playerGotAnswerRight = true; // this is set to true
			}
		}
		
		if(this.playerGotAnswerRight) // if the player got the answer right
		{
			this.getObject(); // they get the object
			this.drawnText = "      ";
			Driver.roomObjects[this.roomID] = new Room(this.roomID, this.northExit, this.eastExit, this.southExit, this.westExit, this.drawnText); // a new room is instantiated
		}
		
		else // if they got it right
		{
			System.out.println("Sorry, you didn't get it correct");
		}
	}
	
	public void getObject()
	{
		System.out.println("\nCongrats!");
		if (this.typeOfRoom == 'o') // if it's an object room
		{
			System.out.println("You found an object: " + this.objectStored);			
			Driver.player.addObjectToInventory(this.objectStored); // the object is added to the inventory
		}
		
		else if (this.typeOfRoom == 'w') // if it's a word room
		{
			System.out.println("You found the secret word to get out: " + this.objectStored);
		}
	}
}
