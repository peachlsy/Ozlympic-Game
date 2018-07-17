public class Sprinter extends Athlete {
	
	public Sprinter(int id, String name, int age, String state) {
		super(id, name, age, state);
	}
	public Sprinter() {
		super();
	}
	@Override
	public double compete() {	//override method to generate a result between 10 and 20 randomly 
								//invoke method in MyTools class
		double result=MyTools.getRandomNum(10, 20); 	
		setThisResult(result);
		return result;
	}

}
