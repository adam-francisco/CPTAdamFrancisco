import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console(1000,600);
		
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,1000,600);
		
		con.setDrawColor(Color.BLACK);
		con.drawString("Blackjack",530,220);
		con.drawString("Main Menu",530,250);
		con.drawString("Play [P]",530,280);
		con.drawString("Leaderboard [L]",530,310);
		con.drawString("Quit [Q]",530,340);
		BufferedImage imgPoker = con.loadImage("blackjack.png");
				con.drawImage(imgPoker, 175, 150);
		
	}
}
