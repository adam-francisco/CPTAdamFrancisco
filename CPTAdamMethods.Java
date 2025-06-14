// Adam Matthew H. Francisco
// Offline Blackjack
// 12 June, 2025
// Version  1.42

import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdamMethods{
	public static void main(String[] args){
		Console con = new Console();
		
		//TEST: Just to see if the deck prints on terminal
		deck();
		
	}
	public static int[][] deck() {
		
		// intDeck which is 52x3
		int intDeck[][] = new int[52][3];
		
		// Variables for determinig numbers needed for each card (ie amount of cards, card value 0-12, and card suit 0-3
		int intCards = 0;
		int intCardValue;
		int intCardSuit;
		
		// For loop for each suit 
		for (intCardSuit = 0; intCardSuit < 4; intCardSuit++) {
			
			// For loop for each card value
			for (intCardValue = 0; intCardValue < 13; intCardValue++) {
				
				// Assigns, card value, card suit, and a random number between 100 - 1
				intDeck[intCards][0] = intCardValue;
				intDeck[intCards][1] = intCardSuit;
				intDeck[intCards][2] = (int)(Math.random() * 100 + 1);
				intCards++;
			}
		}
		
		// Initializes variables
		int intValueTemp;
		int intSuitTemp;
		int intRandTemp;
		int intCount;
		int intCount2;
		int intCount3;
		int intRandNum;
		String strCardValue;
		String strCardSuit;
		
		// Bubble sort by random number descending
		for (intCount = 51; intCount > 0; intCount--) {
			
			for (intCount2 = 0; intCount2 < intCount; intCount2++) {
				
				if (intDeck[intCount2][2] < intDeck[intCount2 + 1][2]) {
					
					// Swap card value
					intValueTemp = intDeck[intCount2][0];
					intDeck[intCount2][0] = intDeck[intCount2 + 1][0];
					intDeck[intCount2 + 1][0] = intValueTemp;

					// Swap suit
					intSuitTemp = intDeck[intCount2][1];
					intDeck[intCount2][1] = intDeck[intCount2 + 1][1];
					intDeck[intCount2 + 1][1] = intSuitTemp;

					// Swap random number
					intRandTemp = intDeck[intCount2][2];
					intDeck[intCount2][2] = intDeck[intCount2 + 1][2];
					intDeck[intCount2 + 1][2] = intRandTemp;
					
				}
			}
		}

		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] values = {"Ace", "2", "3", "4", "5", "6", "7","8", "9", "10", "Jack", "Queen", "King"};


		for (intCount3 = 0; intCount3 < 52; intCount3++) {
			strCardValue = values[intDeck[intCount3][0]];
			strCardSuit = suits[intDeck[intCount3][1]];
			intRandNum = intDeck[intCount3][2];
			System.out.println(strCardValue + " of " + strCardSuit + " - " + intRandNum);
			
		}
		
		return intDeck;
		
	}
	
	public static int handvalue(int[][] intHand, int intCardCount){
		
		// Initializes variables
        int intTotal = 0;
        int intAceCount = 0;
        int intCount;
        int intCardValue;
      
        // For loop from cardcount from main program
        for (intCount = 0; intCount < intCardCount; intCount ++){
			
            intCardValue = intHand[intCount][0];
            
            // For face cards given their values are above 10
            if (intCardValue >= 10) {
                intTotal = intTotal + 10;
            
            // Ace's being either 1 or 11
            } else if (intCardValue == 0){
                intAceCount = intAceCount + 1;
                intTotal = intTotal + 11;
            } else {
                intTotal = intTotal + intCardValue + 1;
            }
        }

		// Ace's being either 1 or 11 pt. 2
        while (intTotal > 21 && intAceCount > 0) {
            intTotal = intTotal - 10;
            intAceCount = intAceCount - 1;
        }
		
        return intTotal;
    }
}
