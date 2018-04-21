//Raymond Adams
//Jordan Webb
//Jayne DePaolis
//Cade Dombroski
public class HitOrMiss {

	
	String guessed = "2"; 
	String guessedAndHit = "1";
	int hitCount = 0 , missCount = 0;
	int[][] shipPlacement = new int [10][10];
	
	//this method determines if the user hit or miss
	public boolean Hit_Miss(int a, int b, String[][] ships )//the coordinates from Gr.4 will go in this method
	{
		
		if (ships[a][b] != null&& ships[a][b] != "2"&& ships[a][b]!=guessedAndHit)
		{
			hitCount++;
			ships[a][b] = guessedAndHit;
			System.out.println("It's a Hit!");
			return true;
		}
		else if(ships[a][b] == "2" || ships[a][b] == "1")
		{
			System.out.println("You have already guessed this spot!");
			return false;
		}else 
			System.out.println("It's a miss!");
			missCount++;
			ships[a][b] = "2";
		return false;
		
	}
}
	//this method will determine if the user has already guessed a coordinate
	
