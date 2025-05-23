import arc.*;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console();
		
		String strMood;
		
		con.println("How are you?");
		strMood = con.readLine();
		
		if(strMood.equalsIgnoreCase("good")){
			con.println("That's great");
		}else if(strMood.equalsIgnoreCase("ok")){
			con.println("Hopefully you feel better");
		}else{
			con.println("That's too bad");
		}
	}
}
