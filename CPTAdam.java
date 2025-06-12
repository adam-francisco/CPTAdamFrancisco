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
		
    int intCash = 1000;
    int intBet;
    
    String strName;

    con.setBackgroundColor(Color.BLACK);
    
    con.println("What's your name?: ");
    strName = con.readLine();

    if(strName.equalsIgnoreCase("statitan")){
        intCash = 2500;
    }

    boolean blnPlaying = true;

    while (blnPlaying){
		
        con.println("You will start off with $" + intCash);
        con.println("How much would you like to bet?");
        intBet = con.readInt();

        while (intBet > intCash || intBet <= 0){
            con.println("You can't bet that much");
            con.println("How much would you like to bet?");
            intBet = con.readInt();
        }
        
        con.clear();

        int[][] intDeck = CPTAdamMethods.deck();

        int[][] intPlayer = new int[5][2];
        int[][] intDealer = new int[5][2];
        int intDeckPos = 0;

        intPlayer[0][0] = intDeck[intDeckPos][0];
        intPlayer[0][1] = intDeck[intDeckPos][1];
        intDeckPos = intDeckPos + 1;

        intPlayer[1][0] = intDeck[intDeckPos][0];
        intPlayer[1][1] = intDeck[intDeckPos][1];
        intDeckPos = intDeckPos + 1;

        intDealer[0][0] = intDeck[intDeckPos][0];
        intDealer[0][1] = intDeck[intDeckPos][1];
        intDeckPos = intDeckPos + 1;

        String[] strSuits = { "Diamonds", "Clubs", "Hearts", "Spades" };
        String[] strValues = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

        con.println();
        con.println("Your cards:");
        con.println(strValues[intPlayer[0][0]] + " of " + strSuits[intPlayer[0][1]]);
        con.println(strValues[intPlayer[1][0]] + " of " + strSuits[intPlayer[1][1]]);
        con.println();
        
        con.println("Dealer shows:");
        con.println(strValues[intDealer[0][0]] + " of " + strSuits[intDealer[0][1]]);
        con.println();
        
        int intPlayerCardCount = 2;
		int intDealerCardCount = 1;
		
		int intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);


		if(intplayerHandValue == 21){
			
			con.println("Blackjack! You instantly win 3x your bet!");
			intCash = intCash + (intBet * 3);
			con.println("You now have $" + intCash);
			
			con.println("Press any key to return to the main menu...");
			con.getChar();
			con.clear();
			return;
		}
				
        boolean blnInHand = true;

        while (blnInHand){
			
			intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
			int intdealerHandValue = CPTAdamMethods.handvalue(intDealer, intDealerCardCount);
			
			con.println();
			con.println("Your current hand value: " + intplayerHandValue);
			
            if (intPlayerCardCount == 2 && (intplayerHandValue == 9 || intplayerHandValue == 10 || intplayerHandValue == 11)){
				
				con.println("Press [H] to Hit, [S] to Stand, or [D] to Double Down");
			}else{
				
				con.println("Press [H] to Hit or [S] to Stand");
			}
            
            char choice = con.getChar();

            if(choice == 'h' || choice == 'H'){
                con.println("You chose to Hit.");
                
				intPlayer[intPlayerCardCount][0] = intDeck[intDeckPos][0];
				intPlayer[intPlayerCardCount][1] = intDeck[intDeckPos][1];
				intDeckPos = intDeckPos + 1;
				intPlayerCardCount = intPlayerCardCount + 1;

				con.println("You drew: " + strValues[intPlayer[intPlayerCardCount - 1][0]] + " of " + strSuits[intPlayer[intPlayerCardCount - 1][1]]);

				intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
				con.println("Your hand value is now: " + intplayerHandValue);

				if(intplayerHandValue > 21){
					
					con.println("Bust! You exceeded 21. You lose your bet.");
					intCash = intCash - intBet;
					
					con.println("You have $" + intCash + " remaining.");
					con.println("Press any key to return to main menu.");
					con.getChar();
					
					con.clear();
					
					return;
				}
                
            }else if(choice == 's' || choice == 'S'){
				
                con.println("You chose to Stand.");

				intDealer[1][0] = intDeck[intDeckPos][0];
				intDealer[1][1] = intDeck[intDeckPos][1];
				intDeckPos = intDeckPos + 1;

				intDealerCardCount = 2;

				con.println("Dealer reveals:");
				con.println(strValues[intDealer[1][0]] + " of " + strSuits[intDealer[1][1]]);


				while(CPTAdamMethods.handvalue(intDealer, intDealerCardCount) < 17 && intDealerCardCount < 5){
					
					intDealer[intDealerCardCount][0] = intDeck[intDeckPos][0];
					intDealer[intDealerCardCount][1] = intDeck[intDeckPos][1];
					con.println("Dealer draws: " + strValues[intDealer[intDealerCardCount][0]] + " of " + strSuits[intDealer[intDealerCardCount][1]]);
					
					intDeckPos = intDeckPos + 1;
					intDealerCardCount = intDealerCardCount + 1;
				}

				int intPlayerTotal = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
				int intDealerTotal = CPTAdamMethods.handvalue(intDealer, intDealerCardCount);

				con.println();
				con.println("Your total: " + intPlayerTotal);
				con.println("Dealer total: " + intDealerTotal);


				if(intDealerTotal > 21){
					
					con.println("Dealer busts! You win!");
					intCash = intCash + intBet;
					con.println("You now have $" + intCash);
					
				}else if(intDealerTotal > intPlayerTotal){
					
					con.println("Dealer wins.");
					intCash = intCash - intBet;
					
				}else if(intDealerTotal < intPlayerTotal){
					
					con.println("You win!");
					intCash = intCash + intBet;
					con.println("You now have $" + intCash);

				}else{
					
					con.println("Push! It's a tie.");
					
				}

				con.println("Press any key to return to the main menu...");
				con.getChar();

				con.clear();
				
				return;
				
			}else if((choice == 'd' || choice == 'D') && intPlayerCardCount == 2 && (intplayerHandValue == 9 || intplayerHandValue == 10 || intplayerHandValue == 11)){
				
				con.println("You chose to Double Down.");
				
				if(intCash >= intBet){
					intCash = intCash - intBet;
					intBet = intBet * 2;
					
					intPlayer[intPlayerCardCount][0] = intDeck[intDeckPos][0];
					intPlayer[intPlayerCardCount][1] = intDeck[intDeckPos][1];
					
					intDeckPos = intDeckPos + 1;
					intPlayerCardCount = intPlayerCardCount + 1;

					con.println("You drew: " + strValues[intPlayer[intPlayerCardCount - 1][0]] + " of " + strSuits[intPlayer[intPlayerCardCount - 1][1]]);

					intplayerHandValue = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
					con.println("Your hand value is now: " + intplayerHandValue);

					con.println("Dealer reveals second card:");
					intDealer[1][0] = intDeck[intDeckPos][0];
					intDealer[1][1] = intDeck[intDeckPos][1];
					
					intDeckPos = intDeckPos + 1;
					intDealerCardCount = 2;
					
					con.println(strValues[intDealer[1][0]] + " of " + strSuits[intDealer[1][1]]);

					while(CPTAdamMethods.handvalue(intDealer, intDealerCardCount) < 17 && intDealerCardCount < 5){
						
						intDealer[intDealerCardCount][0] = intDeck[intDeckPos][0];
						intDealer[intDealerCardCount][1] = intDeck[intDeckPos][1];
						con.println("Dealer draws: " + strValues[intDealer[intDealerCardCount][0]] + " of " + strSuits[intDealer[intDealerCardCount][1]]);
						
						intDeckPos = intDeckPos + 1;
						intDealerCardCount = intDealerCardCount + 1;
						
					}

					int intPlayerTotal = CPTAdamMethods.handvalue(intPlayer, intPlayerCardCount);
					int intDealerTotal = CPTAdamMethods.handvalue(intDealer, intDealerCardCount);

					con.println();
					con.println("Your total: " + intPlayerTotal);
					con.println("Dealer total: " + intDealerTotal);

					if(intDealerTotal > 21){
						
						con.println("Dealer busts! You win!");
						intCash = intCash + intBet;
						con.println("You now have $" + intCash);
						
					}else if(intDealerTotal > intPlayerTotal){
						
						con.println("Dealer wins.");
						intCash = intCash - intBet;
						
					}else if(intDealerTotal < intPlayerTotal){
						
						con.println("You win!");
						intCash = intCash + intBet;
						con.println("You now have $" + intCash);
						
					}else{
						con.println("Push! It's a tie.");
					}

					con.println("Press any key to return to the main menu...");
					con.getChar();
					
					con.clear();
					
					return;
					
				}else{
					
					con.println("You don’t have enough money to double down.");
					continue;
					
				}
			
            }else{
                con.println("Invalid option, try again.");
            
			}
        }
    }
}
	
	public static void leaderboard(Console con){
	
		con.setBackgroundColor(Color.BLACK);
	
	}
	
	public static void help(Console con) {
		while(true){
       
			con.setBackgroundColor(Color.WHITE);
			con.clear();
        
			BufferedImage imgAces = con.loadImage("Aces.png");
			con.drawImage(imgAces, 300, 0);

			con.setDrawColor(Color.BLACK);
			con.drawString("HELP MENU",445,380);
			con.drawString("[R] Rules",445,460);    
			con.drawString("[C] Card Values",445,490);
			con.drawString("[Q] Main Menu",445,520);
			
			con.setDrawColor(new Color(250, 250, 250));
			con.drawString("[S] ???",445,550);        
			
			con.setDrawColor(new Color(205, 205, 205));
			con.fillRect(400, 430, 200, 5);

			con.repaint();

			char chrOption2 = con.getChar();
			System.out.println("entered letter: "+chrOption2);

			if(chrOption2 == 'r' || chrOption2 == 'R'){

				con.setBackgroundColor(Color.WHITE);
				con.clear();

				BufferedImage imgRules = con.loadImage("Rules.png");
				con.drawImage(imgRules, 0, 0);
				con.repaint();


				con.getChar();

			}else if(chrOption2 == 'c' || chrOption2 == 'C'){
				con.setBackgroundColor(new Color(131,203,123));
				con.clear();

				BufferedImage imgValue = con.loadImage("CardValues.png");
				con.drawImage(imgValue, 100, 0);
				con.repaint();

				con.getChar();

			}else if(chrOption2 == 's' || chrOption2 == 'S'){
				con.setBackgroundColor(Color.WHITE);
				con.clear();

				BufferedImage imgMeme = con.loadImage("Meme.png");
				con.drawImage(imgMeme, 0, 0);
				con.repaint();

				con.getChar();

			}else if(chrOption2 == 'q' || chrOption2 == 'Q'){

				con.clear();
				return;
			}

		}
	}
}
