import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdamMethods{
	public static int[][] deck() {
		int intDeck[][] = new int[52][3];
		
		int intCards = 0;
		int intCardValue;
		int intCardSuit;
		
		// Load deck with values and suits, plus a random number for sorting
		for (intCardSuit = 0; intCardSuit <= 3; intCardSuit++) {
			for (intCardValue = 0; intCardValue <= 12; intCardValue++) {
				intDeck[intCards][0] = intCardValue;      // card value
				intDeck[intCards][1] = intCardSuit;       // suit
				intDeck[intCards][2] = (int)(Math.random() * 100 + 1);  // random number for shuffling
				intCards++;
			}
		}
		
		int intValueTemp;
		int intSuitTemp;
		int intRandTemp;
		int intCount;
		int intCount2;
		
		// Bubble sort by random number descending
		for (intCount = 0; intCount < intDeck.length - 1; intCount++) {
			for (intCount2 = 0; intCount2 < intDeck.length - 1 - intCount; intCount2++) {
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
		
		return intDeck;
		
	}
}
