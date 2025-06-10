import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdamMethods{
	public static int[][] deck() {
		
		int intDeck[][] = new int[52][3];
		
		int intCards = 0;
		int intCardValue;
		int intCardSuit;
		
		for (intCardSuit = 0; intCardSuit < 4; intCardSuit++) {
			
			for (intCardValue = 0; intCardValue < 13; intCardValue++) {
				
				intDeck[intCards][0] = intCardValue;
				intDeck[intCards][1] = intCardSuit;
				intDeck[intCards][2] = (int)(Math.random() * 100 + 1);
				intCards++;
			}
		}
		
		int intValueTemp;
		int intSuitTemp;
		int intRandTemp;
		int intCount;
		int intCount2;
		
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
		
		for(intCount = 0; intCount < intCards; intCount++){
			System.out.println(intDeck[intCount][0] + " - " + intDeck[intCount][1] + " - " + intDeck[intCount][2]);
		}
		
		return intDeck;
		
	}
}
