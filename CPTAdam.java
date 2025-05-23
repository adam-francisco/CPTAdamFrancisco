import arc.*;

public class CPTAdam{
	public static void main (String[] args){
		Console con = new Console();
		// Sets up variable
		String strMood;
		// Takes information from user
		con.println("How are you?");
		strMood = con.readLine();
		//Determines response
		if(strMood.equalsIgnoreCase("good")||strMood.equalsIgnoreCase("great")||strMood.equalsIgnoreCase("amazing") ){
			con.println("That's great");
		}else if(strMood.equalsIgnoreCase("ok")||strMood.equalsIgnoreCase("alright")){
			con.println("Hopefully you feel better");
		}else{
			con.println("That's too bad");
		}
	}
}
