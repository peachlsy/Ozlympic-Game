import java.util.Iterator;
import java.util.TreeSet;

public class Official extends Participant{
	
	private TreeSet<Athlete> thisResult;
	
	public TreeSet<Athlete> getThisResult() {
		return thisResult;
	}
	public void setThisResult(TreeSet<Athlete> thisResult) {
		this.thisResult = thisResult;
	}
	
	public Official(int id, String name, int age, String state){
		super(id, name, age, state);
	}
	public Official(){
		super();
	}

	public void Summary(){		//summarize a game
		System.out.println("==================================="+"\n"+"Rank for this game:");
		int i=1;
		for (Iterator<Athlete> it = thisResult.iterator(); it.hasNext();) {
			Athlete a= it.next();
			int add=0;
			if (i==1){
				add=5;
				System.out.println("First place  :   "+a.getName()+": "+a.getThisResult());
				}
			else if (i==2) {
				add=2;
				System.out.println("Second place :   "+a.getName()+": "+a.getThisResult());
			}else if (i==3){
				add=1;
				System.out.println("Third place  :   "+a.getName()+": "+a.getThisResult());
				System.out.println();
			}
			a.setScoreTotle(add);
			i++;
			
			if (i==4) {
				break;
			}
		}
	}
}
