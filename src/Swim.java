import java.util.List;


public class Swim extends Game{
	public static int numOfInvoke=0;	//generate gameID automatically by invoke times
	public int getNumOfInvoke() {
		return numOfInvoke;
	}
	
	public Swim(){
		numOfInvoke++;
		setGameID("S"+String.format("%02d", numOfInvoke));	//combine gameID (C+invoke time)
	}
	public Swim(String gameID, List<Athlete> players, Official referee){
		super(gameID, players, referee);
	}
	
}
