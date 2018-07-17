
public class Cyclist extends Athlete{
	public Cyclist(int id, String name, int age, String state) {
		super(id, name, age, state);
	}
	public Cyclist() {
		super();
	}
	@Override
	public double compete() {	//override method to generate a result between 500 and 800 randomly 
								//invoke method in MyTools class
		double result=MyTools.getRandomNum(500, 800);
		setThisResult(result);
		return result;
	}
}
