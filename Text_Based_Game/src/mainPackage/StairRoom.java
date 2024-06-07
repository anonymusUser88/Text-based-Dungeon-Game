/*
 * This is a stair room, where you can go to another floor
 * A subclass of room
 * April 14, 2024
 * */

package mainPackage;

public class StairRoom extends Room 
{
	protected int stairExit; // these rooms also have stairs as well as other exits
	
	public StairRoom(int room, int northExit, int eastExit, int southExit, int westExit, int stairExit, String text) 
	{
		super(room, northExit, eastExit, southExit, westExit, text);
		this.stairExit = stairExit;
	}
	
	// accessor method
	public int getStairExit()
	{
		return this.stairExit;
	}
}
