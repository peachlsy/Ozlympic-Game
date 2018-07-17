import java.util.ArrayList;
import java.util.List;

public class DAO {			//This class aims to access data in files
							//By changing this class, the source of data could change to Database..
	
	public <T> List<T> fileInput(Class<T> clazz) throws Exception{	//using reflection to invoke method from MyTools class
		List<T> list=new ArrayList<T>();
		String file = null;
		if(clazz.equals(Swimmer.class)){
			file="Swimmer.txt";
		} else if (clazz.equals(Sprinter.class)) {
			file="Sprinter.txt";
		} else if (clazz.equals(Cyclist.class)) {
			file="Cyclist.txt";
		} else if (clazz.equals(SuperAthlete.class)) {
			file="SuperAthlete.txt";
		} else if (clazz.equals(Official.class)) {
			file="Official.txt";
		}
		list= MyTools.AthletesInput(clazz, file);
		return list;
	}
	
}
