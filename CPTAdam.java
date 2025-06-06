import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console(1000,600);
		
		// Variable for users menu option 
		char chrOption;
		
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
		
		// for determining option on menu
		chrOption = con.getChar();
		System.out.println("entered letter: "+chrOption);
			
		// Play option
		if(chrOption == 'p' || chrOption == 'P'){
			
			con.repaint();
			
			int intCash;
			
			intCash = 1000;
			
			// Page created for name of player
			con.setBackgroundColor(Color.BLACK);
			
			// Variable for name
			String strName;
			
			// Collects string value for player name
			con.println("What's your name?: ");
			strName = con.readLine();
			
			// clears text from console
			con.clear();
			
			// Sets table color
			con.setBackgroundColor(new Color(53, 101, 77));
			
			// Card slot holders
			con.setDrawColor(new Color(187, 165, 61));
			con.fillRoundRect(50, 375, 100, 200, 30, 30);
			con.fillRoundRect(250, 350, 100, 200, 30, 30);
			con.fillRoundRect(450, 325, 100, 200, 30, 30);
			con.fillRoundRect(650, 350, 100, 200, 30, 30);
			con.fillRoundRect(850, 375, 100, 200, 30, 30);
			
			con.fillRoundRect(50, 25, 100, 200, 30, 30);
			con.fillRoundRect(250, 50, 100, 200, 30, 30);
			con.fillRoundRect(450, 75, 100, 200, 30, 30);
			con.fillRoundRect(650, 50, 100, 200, 30, 30);
			con.fillRoundRect(850, 25, 100, 200, 30, 30);
			
			// Card slot filler
			con.setDrawColor(new Color(53, 101, 77));
			con.fillRoundRect(60, 385, 80, 180, 25, 25);
			con.fillRoundRect(260, 360, 80, 180, 25, 25);
			con.fillRoundRect(460, 335, 80, 180, 25, 25);
			con.fillRoundRect(660, 360, 80, 180, 25, 25);
			con.fillRoundRect(860, 385, 80, 180, 25, 25);
			
			con.fillRoundRect(60, 35, 80, 180, 25, 25);
			con.fillRoundRect(260, 60, 80, 180, 25, 25);
			con.fillRoundRect(460, 85, 80, 180, 25, 25);
			con.fillRoundRect(660, 60, 80, 180, 25, 25);
			con.fillRoundRect(860, 35, 80, 180, 25, 25);
			
			// Name and dealer strings onto console
			con.setDrawColor(Color.WHITE);
			con.drawString("Dealer",465,10);
			con.drawString(strName + " - $" + intCash,440,560);
			
		}else if(chrOption == 'l' || chrOption == 'L'){
			
			con.repaint();
			
			con.setBackgroundColor(Color.BLACK);
			
		}else if(chrOption == 'q' || chrOption == 'Q'){
			con.closeConsole();
			
		}else if(chrOption == 'h' || chrOption == 'H'){
			
			con.repaint();
			
			con.setBackgroundColor(Color.WHITE);
			
			char chrOption2;
			
			BufferedImage imgAces = con.loadImage("Aces.png");
				con.drawImage(imgAces, 300, 0);
				
			con.setDrawColor(Color.BLACK);
			con.drawString("HELP MENU",445,400);
			con.drawString("[R] Rules",445,480);	
			con.drawString("[C] Card Values",445,510);
			
			con.setDrawColor(new Color(245, 245, 245));
			con.drawString("[S] ???",445,540);		
				
			con.setDrawColor(new Color(205, 205, 205));
			con.fillRect(400, 450, 200, 5);
			
			chrOption2 = con.getChar();
			System.out.println("entered letter: "+chrOption2);
			
			if(chrOption2 == 'r' || chrOption2 == 'R'){
				
				BufferedImage imgRules = con.loadImage("Rules.png");
					con.drawImage(imgRules, 0, 0);
					
			}else if(chrOption2 == 'c' || chrOption2 == 'C'){
				
				con.setBackgroundColor(new Color(131,203,123));
				BufferedImage imgValue = con.loadImage("CardValues.png");
					con.drawImage(imgValue, 100, 0);
				
			}else if(chrOption2 == 's' || chrOption2 == 'S'){
				con.setBackgroundColor(Color.BLACK);
				
			}
		}
	}
}
