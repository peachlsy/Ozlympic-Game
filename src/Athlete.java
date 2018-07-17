
public abstract class Athlete extends Participant implements Comparable{  //super class of sprinter,swimmer
																		  //cyclist, superAthlete
	private int scoreTotle = 0;											  //This class has a abstract method compete()
	public double thisResult;
	
	public Athlete(int id, String name, int age, String state) {
		super(id, name, age, state);
	}
	
	public Athlete(){
		super();
	}
	
	public double getThisResult() {
		return thisResult;
	}
	public void setThisResult(double thisResult) {
		this.thisResult = thisResult;
	}
	public double getScoreTotle() {
		return scoreTotle;
	}
	public void setScoreTotle(int thisTimePoint) {
		this.scoreTotle = scoreTotle + thisTimePoint;
	}

	@Override
	public String toString() {
		return "Athlete [name: " + this.getName() + "   Totle score=" + scoreTotle + "]";
	}

	public abstract double compete();	//Generate a random result of athlete
}
