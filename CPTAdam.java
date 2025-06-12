// Adam Matthew H. Francisco
// Offline Blackjack
// 12 June, 2025
// Version  1.42

import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console(1000,600);
		
		// Variable for users menu option 
		char chrOption;
		
		while(true){
		
			// Background
			con.setBackgroundColor(Color.WHITE);
			
			// Options Border
			con.setDrawColor(new Color(205, 205, 205));
			con.fillRect(495, 210, 5, 185);
			
			// String options on console
			con.setDrawColor(Color.BLACK);
			con.drawString("Blackjack",532,210);
			con.drawString("Main Menu",532,240);
			con.drawString("Play [P]",532,270);
			con.drawString("Leaderboard [L]",532,300);
			con.drawString("Quit [Q]",532,330);
			con.drawString("Help [H]",532,360);
			
			// Image/ Logo
			
			BufferedImage imgPoker = con.loadImage("blackjack.png");
					con.drawImage(imgPoker, 180, 140);
			
			// New color for Hint/ assistance
			con.setDrawColor(new Color(205, 205, 205));
			con.drawString("* Type the corresponding letter to open the option", 197, 555);
			
			con.repaint();
			
			// for determining option on menu
			chrOption = con.getChar();
			System.out.println("entered letter: "+chrOption);
				
			// Play option
			if(chrOption == 'p' || chrOption == 'P'){
			
				play(con);
				
			}else if(chrOption == 'l' || chrOption == 'L'){
				
				leaderboard(con);
				
			}else if(chrOption == 'q' || chrOption == 'Q'){
				
				con.closeConsole();
				
			}else if(chrOption == 'h' || chrOption == 'H'){
				
				help(con);
				
			}
		}
	}
	
	public static void play(Console con){
	
	// Creates 2 essential integer variables for the player, being amount of money and bet amount
    int intCash = 1000;
    int intBet;
	
	// Creates a string variable to hold player name information
    String strName;

	// Sets background color
    con.setBackgroundColor(Color.BLACK);
	
	// Asks user for name
    con.println("What's your name?: ");
    strName = con.readLine();
	
	// Special case for if player names themselves "statitan"
    if(strName.equalsIgnoreCase("statitan")){
		
		// Player buff
        intCash = 5000;
        
    }
	
	// Creates boolean variable for the loop
    boolean blnPlaying = true;
	
	// Starts the playing loop
    while (blnPlaying){
		
		// Gives intBet an amount indicated by the player
        con.println("You will start off with $" + intCash);
        con.println("How much would you like to bet?");
        intBet = con.readInt();
		
		// Special case for if player places an invalid bet (ie. more money than they have OR less than or equal to 0)
        while (intBet > intCash || intBet <= 0){
			
            con.println("You can't bet that much");
            con.println("How much would you like to bet?");
            intBet = con.readInt();
            
        }
		
		// Clears the screen for the game
        con.clear();
		
		// Connects to the method deck for cards
        int[][] intDeck = CPTAdamMethods.deck();
		
		// Creates the 5x2 array for dealer and the player
        int[][] intPlayer = new int[5][2];
        int[][] intDealer = new int[5][2];
        
        // Creates the intDeckPos variable to check for what position the deck is in, along with dealing cards
        int intDeckPos = 0;
		
		// Deals players first card
        intPlayer[0][0] = intDeck[intDeckPos][0];
        intPlayer[0][1] = intDeck[intDeckPos][1];
        intDeckPos = intDeckPos + 1;
		
		// Deals players second card
        intPlayer[1][0] = intDeck[intDeckPos][0];
        intPlayer[1][1] = intDeck[intDeckPos][1];
        intDeckPos = intDeckPos + 1;

		// Deals dealers first card
        intDealer[0][0] = intDeck[intDeckPos][0];
        intDealer[0][1] = intDeck[intDeckPos][1];
        intDeckPos = intDeckPos + 1;
		
		// Creates string arrays for naming cards
        String[] strSuits = { "Diamonds", "Clubs", "Hearts", "Spades" };
        String[] strValues = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		
		// Prints out players cards
        con.println();
        con.println("Your cards:");
        con.println(strValues[intPlayer[0][0]] + " of " + strSuits[intPlayer[0][1]]);
        con.println(strValues[intPlayer[1][0]] + " of " + strSuits[intPlayer[1][1]]);
        con.println();
		
		// Prints out dealers cards
        con.println("Dealer shows:");
        con.println(strValues[intDealer[0][0]] + " of " + strSuits[intDealer[0][1]]);
        con.println();
		
		// Creates variable for checking how much cards the player and dealer have
        int intPlayerCardCount = 2;
        int intDealerCardCount = 1;
		
		// Uses the handvalue method to check how much the players hand is worth
        int intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
		
		// Creates rare blackjack start occurrence
        if(intplayerHandValue == 21){
			
			// Gives a response to winning in such fashion, along with printing current money amount
            con.println("Blackjack! You instantly win 3x your bet!");
            intCash = intCash + (intBet * 3);
            con.println("You now have $" + intCash);
			
			// Asks user if they would like to play another round
            con.println("Do you want to play again? (Y/N)");
            char playAgain = con.getChar();
			
			// Starts the if statement for each case
            if(playAgain == 'n' || playAgain == 'N'){
				
				// If player presses no, the boolean for playing turns false ending the loop
                blnPlaying = false;
				
				// Prompts user to enter a key to return to the main menu
                con.println("Press any key to return to main menu.");
                con.getChar();
				
				// Clears screen so main menu is not obstructed
                con.clear();
				
				// Loads up text file for writing
                TextOutputFile leaderboardfile = new TextOutputFile("leaderboard.txt", true);
                
                // Loads in information
                leaderboardfile.println(strName);
                leaderboardfile.println(intCash);
                
                // Closes file
                leaderboardfile.close();

                return;
			
			// Else if for the case that the player clicks yes
            }else if(playAgain == 'y' || playAgain == 'Y'){
				
				// Loop says true
                blnPlaying = true;
			
			// Else for the case that use presses a random letter
            }else{

                con.println("Invalid input, returning to main menu.");
                blnPlaying = false;

            }
			
			// If statement for if the player has no money
            if (intCash == 0) {
				
				// Prints out a response
                con.println("You lost all your money!");

            }

        }
		
		// Boolean variable for when in play
        boolean blnInHand = true;

		// Starts while loop for when player either hits or stands
        while (blnInHand){
			
			// Calculates hand values of both the player and dealer
            intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
            int intdealerHandValue = CPTAdamMethods.handvalue(intDealer, intDealerCardCount);
			
			// Displays the current hand value for the player
            con.println();
            con.println("Your current hand value: " + intplayerHandValue);
			
			// Creates if statement for rare occurrence of a double down
            if (intPlayerCardCount == 2 && (intplayerHandValue == 9 || intplayerHandValue == 10 || intplayerHandValue == 11)){
				
				// Different statement is printed out
                con.println("Press [H] to Hit, [S] to Stand, or [D] to Double Down");
                
            // Statement for if a double down does not occur
            }else{
				
				// Standard statement
                con.println("Press [H] to Hit or [S] to Stand");
                
            }
			
			// Checks for what user inputs
            char choice = con.getChar();
			
			// Hit scenario
            if(choice == 'h' || choice == 'H'){

				// Draws the next card
                intPlayer[intPlayerCardCount][0] = intDeck[intDeckPos][0];
                intPlayer[intPlayerCardCount][1] = intDeck[intDeckPos][1];
                
                // Adds to tracking variables
                intDeckPos = intDeckPos + 1;
                intPlayerCardCount = intPlayerCardCount + 1;
				
				// Tells player what card is drawn
                con.println("You drew: " + strValues[intPlayer[intPlayerCardCount-1][0]] + " of " + strSuits[intPlayer[intPlayerCardCount-1][1]]);

				// Uses methos to calculate new hand value
                intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
                
                // 5 Card occurrence 
                if (intPlayerCardCount == 5 && intplayerHandValue <= 21){
					
					con.println("Five Card Charlie! You win 3x your bet!");
					intCash = intCash + (intBet * 3);
					
					con.println("You now have $" + intCash);
					con.println("Press any key to continue.");
					con.getChar();
					blnInHand = false;
					continue;
					
				}
                
                // Bust case scenario
                if(intplayerHandValue > 21){
					
                    con.println("You busted with " + intplayerHandValue + "!");
                    intCash = intCash - intBet;
                    
                    // Ends play
                    blnInHand = false;
                    
                }
			
			// Stand scenario
            }else if(choice == 's' || choice == 'S'){
				
				//Keeps hitting while card value is under 17
                while(CPTAdamMethods.handvalue(intDealer, intDealerCardCount) < 17){
					
					//Draws dealers cards
                    intDealer[intDealerCardCount][0] = intDeck[intDeckPos][0];
                    intDealer[intDealerCardCount][1] = intDeck[intDeckPos][1];
                    
                    // Adds to tracking variables
                    intDeckPos = intDeckPos + 1;
                    intDealerCardCount = intDealerCardCount + 1;
                    
                }
                
                // 5 card scenario for the dealer
                if (intDealerCardCount == 5 && CPTAdamMethods.handvalue(intDealer, intDealerCardCount) <= 21){
					
					con.println("Dealer drew 5 cards without busting. Dealer wins automatically!");
					intCash = intCash - intBet;
					blnInHand = false;
					continue;
					
				}
				
				// Calculates hand values
                intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
                intdealerHandValue = CPTAdamMethods.handvalue(intDealer, intDealerCardCount);
				
				// Prints out dealers hand
                con.println("Dealer's hand:");
                for(int intCount = 0; intCount < intDealerCardCount; intCount++){
					
                    con.println(strValues[intDealer[intCount][0]] + " of " + strSuits[intDealer[intCount][1]]);
                    
                }
				
				// Prints out both hand values
                con.println("Your hand value: " + intplayerHandValue);
                con.println("Dealer's hand value: " + intdealerHandValue);
				
				// Win scenario
                if(intdealerHandValue > 21 || intplayerHandValue > intdealerHandValue){
					
                    con.println("You win!");
                    intCash = intCash + intBet;
                
                // Push Scenario   
                }else if(intplayerHandValue == intdealerHandValue){
					
                    con.println("Push. Your bet is returned.");
                
                // Lose scenario   
                }else{
					
                    con.println("You lose.");
                    intCash = intCash - intBet;
                    
                }
				
				// Ends in hand boolean
                blnInHand = false;
			
			// Double down scenario
            }else if((choice == 'd' || choice == 'D') && intPlayerCardCount == 2 && (intplayerHandValue == 9 || intplayerHandValue == 10 || intplayerHandValue == 11)){
				
				// Checks if user can double down given how much cash they have
                if(intCash >= intBet * 2){
					
					// Doubles bet
                    intBet = intBet * 2;
                    
                    // Draws a new card
                    intPlayer[intPlayerCardCount][0] = intDeck[intDeckPos][0];
                    intPlayer[intPlayerCardCount][1] = intDeck[intDeckPos][1];
                    
                    // Adds to tracking variables
                    intDeckPos = intDeckPos + 1;
                    intPlayerCardCount = intPlayerCardCount + 1;
					
					// Shows player what they drew
                    con.println("You drew: " + strValues[intPlayer[intPlayerCardCount-1][0]] + " of " + strSuits[intPlayer[intPlayerCardCount-1][1]]);
					
					// Calculates hand value
                    intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
                    
                        while(CPTAdamMethods.handvalue(intDealer, intDealerCardCount) < 17){
							
							// Draws dealers cards
                            intDealer[intDealerCardCount][0] = intDeck[intDeckPos][0];
                            intDealer[intDealerCardCount][1] = intDeck[intDeckPos][1];
                            
                            // Adds to tracking variables
                            intDeckPos = intDeckPos + 1;
                            intDealerCardCount = intDealerCardCount + 1;
                            
                        }
						
						// Checks for dealers hand value
                        intdealerHandValue = CPTAdamMethods.handvalue(intDealer, intDealerCardCount);
                        con.println("Dealer's hand:");
                        
                        // Prints dealers hand
                        for(int intCount2 = 0; intCount2 < intDealerCardCount; intCount2++){
							
                            con.println(strValues[intDealer[intCount2][0]] + " of " + strSuits[intDealer[intCount2][1]]);
                            
                        }
						
						// Win scenario
                        if(intdealerHandValue > 21 || intplayerHandValue > intdealerHandValue){
							
                            con.println("You win!");
                            intCash = intCash + intBet;
                        
                        // Push scenario    
                        }else if(intplayerHandValue == intdealerHandValue){
							
                            con.println("Push. Your bet is returned.");
                        
                        // Loss scenario    
                        }else{
							
                            con.println("You lose.");
                            intCash = intCash - intBet;
                            
                        }
                    // Case in which you dont have money to double down
                    }else{
					
                    con.println("You don't have enough money to double down.");
                    
					}
                    
                    // Ends bln in hand while loop
                    blnInHand = false;
            
            // Case in which player provides invalid input    
            }else{
				
                con.println("Invalid input.");
                
            }
        }
		
		con.println("You now have $" + intCash);
		
		// If player has no money, end the game
        if (intCash <= 0){
			
			// Response to case scenario
            con.println("You're out of money! Game over.");
            blnPlaying = false;
            
            con.println("Press any key to return to main menu.");
            con.getChar();
			
			// Clear screen
            con.clear();

			// Add user to leaderboard
            TextOutputFile leaderboardfile = new TextOutputFile("leaderboard.txt", true);
            leaderboardfile.println(strName);
            leaderboardfile.println(intCash);
            leaderboardfile.close();
            
            return;
        }
		
		// Prompts user for another turn
        con.println("Do you want to play again? (Y/N)");
        
        // Checks user response
        char playAgain = con.getChar();
		
		// If no, end blnPlaying loop 
        if(playAgain == 'n' || playAgain == 'N'){
            blnPlaying = false;
			
			// Tell user to exit to main menu with any button press
            con.println("Press any key to return to main menu.");
            con.getChar();
			
			// Clear screen
            con.clear();

			// Add user to leaderboard
            TextOutputFile leaderboardfile = new TextOutputFile("leaderboard.txt", true);
            leaderboardfile.println(strName);
            leaderboardfile.println(intCash);
            leaderboardfile.close();
        }
    }
}

	
	public static void leaderboard(Console con){
	
		// Creates all variables
		int intLineCounter;
		int intPlayerCount;
		int intCount;
		int intCount2;
		int intCount3;
		int intMoneyTemp1;
		int intMoneyTemp2;
		String strTempName;
		String strTempMoney;
		int intCount4;
		
		// Changes background color for a fresh look instead of the black
		con.setBackgroundColor(Color.WHITE);
		con.setTextColor(Color.BLACK);
		
		// Calls new leaderboard for reading
		TextInputFile leaderboardfile = new TextInputFile("leaderboard.txt");
		
		// Starts line counter
		intLineCounter = 0;
		
		// Starts loop for checking how many lines are in the file
		while (!leaderboardfile.eof()){
			
			leaderboardfile.readLine();
			intLineCounter = intLineCounter + 1;
			
		}
		
		// Closes file
		leaderboardfile.close();

		// Divides line counter by 2 as names will be printed as "name - cash" instead of cash being beneath
		intPlayerCount = intLineCounter / 2;

		// Creates new array
		String[][] strLeaderboardData = new String[intPlayerCount][2];
		
		// Reads file
		leaderboardfile = new TextInputFile("leaderboard.txt");
		
		// Counts by amount of players
		for (intCount = 0; intCount < intPlayerCount; intCount ++){
			
			// Stores data
			strLeaderboardData[intCount][0] = leaderboardfile.readLine();  
			strLeaderboardData[intCount][1] = leaderboardfile.readLine(); 
			 
		}
		
		// Closes file
		leaderboardfile.close();

		for (intCount2 = 0; intCount2 < intPlayerCount - 1; intCount2 ++){
			
			for (intCount3 = 0; intCount3 < intPlayerCount - 1 - intCount2; intCount3 ++){
				
				// Turns string to integer for comparison
				intMoneyTemp1 = Integer.parseInt(strLeaderboardData[intCount3][1]);
				intMoneyTemp2 = Integer.parseInt(strLeaderboardData[intCount3 + 1][1]);
				
				if (intMoneyTemp1 < intMoneyTemp2){
					
					// Swaps name
					strTempName = strLeaderboardData[intCount3][0];
					strLeaderboardData[intCount3][0] = strLeaderboardData[intCount3 + 1][0];
					strLeaderboardData[intCount3 + 1][0] = strTempName;

					// Swaps Money
					strTempMoney = strLeaderboardData[intCount3][1];
					strLeaderboardData[intCount3][1] = strLeaderboardData[intCount3 + 1][1];
					strLeaderboardData[intCount3 + 1][1] = strTempMoney;
				}
			}
		}
		
		// Small design
		con.println("=== Blackjack Leaderboard ===");
		con.println();
		
		// Prints listing number, name, and money
		for (intCount4 = 0; intCount4 < intPlayerCount; intCount4++) {
			con.println((intCount4 + 1) + ". " + strLeaderboardData[intCount4][0] + " - $" + strLeaderboardData[intCount4][1]);
		}
		
		//Prompts to return to main menu
		con.println();
		con.println("Press any key to return to main menu.");
		con.getChar();
		
		//Clears screen
		con.clear();
	
	}
	
	public static void help(Console con) {
		while(true){
			
			// White to match main menu, and leaderboard
			con.setBackgroundColor(Color.WHITE);
			
			//clears previous images and drawings
			con.clear();
        
			// Added Image
			BufferedImage imgAces = con.loadImage("Aces.png");
			con.drawImage(imgAces, 300, 0);
			
			// Created text for options
			con.setDrawColor(Color.BLACK);
			con.drawString("HELP MENU",445,380);
			con.drawString("[R] Rules",445,460);    
			con.drawString("[C] Card Values",445,490);
			con.drawString("[Q] Main Menu",445,520);
			
			// Secret menu for meme
			con.setDrawColor(new Color(250, 250, 250));
			con.drawString("[S] ???",445,550);        
			
			// Divider
			con.setDrawColor(new Color(205, 205, 205));
			con.fillRect(400, 430, 200, 5);
			
			// Repaints so the drawing does not need to load
			con.repaint();
			
			// Checks option of player
			char chrOption2 = con.getChar();
			System.out.println("entered letter: "+chrOption2);
			
			// Goes to rules page
			if(chrOption2 == 'r' || chrOption2 == 'R'){
				
				con.setBackgroundColor(Color.WHITE);
				
				// Clears background
				con.clear();
				
				// Loads rules image
				BufferedImage imgRules = con.loadImage("Rules.png");
				con.drawImage(imgRules, 0, 0);
				
				// Repaints
				con.repaint();

				// Goes back to main menu no matter what key they press
				con.getChar();
			
			// Card Values option
			}else if(chrOption2 == 'c' || chrOption2 == 'C'){
				
				//New background color
				con.setBackgroundColor(new Color(131,203,123));
				
				// Clears previous images
				con.clear();

				// Loads card values image to the game
				BufferedImage imgValue = con.loadImage("CardValues.png");
				con.drawImage(imgValue, 100, 0);
				
				// Repaints
				con.repaint();
				
				// Goes back to main menu no matter what key they press
				con.getChar();
			
			// Secret Menu option
			}else if(chrOption2 == 's' || chrOption2 == 'S'){
				
				con.setBackgroundColor(Color.WHITE);
				
				// Clears previous drawings
				con.clear();
				
				// Loads in meme
				BufferedImage imgMeme = con.loadImage("Meme.png");
				con.drawImage(imgMeme, 0, 0);
				
				// Repaints
				con.repaint();
				
				// Goes back to main menu no matter what key they press
				con.getChar();
			
			// Quit to menu option
			}else if(chrOption2 == 'q' || chrOption2 == 'Q'){
				
				// Clears previous drawings
				con.clear();
				
				return;
			}

		}
	}
}
