import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Game {
	private String gameID;
	private List<Athlete> ath;
	private Official referee;				//use composition to combine a game and a referee
	private TreeSet<Athlete> thisResultSet;
	private String outputResults="\n";
	
	public String getOutputResults() {
		return outputResults;
	}
	public void setOutputResults(String outputResults) {
		this.outputResults = outputResults;
	}
	public TreeSet<Athlete> getThisResultSet() {
		return thisResultSet;
	}
	public void setThisResultSet(TreeSet<Athlete> thisResultSet) {
		this.thisResultSet = thisResultSet;
	}
	public Game(String gameID, List<Athlete> ath, Official referee) {
		this.gameID = gameID;
		this.ath = ath;
		this.referee = referee;
	}
	public Game(){}


	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public List<Athlete> getPlayers() {
		return ath;
	}

	public void setPlayers(List<Athlete> ath) {
		this.ath = ath;
	}

	public Official getOfficial() {
		return referee;
	}

	public void setOfficial(Official referee) {
		this.referee = referee;
	}

	public TreeSet<Athlete> gameStart() {		//invoke each athlete's compete method 
												//Save result in a TreeSet and sort automatically
		
		TreeSet<Athlete> set = new TreeSet<Athlete>(new Comparator<Athlete>() {
			@Override
			public int compare(Athlete a, Athlete b) {
				if (a.getThisResult() < b.getThisResult()) {
					return -1;
				} else if (a.getThisResult() > b.getThisResult()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		System.out.println("\n"+"GameID: "+this.gameID+"\n"+"Result: ");
		for (Iterator<Athlete> it = ath.iterator(); it.hasNext();) {
			Athlete a = it.next();
			a.compete();
			String string=a.getName() + " " + a.getThisResult();
			System.out.println(string);
			outputResults=outputResults+string+"\n";	//combine String to save result information
			set.add(a);
		}
		setThisResultSet(set);
		return set;	
	}
	
	public void printResult(){   	//printResult
		System.out.println("GameID: "+gameID);
		System.out.println("Result Rank:  "+outputResults);
	}
	
}
