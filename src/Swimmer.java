
public class Swimmer extends Athlete {
	public Swimmer(int id, String name, int age, String state) {
		super(id, name, age, state);
	}
	public Swimmer() {
		super();
	}
	@Override
	public double compete(){		//override method to generate a result between 100 and 200 randomly 
									//invoke method in MyTools class
		double result=MyTools.getRandomNum(100, 200);
		setThisResult(result);
		return result;
	}
	
}
