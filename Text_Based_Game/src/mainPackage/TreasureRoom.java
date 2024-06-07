/*
 * This is the treasure room; a room where the player can get treasure
 * A subclass of Room
 * April 14, 2024
 * */

package mainPackage;

public class TreasureRoom extends Room 
{
	private int amountOfMoney; // amount of money room stores
	
	public TreasureRoom(int room, int northExit, int eastExit, int southExit, int westExit, String text, int money) 
	{
		super(room, northExit, eastExit, southExit, westExit, text);
		this.amountOfMoney = money;
	}
	
	public void drawRoom()
	{
		super.drawRoom(); // draws the room
		this.giveMoney(); // prints the money
		this.drawnText = "      ";
		Driver.roomObjects[this.roomID] = new Room(this.roomID, this.northExit, this.eastExit, this.southExit, this.westExit, this.drawnText); // instantiates a new room
	}
	
	public void giveMoney()
	{
		System.out.println("You found $" + this.amountOfMoney + "!");
		Driver.player.setPlayerMoney(this.amountOfMoney);
	}
}
