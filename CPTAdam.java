import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console(1000,600);
		
		char chrOption;
		
		con.setBackgroundColor(Color.WHITE);
		
		con.setDrawColor(new Color(205, 205, 205));
		con.fillRect(495, 210, 5, 185);
		
		con.setDrawColor(Color.BLACK);
		con.drawString("Blackjack",532,210);
		con.drawString("Main Menu",532,240);
		con.drawString("Play [P]",532,270);
		con.drawString("Leaderboard [L]",532,300);
		con.drawString("Quit [Q]",532,330);
		con.drawString("Help [H]",532,360);
		
		
		BufferedImage imgPoker = con.loadImage("blackjack.png");
				con.drawImage(imgPoker, 180, 140);
		
		con.setDrawColor(new Color(205, 205, 205));
		con.drawString("* Type the corresponding letter to open the option", 197, 555);
		
		chrOption = con.getChar();
			System.out.println("you entered: "+chrOption);
			
		if(chrOption == 'p' || chrOption == 'P'){
			con.setBackgroundColor(new Color(53, 101, 77));
			
			con.setDrawColor(new Color(187, 165, 61));
			con.drawRoundRect(50, 350, 100, 200, 50, 50);
			con.drawRoundRect(200, 350, 100, 200, 50, 50);
			con.drawRoundRect(350, 350, 100, 200, 50, 50);
			con.drawRoundRect(500, 350, 100, 200, 50, 50);
			con.drawRoundRect(650, 350, 100, 200, 50, 50);
			
		}else if(chrOption == 'l' || chrOption == 'L'){
			con.setBackgroundColor(Color.BLACK);
		}else if(chrOption == 'q' || chrOption == 'Q'){
			con.setBackgroundColor(Color.BLACK);
		}else if(chrOption == 'h' || chrOption == 'H'){
			con.setBackgroundColor(Color.BLACK);
		}
	}
}
