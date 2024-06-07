/*
 * Sethumi Hapuarachchi
 * April 22, 2024
 * ICS 4U1
 * Dungeon Game
 * Main/Driver Class
*/

package mainPackage;

import java.util.Scanner; // importing the scanner
import java.util.ArrayList; // lets me use array lists

public class Driver 
{
	static Room[] roomObjects = new Room[109]; // the array containing the rooms
	static int roomPlayerIsIn = 0; // the room the player is in
	static int gameState = 0; // game state
	static Player player = new Player(); // player
	
	public static void main (String [] args)
	{
		ArrayList<Integer> roomsPlayerVisited = new ArrayList<Integer>(); // tracks rooms player has visited
		String playerInput = "";
		boolean playerFoundRoom; // whether the player found a room
		boolean gameIsRunning = true; // I need this in order for the game to run. It doesn't work without it
		Scanner scan = new Scanner(System.in); // scanner
		
		Title.printTitle(); // printing title
		
		generateRoomObjects(); // the rooms are generated
		
		while(gameIsRunning) // while the program is running
		{
			switch(gameState)
			{
				case 0: // menu				
					playerInput = scan.nextLine(); // the program waits for input
						
					if (playerInput.equals("n") || playerInput.equals("new") || playerInput.equals("new game"))// new game
					{
						gameState = 1; // switches game state
					}
					else if (playerInput.equals("l") || playerInput.equals("load") || playerInput.equals("load game")) // saved game
					{
						SaveAndLoadFiles.loadFile(); // loads data
						gameState = 1; // switches game state
					}
					else // invalid input
					{
						System.out.println("Invalid input, try again");
					}
					break; 
						
				case 1:	// drawing rooms + other special things		
					// checks whether the player found the room 
					playerFoundRoom = false;
					
					for (int i = 0; i < roomsPlayerVisited.size(); i++)
					{
						if (roomsPlayerVisited.get(i) == roomPlayerIsIn) // if the player has visited that room (included in the list)
						{
							playerFoundRoom = true; // this variable is set to true
						}			
					}
					
					if (!playerFoundRoom) // if the player has not found the room
					{
						System.out.println("New Room Discovered!");
						roomsPlayerVisited.add(roomPlayerIsIn); // is added to the array list
					}
					roomObjects[roomPlayerIsIn].drawRoom(); // room player is in is drawn; what is done depends on what type of room it is 
					gameState = 2; // game state changes
					break;
	
				case 2: // making a decision
					playerMakesDecision(); // the player makes a decision about where to go
					break;
					
				case 3: // end screen
					Title.printTitle(); // printed when the game ends
					gameIsRunning = false; // game stops running
					break;
			}
		}
	}
	
	public static void generateRoomObjects() // creates all of the rooms
	{
		// arrays for object room answers
		String[] roomEighteenAnswers = {"hole", "a hole", "holes", "the hole", "the holes"};
		String[] roomTwentyTwoAnswers = {"cold", "a cold", "colds", "the cold", "the colds"};
		String[] roomThirtySixAnswers = {"umbrella", "umbrellas", "an umbrella", "the umbrella", "the umbrellas"};
		String[] roomSixtySixAnswers = {"dictionary", "dictionaries", "a dictionary", "the dictionary", "the dictionaries"};
		String[] roomSeventyOneAnswers = {"stamp", "a stamp", "stamps", "the stamp", "the stamps"};
		String[] roomNinetyThreeAnswers = {"a coin", "coins", "the coin", "coin", "the coins"};
		String[] roomOneHundredAndFiveAnswers = {"age", "aging", "the rain", "rain"};
		
		// first floor
		roomObjects[0] = new Room(0, 0, 1, 10, 0, "      "); // starting room, first floor
		roomObjects[1] = new Room(1, 1, 2, 11, 0, "      ");
		roomObjects[2] = new Room(2, 2, 2, 12, 1, "      ");
		roomObjects[3] = new TreasureRoom(3, 3, 4, 3, 3,  "  $$  ", 100); // treasure room
		roomObjects[4] = new Room(4, 4, 5, 14, 3, "      ");
		roomObjects[5] = new Room(5, 5, 6, 15, 4, "      ");
		roomObjects[6] = new Room(6, 6, 6, 16, 5, "      ");
		roomObjects[7] = new Room(7, 7, 8, 17, 7, "      ");
		roomObjects[8] = new Room(8, 8, 9, 8, 7, "      ");
		roomObjects[9] = new Room(9, 9, 9, 9, 9, "      "); // zero exit room
		roomObjects[10] = new Room(10, 0, 11, 20, 10, "      ");
		roomObjects[11] = new Room(11, 1, 12, 21, 10, "      ");
		roomObjects[12] = new Room(12, 2, 13, 22, 11, "      ");
		roomObjects[13] = new Room(13, 13, 14, 13, 12, "      ");
		roomObjects[14] = new Room(14, 4, 15, 24, 13, "      ");
		roomObjects[15] = new Room(15, 5, 15, 25, 14, "      ");
		roomObjects[16] = new Room(16, 6, 16, 26, 16, "      ");
		roomObjects[17] = new Room(17, 7, 18, 17, 17, "      ");
		roomObjects[18] = new ObjectRoom(18, 18, 19, 28, 17, " |__| ", 'o', "What gets bigger the more you take away?", roomEighteenAnswers, "Shield (+1 hp)"); // object room 
		roomObjects[19] = new Room(19, 9, 19, 29, 18, "      ");
		roomObjects[20] = new Room(20, 10, 21, 30, 20, "      ");
		roomObjects[21] = new Room(21, 11, 21, 31, 20, "      ");
		roomObjects[22] = new ObjectRoom(22, 12, 23, 32, 22, " |__| ", 'w', "What can you catch, but not throw?", roomTwentyTwoAnswers, "bananas"); // word room
		roomObjects[23] = new Room(23, 23, 24, 33, 22, "      ");
		roomObjects[24] = new MonsterRoom(24, 14, 25, 34, 23, "||--||", 25); // monster room
		roomObjects[25] = new Room(25, 15, 25, 35, 24, "      ");
		roomObjects[26] = new Room(26, 16, 27, 36, 26, "      ");
		roomObjects[27] = new Room(27, 27, 27, 37, 26, "      ");
		roomObjects[28] = new Room(28, 18, 28, 38, 28, "      ");
		roomObjects[29] = new Room(29, 19, 29, 39, 29, "      ");
		roomObjects[30] = new Room(30, 20, 30, 40, 30, "      ");
		roomObjects[31] = new Room(31, 21, 32, 41, 31, "      ");
		roomObjects[32] = new Room(32, 22, 32, 42, 31, "      ");
		roomObjects[33] = new Room(33, 23, 33, 43, 33, "      ");
		roomObjects[34] = new Room(34, 24, 35, 44, 34, "      ");
		roomObjects[35] = new Room(35, 25, 36, 45, 34, "      ");
		roomObjects[36] = new ObjectRoom(36, 26, 37, 46, 35, " |__| ", 'w', "What can go up a chimney down, but can’t go down a chimney up?", roomThirtySixAnswers, "bananas"); // word room
		roomObjects[37] = new Room(37, 27, 38, 37, 36, "      ");
		roomObjects[38] = new Room(38, 28, 39, 48, 37, "      ");
		roomObjects[39] = new Room(39, 29, 39, 49, 38, "      ");
		roomObjects[40] = new TreasureRoom(40, 30, 41, 50, 40,  "  $$  ", 500); // treasure room
		roomObjects[41] = new Room(41, 31, 41, 41, 40, "      ");
		roomObjects[42] = new Room(42, 32, 43, 52, 42, "      ");
		roomObjects[43] = new Room(43, 33, 44, 53, 42, "      ");
		roomObjects[44] = new Room(44, 34, 45, 54, 43, "      ");
		roomObjects[45] = new Room(45, 35, 46, 55, 44, "      ");
		roomObjects[46] = new Room(46, 36, 47, 56, 45, "      ");
		roomObjects[47] = new Room(47, 47, 47, 57, 46, "      ");
		roomObjects[48] = new Room(48, 38, 49, 58, 48, "      ");
		roomObjects[49] = new Room(49, 49, 49, 49, 49, "DANGER"); // zero exit room
		roomObjects[50] = new Room(50, 40, 51, 60, 50, "      ");
		roomObjects[51] = new Room(51, 51, 52, 51, 50, "      ");
		roomObjects[52] = new Room(52, 42, 53, 52, 51, "      ");
		roomObjects[53] = new Room(53, 53, 53, 53, 53, "DANGER"); // zero exit room
		roomObjects[54] = new Room(54, 44, 55, 54, 53, "      ");
		roomObjects[55] = new Room(55, 45, 44, 65, 54, "      ");
		roomObjects[56] = new Room(56, 46, 57, 66, 56, "      ");
		roomObjects[57] = new Room(57, 47, 57, 57, 56, "      ");
		roomObjects[58] = new Room(58, 48, 59, 68, 58, "      ");
		roomObjects[59] = new Room(59, 49, 59, 69, 58, "      ");
		roomObjects[60] = new Room(60, 50, 61, 70, 60, "      ");
		roomObjects[61] = new Room(61, 61, 61, 71, 60, "      ");
		roomObjects[62] = new Room(62, 62, 63, 62, 62, "      ");
		roomObjects[63] = new Room(63, 53, 64, 73, 62, "      ");
		roomObjects[64] = new Room(64, 64, 65, 74, 63, "      ");
		roomObjects[65] = new Room(65, 55, 66, 65, 64, "      ");
		roomObjects[66] = new ObjectRoom(66, 56, 67, 76, 65, " |__| ", 'o', "I’m the rare case when today comes before yesterday. What am I?", roomSixtySixAnswers, "Gems (-1 hp)"); // object room
		roomObjects[67] = new Room(67, 67, 67, 67, 67, "DANGER"); // zero exit room
		roomObjects[68] = new Room(68, 58, 69, 68, 68, "      ");
		roomObjects[69] = new Room(69, 59, 69, 79, 68, "      ");
		roomObjects[70] = new Room(70, 60, 71, 70, 70, "      ");
		roomObjects[71] = new ObjectRoom(71, 61, 72, 81, 70, " |__| ", 'o', "What goes all the way around the world but stays in a corner?", roomSeventyOneAnswers, "Sword (-3 hp)"); // object room
		roomObjects[72] = new Room(72, 72, 73, 72, 71, "      ");
		roomObjects[73] = new Room(73, 63, 74, 73, 72, "      ");
		roomObjects[74] = new Room(74, 64, 75, 84, 73, "      ");
		roomObjects[75] = new Room(75, 75, 75, 85, 74, "      ");
		roomObjects[76] = new Room(76, 66, 77, 76, 76, "      ");
		roomObjects[77] = new Room(77, 77, 78, 87, 76, "      ");
		roomObjects[78] = new TreasureRoom(78, 78, 79, 88, 77, "  $$  ", 400); // treasure room
		roomObjects[79] = new Room(79, 69, 79, 79, 78, "      ");
		roomObjects[80] = new Room(80, 80, 81, 80, 80, "      ");
		roomObjects[81] = new Room(81, 71, 81, 91, 80, "      ");
		roomObjects[82] = new Room(82, 82, 83, 92, 82, "      ");
		roomObjects[83] = new Room(83, 83, 83, 93, 82, "      ");
		roomObjects[84] = new Room(84, 74, 85, 94, 84, "      ");
		roomObjects[85] = new MonsterRoom(85, 75, 86, 95, 84, "||--||", 25); // monster room
		roomObjects[86] = new Room(86, 86, 86, 96, 85, "      ");
		roomObjects[87] = new Room(87, 77, 87, 97, 87, "      ");
		roomObjects[88] = new Room(88, 78, 89, 88, 88, "      ");
		roomObjects[89] = new Room(89, 89, 89, 99, 88, "      ");
		roomObjects[90] = new MonsterRoom(90, 90, 91, 90, 90, "||--||", 25); // monster room
		roomObjects[91] = new Room(91, 81, 92, 91, 90, "      ");
		roomObjects[92] = new Room(92, 82, 93, 92, 91, "      ");
		roomObjects[93] = new ObjectRoom(93, 83, 94, 93, 92, " |__| ", 'w', "What has a head and a tail, but no body?", roomNinetyThreeAnswers, "bananas"); // special word room
		roomObjects[94] = new Room(94, 84, 94, 94, 93, "      ");
		roomObjects[95] = new Room(95, 85, 96, 95, 95, "      ");
		roomObjects[96] = new Room(96, 86, 97, 96, 95, "      ");
		roomObjects[97] = new Room(97, 87, 98, 97, 96, "      ");
		roomObjects[98] = new Room(98, 98, 99, 98, 97, "      ");
		roomObjects[99] = new EndRoom(99, 89, 99, 99, 98, 100, "      ", "bananas"); // end room

		// second floor
		roomObjects[100] = new StairRoom(100, 100, 101, 103, 100, 99, "  []  "); // starting room, second floor
		roomObjects[101] = new TreasureRoom(101, 101, 102, 104, 100, "  $$  ", 400); // treasure room
		roomObjects[102] = new Room(102, 102, 102, 105, 101, "      ");
		roomObjects[103] = new Room(103, 100, 104, 106, 103, "      ");
		roomObjects[104] = new MonsterRoom(104, 101, 105, 107, 103, "||--||", 35); // monster room
		roomObjects[105] = new ObjectRoom(105, 102, 105, 108, 104, " |__| ", 'o', "What goes up but never goes down?", roomOneHundredAndFiveAnswers, "Spear (-1 hp)");
		roomObjects[106] = new Room(106, 103, 107, 106, 106, "      ");
		roomObjects[107] = new Room(107, 104, 108, 107, 106, "      ");
		roomObjects[108] = new TreasureRoom(108, 105, 108, 108, 107, "  $$  ", 300); // treasure room
	}

	public static void playerMakesDecision() // lets the player make a decision on where to go
	{
		Scanner scan = new Scanner(System.in); // scanner
		String playerInput; // the player's choice
		boolean playerMadeAChoice = false; // whether the player made a valid choice

		// dummy variables for direction
		boolean northExit = roomObjects[roomPlayerIsIn].getNorthExit() != roomPlayerIsIn;
		boolean eastExit = roomObjects[roomPlayerIsIn].getEastExit() != roomPlayerIsIn;
		boolean southExit = roomObjects[roomPlayerIsIn].getSouthExit() != roomPlayerIsIn;
		boolean westExit = roomObjects[roomPlayerIsIn].getWestExit() != roomPlayerIsIn;
		boolean stairExit = roomObjects[roomPlayerIsIn].getStairExit() != roomPlayerIsIn;
		
		// printing options
		if (!northExit && !eastExit && !southExit && !westExit && !stairExit) // if the player enters a zero exit room
		{
			gameState = 3;
		}
		
		else
		{
			while (!playerMadeAChoice) // while the player has not made a decision
			{			
				System.out.println("\nChoose an Option"); // prompts the player 
				System.out.println("Options: ");
				
				if (northExit) // if the room has an exit to a particular direction
				{
					System.out.println("    North (0)"); // It is printed as an option
				}
				
				if (eastExit)
				{
					System.out.println("    East (1)");
				}
				
				if (southExit)
				{
					System.out.println("    South (2)");
				}
				
				if (westExit)
				{
					System.out.println("    West (3)");
				}
				
				if (stairExit)
				{
					if (roomObjects[roomPlayerIsIn].getStairExit() > roomPlayerIsIn) // if the stairs go to a higher floor
					{
						System.out.println("    Upstairs (s)"); // upstairs is printed
					}
					else
					{
						System.out.println("    Downstairs (s)"); // otherwise downstairs is printed
					}
				}
				
				// other options
				System.out.println("    Inventory (i)");
				System.out.println("    Market (m)");
				System.out.println("    Quit (q)");
				System.out.println("    Save (c)");
				System.out.println("    Load (l)");
				
				playerInput = scan.nextLine(); // checks answer inputed
				System.out.println(" ");
				
				switch(playerInput)
				{
					case "0": // if the user inputs a valid direction (north)
						roomPlayerIsIn = roomObjects[roomPlayerIsIn].getNorthExit(); // the room player will go to is updated
						gameState = 1; // game state is changed
						playerMadeAChoice = true; // program knows player made a choice
						break;
					
					case "1": // east
						roomPlayerIsIn = roomObjects[roomPlayerIsIn].getEastExit();
						gameState = 1; // game state is changed
						playerMadeAChoice = true;
						break;
						
					case "2": // south
						roomPlayerIsIn = roomObjects[roomPlayerIsIn].getSouthExit();
						gameState = 1; // game state is changed
						playerMadeAChoice = true;
						break;
						
					case "3": // west
						roomPlayerIsIn = roomObjects[roomPlayerIsIn].getWestExit();
						gameState = 1; // game state is changed
						playerMadeAChoice = true;
						break;
						
					case "s": // stairs
						roomPlayerIsIn = roomObjects[roomPlayerIsIn].getStairExit();
						gameState = 1; // game state is changed
						playerMadeAChoice = true;
						break;
						
					case "i": // inventory
						player.printPlayerInventory(); // prints out inventory
						gameState = 1; // game state is changed
						break;
						
					case "m": // market
						Market.generateItems(); // generates items available
						gameState = 1; // game state is changed
						break;
						
					case "q": // quit
						playerMadeAChoice = true;
						gameState = 3; // game ends
						break;
						
					case "c": // save file
						SaveAndLoadFiles.saveFile();
						gameState = 1; // game state is changed
						break;
						
					case "l": // load file
						SaveAndLoadFiles.loadFile();
						gameState = 1;
						break;
						
					default: // invalid input
						System.out.println("\nNot a valid input."); 
						break;
					}
			}
		}
	}
}
