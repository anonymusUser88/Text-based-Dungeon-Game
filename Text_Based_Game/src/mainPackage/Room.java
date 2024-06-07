/*
 * This is the basic room class
 * April 13, 2024
 * */

package mainPackage;

public class Room 
{
	protected int roomID; // the number of the room
	// the exits of the room
	protected int northExit;
	protected int eastExit; 
	protected int southExit;
	protected int westExit;
	protected String drawnText; // this is the text that is drawn in the room 
	
	public Room(int room, int northExit, int eastExit, int southExit, int westExit, String text)
	{
		this.roomID = room;
		this.northExit = northExit;
		this.eastExit = eastExit;
		this.southExit = southExit;
		this.westExit = westExit;
		this.drawnText = text;
	}
	
	public void drawRoom() // draws a room
	{
		// depending on the values inputed for exits, a room is drawn
		if (this.northExit != this.roomID && this.eastExit != this.roomID && this.southExit != this.roomID && this.westExit != this.roomID) // four exits
		{
			System.out.println("-------------------------------");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|`````````           `````````|");
			System.out.println("|           "+this.drawnText+"            |");
			System.out.println("|                             |");
			System.out.println("|`````````           `````````|");        
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("-------------------------------");
		}

		// 3 exit rooms
		else if (this.northExit != this.roomID && this.eastExit != this.roomID && this.southExit != this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           `````````|");			
			System.out.println("|        |  "+this.drawnText+"            |");
			System.out.println("|        |                    |");
			System.out.println("|        |           `````````|");        
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("------------------------------|");
		}
		
		else if (this.northExit == this.roomID && this.eastExit != this.roomID && this.southExit != this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|`````````````````````````````|");
			System.out.println("|                             |");			
			System.out.println("|          "+this.drawnText+"             |");
			System.out.println("|                             |");
			System.out.println("|`````````           `````````|");        
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit != this.roomID && this.eastExit == this.roomID && this.southExit != this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|````````            |        |");			
			System.out.println("|          "+this.drawnText+"    |        |");
			System.out.println("|                    |        |");
			System.out.println("|````````            |        |");        
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit != this.roomID && this.eastExit != this.roomID && this.southExit == this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|````````             ````````|");			
			System.out.println("|                             |");
			System.out.println("|          "+this.drawnText+"             |");     
			System.out.println("|                             |");
			System.out.println("|`````````````````````````````|");   
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("-------------------------------");
		}
		
		// 2 exit rooms
		
		else if (this.northExit != this.roomID && this.eastExit == this.roomID && this.southExit != this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |  "+this.drawnText+"   |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("-------------------------------");
		}	
		
		else if (this.northExit == this.roomID && this.eastExit != this.roomID && this.southExit == this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                              ");
			System.out.println("|                              ");
			System.out.println("|                              ");
			System.out.println("|``````````````````````````````");
			System.out.println("|                              ");
			System.out.println("|          "+this.drawnText+"              ");
			System.out.println("|                              ");
			System.out.println("|                              ");
			System.out.println("|``````````````````````````````");
			System.out.println("|                              ");
			System.out.println("|                              ");
			System.out.println("|                              ");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit == this.roomID && this.eastExit != this.roomID && this.southExit != this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("|  |``````````````````````````|");
			System.out.println("|  | "+this.drawnText+"                   |");
			System.out.println("|  |                          |");
			System.out.println("|  |      |```````````````````|");
			System.out.println("|  |      |                   |");
			System.out.println("|  |      |                   |");
			System.out.println("|  |      |                   |");
			System.out.println("|  |      |                   |");
			System.out.println("|  |      |                   |");
			System.out.println("|  |      |                   |");
			System.out.println("|  |      |                   |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit != this.roomID && this.eastExit != this.roomID && this.southExit == this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|  |     |                    |");
			System.out.println("|  |     |                    |");
			System.out.println("|  |     |                    |");
			System.out.println("|  |     |                    |");
			System.out.println("|  |     |                    |");
			System.out.println("|  |     |                    |");
			System.out.println("|  |     |                    |");
			System.out.println("|  |      ````````````````````|");
			System.out.println("|  | "+this.drawnText+"                   |");
			System.out.println("|  |                          |");
			System.out.println("|  ```````````````````````````|");
			System.out.println("|                             |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit == this.roomID && this.eastExit == this.roomID && this.southExit != this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("|```````````````````````````  |");
			System.out.println("|                   "+this.drawnText+" |  |");
			System.out.println("|                          |  |");
			System.out.println("|`````````````````````     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("|                    |     |  |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit != this.roomID && this.eastExit == this.roomID && this.southExit == this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                   |      |  |");
			System.out.println("|                   |      |  |");
			System.out.println("|                   |      |  |");
			System.out.println("|                   |      |  |");
			System.out.println("|                   |      |  |");
			System.out.println("|                   |      |  |");
			System.out.println("|                   |      |  |");
			System.out.println("|````````````````````      |  |");
			System.out.println("|                  "+this.drawnText+"  |  |");
			System.out.println("|                          |  |");
			System.out.println("|```````````````````````````  |");
			System.out.println("|                             |");
			System.out.println("-------------------------------");
		}
		
		// 1 exit rooms
		
		else if (this.northExit != this.roomID && this.eastExit == this.roomID && this.southExit == this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |  "+this.drawnText+"   |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        `````````````        |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit == this.roomID && this.eastExit == this.roomID && this.southExit != this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|        `````````````        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |  "+this.drawnText+"   |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("|        |           |        |");
			System.out.println("-------------------------------");
		}	
		
		else if (this.northExit == this.roomID && this.eastExit != this.roomID && this.southExit == this.roomID && this.westExit == this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|               |`````````````|");
			System.out.println("|               |             |");
			System.out.println("|               | "+this.drawnText+"      |");
			System.out.println("|               |             |");
			System.out.println("|               |             |");
			System.out.println("|               ``````````````|");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("-------------------------------");
		}
		
		else if (this.northExit == this.roomID && this.eastExit == this.roomID && this.southExit == this.roomID && this.westExit != this.roomID)
		{
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|```````````````|             |");
			System.out.println("|               |             |");
			System.out.println("|       "+this.drawnText+"  |             |");
			System.out.println("|               |             |");
			System.out.println("|               |             |");
			System.out.println("|````````````````             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("|                             |");
			System.out.println("-------------------------------");
		}
		
		// 0 exits room
		else 
		{
			System.out.println("-------------------------------");
			System.out.println("|  -------------------------  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |        "+this.drawnText+"         |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  |                       |  |");
			System.out.println("|  -------------------------  |");
			System.out.println("-------------------------------");
		}
	}

	// accessor methods
	public int getStairExit()
	{
		return this.roomID;
	}
	
	public int getNorthExit() 
	{
		return this.northExit;
	}
	
	public int getEastExit() 
	{
		return this.eastExit;
	}
	
	public int getSouthExit() 
	{
		return this.southExit;
	}
	
	public int getWestExit() 
	{
		return this.westExit;
	}
}
