
public class SuperAthlete extends Athlete {

	private String gameType;

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public SuperAthlete(int id, String name, int age, String state) {
		super(id, name, age, state);
	}

	public SuperAthlete() {
		super();
	}

	@Override
	public double compete(){	//override method to generate a result randomly (by gameType)
								//invoke method in MyTools class
		double result=0;
		if (gameType =="Swim") {
			result=MyTools.getRandomNum(100, 200);
		} else if (gameType =="Cycling") {
			result=MyTools.getRandomNum(500, 800);
		} else if (gameType =="Run"){
			result=MyTools.getRandomNum(10, 20);
		}
		this.setThisResult(result);
		return result;
	}

}
