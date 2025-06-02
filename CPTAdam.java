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
			System.out.println("you entered: "+chrOption);
			
		// Play option
		if(chrOption == 'p' || chrOption == 'P'){
			
			con.setBackgroundColor(Color.BLACK);
			
			String strName;
			
			con.println("What's your name?: ");
			strName = con.readLine();
			
			con.clear();
			
			con.setBackgroundColor(new Color(53, 101, 77));
			
			// Card slot holders
			con.setDrawColor(new Color(187, 165, 61));
			con.fillRoundRect(50, 375, 100, 200, 50, 50);
			con.fillRoundRect(250, 350, 100, 200, 50, 50);
			con.fillRoundRect(450, 325, 100, 200, 50, 50);
			con.fillRoundRect(650, 350, 100, 200, 50, 50);
			con.fillRoundRect(850, 375, 100, 200, 50, 50);
			
			con.fillRoundRect(50, 25, 100, 200, 50, 50);
			con.fillRoundRect(250, 50, 100, 200, 50, 50);
			con.fillRoundRect(450, 75, 100, 200, 50, 50);
			con.fillRoundRect(650, 50, 100, 200, 50, 50);
			con.fillRoundRect(850, 25, 100, 200, 50, 50);
			
			// Card slot filler
			con.setDrawColor(new Color(53, 101, 77));
			con.fillRoundRect(60, 385, 80, 180, 50, 50);
			con.fillRoundRect(260, 360, 80, 180, 50, 50);
			con.fillRoundRect(460, 335, 80, 180, 50, 50);
			con.fillRoundRect(660, 360, 80, 180, 50, 50);
			con.fillRoundRect(860, 385, 80, 180, 50, 50);
			
			con.fillRoundRect(60, 35, 80, 180, 50, 50);
			con.fillRoundRect(260, 60, 80, 180, 50, 50);
			con.fillRoundRect(460, 85, 80, 180, 50, 50);
			con.fillRoundRect(660, 60, 80, 180, 50, 50);
			con.fillRoundRect(860, 35, 80, 180, 50, 50);
			
			con.setDrawColor(Color.WHITE);
			con.drawString("Dealer",465,10);
			con.drawString(strName ,475,560);
			
		}else if(chrOption == 'l' || chrOption == 'L'){
			con.setBackgroundColor(Color.BLACK);
		}else if(chrOption == 'q' || chrOption == 'Q'){
			con.setBackgroundColor(Color.BLACK);
		}else if(chrOption == 'h' || chrOption == 'H'){
			con.setBackgroundColor(Color.BLACK);
		}
	}
}
