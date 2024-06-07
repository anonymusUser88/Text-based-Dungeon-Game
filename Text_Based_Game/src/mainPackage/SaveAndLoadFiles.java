/*
 * Lets a user save or load a file
 * April 22, 2024
 *
 * What is saved
 * - room player is in
 * - health
 * - amount of money
 * - inventory
 * */

package mainPackage;

// importing things
import java.util.Scanner;
import java.io.*;

public class SaveAndLoadFiles 
{
	static String playerInput = " "; // the player's input
	static Scanner scan = new Scanner(System.in); // scanner

	// variables for reading and writing from text files 
	static File playerFile;
	static FileReader fr;
	static FileWriter fw;
	static BufferedReader br;
	static BufferedWriter bw;
	static boolean userChoseFile = false; // checks whether program is finished copying ALL info from file
	static boolean finishedCopyingInventory = false; // used for loading inventory
	static int i; // for parsing integers from file
	static String s; // for copying data to file
	
	public static void saveFile() // saving a file
	{
		System.out.println("What would you like to name the file?");
		playerInput = scan.nextLine(); // prompts user for name
		
		try 
		{
			playerFile = new File(playerInput + ".txt"); // creating a new file with user's name
			// creating a file & buffered writer
			fw = new FileWriter(playerFile);
			bw = new BufferedWriter(fw);
			
			// writing the data
			s = "" + Driver.roomPlayerIsIn + ""; // quotes are put at ends to make it a string
			bw.write(s+"\n");
			s = "" + Driver.player.getPlayerHealth() + "";
			bw.write(s+"\n");
			s = "" + Driver.player.getPlayerMoney() + "";
			bw.write(s+"\n");
			
			for (int i = 1; i < Driver.player.getPlayerInventory().size(); i++) // it starts at one since stick (0th item) is automatically added in the beginning of the game
			{
				s = Driver.player.getPlayerInventory().get(i);
				bw.write(s+"\n");
			}
			
			bw.close(); // closing the writer
			
			System.out.println("File successfully saved!");
		} 
		
		catch (IOException e) // if something goes wrong
		{
			System.out.println("Error in saving file; sorry :(");
		}
	}
	
	public static void loadFile()
	{
		while(!userChoseFile) // while the user hasn't chosen a file
		{
			System.out.println("Input name of save file");
			
			playerInput = scan.nextLine(); // checks user's answer
			playerFile = new File(playerInput+".txt");
			
			try // tries to read the file
			{
				fr = new FileReader(playerFile);
				br = new BufferedReader(fr);
		
				// setting up data 
				i = Integer.parseInt(br.readLine());  
				Driver.roomPlayerIsIn = i;
				i = Integer.parseInt(br.readLine()); 
				Driver.player.setPlayerHealth(i);
				i = Integer.parseInt(br.readLine()); 
				Driver.player.setPlayerMoney(i);
				
				while(!finishedCopyingInventory) // for copying the inventory over
				{
					try // the program tries to add what it reads to the inventory
					{
						Driver.player.addObjectToInventory(br.readLine());
					}
					catch(NullPointerException e) // if there is nothing
					{
						finishedCopyingInventory = true; // user is kicked out of the loop
						Driver.player.getPlayerInventory().remove(null); // 'null' is removed from inventory
					}
				}
				
				br.close(); // closes the reader
				
				userChoseFile = true; // the user chose a file
				
				System.out.println("File successfully loaded!");
			} 
			
			catch (IOException e) // if something is wrong with the file (i.e. it doesn't exist)
			{
				System.out.println("Not a valid file\n");
			}
		}
	}
}
