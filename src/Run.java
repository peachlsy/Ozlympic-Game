import java.util.List;

public class Run extends Game{
	private static int numOfInvoke=0;	//generate gameID automatically by invoke times
	public int getNumOfInvoke() {
		return numOfInvoke;
	}

	public Run(){
		numOfInvoke++;
		setGameID("R"+String.format("%02d", numOfInvoke));  //combine gameID (C+invoke time)
	}
	public Run(String gameID, List<Athlete> players, Official referee){
		super(gameID, players, referee);
	}
}
