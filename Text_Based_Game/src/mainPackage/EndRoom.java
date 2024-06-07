/*
 * The room where you enter the word to escape
 * A subclass of stair room
 * April 20, 2024
 * */

package mainPackage;

import java.util.Scanner;

public class EndRoom extends StairRoom 
{
	private Scanner scan = new Scanner(System.in); // scanner
	private String playerAnswer; // the player's input
	private String roomAnswer; // the room's answer
	private boolean playerMadeChoice = false; // tracks whether the player made a choice
	

	public EndRoom(int room, int northExit, int eastExit, int southExit, int westExit, int stairExit, String text, String roomAnswer) 
	{
		super(room, northExit, eastExit, southExit, westExit, stairExit, text);
		this.stairExit = room; // the stairs should not be available at first, so they are equal to the room
		this.roomAnswer = roomAnswer; 
	}
	
	public void drawRoom()
	{
		super.drawRoom(); // room is drawn
		System.out.println("You have reached the end room. What is the special word?");
		this.playerAnswer = this.scan.nextLine(); // prompts the player to give an answer
		
		if (this.playerAnswer.equals(this.roomAnswer)) // if the player enters the correct word
		{
			System.out.println("You got it correct! You can go to the next floor or quit");
			System.out.println("What do you want to do? Quit or play?");
			while (!playerMadeChoice) // while the player has not answered
			{
				this.playerAnswer = scan.nextLine(); // prompts player for answer
				if (this.playerAnswer.toLowerCase().equals("quit")) // if they typed quit 
				{
					playerMadeChoice = true; // the program knows player made choice
					Driver.gameState = 3; // the game ends
				}
				else if (this.playerAnswer.toLowerCase().equals("play")) // if they typed play
				{
					playerMadeChoice = true; // program knows player answered
					this.stairExit = this.roomID+1; // stair exit is changed
					this.drawnText = "  []  "; // now the stairs appear
					Driver.roomObjects[this.roomID] = new StairRoom(this.roomID, this.northExit, this.eastExit, this.southExit, this.westExit, this.stairExit, this.drawnText); // reinstantiated as a regular stairs room 
				}
				else // if they input something else
				{
					System.out.println("Not a valid answer. Try again");
				}
			}
		}
		
		else // if they got the special word wrong
		{
			System.out.println("You did not get the word. You must stay on this floor");
		}
	}
}
