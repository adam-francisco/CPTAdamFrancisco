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
	
		public static void play(Console con){
		
			int intCash;
			int intBet;
			int intPlayer;
			int intDealer;
			
			intCash = 1000;
			
			// Page created for name of player
			con.setBackgroundColor(Color.BLACK);
			
			// Variable for name
			String strName;
			
			// Collects string value for player name
			con.println("What's your name?: ");
			strName = con.readLine();
			
			if(strName.equalsIgnoreCase("statitan")){
				intCash = 2500;
			}
			
			con.println("You will start off with $"+intCash);
			con.println("How much would you like to bet?");
			intBet = con.readInt();
			
			System.out.println("Bet amount: "+intBet);
			
			while(intBet > intCash){
				
				con.println("You can't bet that much");
				
				con.println("How much would you like to bet?");
				intBet = con.readInt();
			}
			
			// clears text from console
			con.clear();
		
		}
	
		public static void leaderboard(Console con){
	
		con.setBackgroundColor(Color.BLACK);
	
		}
	
		public static void help(Console con){
	
		con.setBackgroundColor(Color.WHITE);
			
			char chrOption2;
			
			con.repaint();
			
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
			
			con.repaint();
			
			chrOption2 = con.getChar();
			System.out.println("entered letter: "+chrOption2);
			
			if(chrOption2 == 'r' || chrOption2 == 'R'){
				
				BufferedImage imgRules = con.loadImage("Rules.png");
					con.drawImage(imgRules, 0, 0);
					
				con.repaint();
							
			}else if(chrOption2 == 'c' || chrOption2 == 'C'){
				
				con.setBackgroundColor(new Color(131,203,123));
				BufferedImage imgValue = con.loadImage("CardValues.png");
					con.drawImage(imgValue, 100, 0);
				
				con.repaint();
				
			}else if(chrOption2 == 's' || chrOption2 == 'S'){
				
				con.setBackgroundColor(Color.WHITE);
				
				BufferedImage imgMeme = con.loadImage("Meme.png");
					con.drawImage(imgMeme, 0, 0);
					
				con.repaint();
			}
		}
	}
}
