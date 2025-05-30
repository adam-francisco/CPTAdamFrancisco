import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console(1000,600);
		
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,1000,600);
		
		con.setDrawColor(new Color(205, 205, 205));
		con.fillRect(498,220,5,150);
		
		con.setDrawColor(Color.BLACK);
		con.drawString("Blackjack",535,220);
		con.drawString("Main Menu",535,250);
		con.drawString("Play [P]",535,280);
		con.drawString("Leaderboard [L]",535,310);
		con.drawString("Quit [Q]",535,340);
		
		con.setDrawColor(new Color(205, 205, 205));
		con.drawString("* Type and enter the corresponding letter to open the option", 140, 555);
		
		BufferedImage imgPoker = con.loadImage("blackjack.png");
				con.drawImage(imgPoker, 180, 150);
		
	}
}
