import java.util.List;

public class Cycling extends Game{
	public static int numOfInvoke=0;	//generate gameID automatically by invoke times 
	public int getNumOfInvoke() {
		return numOfInvoke;
	}

	public Cycling(){
		numOfInvoke++;
		setGameID("C"+String.format("%02d", numOfInvoke));	//combine gameID (C+invoke time)
	}
	public Cycling(String gameID, List<Athlete> players, Official referee){
		super(gameID, players, referee);
	}
}
