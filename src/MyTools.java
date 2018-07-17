import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class MyTools {
	
	public static double getRandomNum(final double MIN, final double MAX){	//get a double random number in a scope
		DecimalFormat df = new DecimalFormat(".000");
		
		if (MIN == MAX) {
			return MIN;
		}
		return Double.parseDouble(df.format(MIN + ((MAX - MIN) * new Random().nextDouble())));
	}
	
	//read information from file and use reflection to initial objects (all participants)
	public static  <T> List<T> AthletesInput(Class<T> clazz, String file) 
			throws Exception{
		List<T> list = new ArrayList<T>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String temp = null;
		while ((temp = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(temp);
			int id = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			String state = st.nextToken();
			T t=clazz.newInstance();
			PropertyDescriptor pd1 = new PropertyDescriptor("id", clazz);
			Method writeMethod1 = pd1.getWriteMethod();    //setId()
	        writeMethod1.invoke(t, id);
	        PropertyDescriptor pd2 = new PropertyDescriptor("name", clazz);
			Method writeMethod2 = pd2.getWriteMethod();    //setName()
	        writeMethod2.invoke(t, name);
	        PropertyDescriptor pd3 = new PropertyDescriptor("age", clazz);
			Method writeMethod3 = pd3.getWriteMethod();    //setAge()
	        writeMethod3.invoke(t, age);
	        PropertyDescriptor pd4 = new PropertyDescriptor("state", clazz);
			Method writeMethod4 = pd4.getWriteMethod();    //setState()
	        writeMethod4.invoke(t, state);
			list.add((T) t);	
		}
		br.close();
		return list;
	}
	
	public static <T> List<Athlete> randomAssembleAthlete	//random distribute athlete (number between 5-8)
				(List<T> list,List<SuperAthlete> list2){	//include normal athlete and super Athlete
		List<SuperAthlete> newlist2=new ArrayList<SuperAthlete>(list2); 
		List<T> newlist=new ArrayList<T>(list); 
		int size=0;
		String gameType = null;
        ArrayList<Athlete> result = new ArrayList<>();  
  
		Random rand = new Random();  
        Random sizeOfArr=new Random();
        do {
        	size = sizeOfArr.nextInt(newlist2.size());
		} while (size>newlist2.size());
          
        for (int i = 0; i < size; i++) {  
            int myRand = rand.nextInt(newlist2.size());  
            if (newlist.get(0) instanceof Swimmer) {
				gameType="Swim";
			}else if (newlist.get(0) instanceof Cyclist) {
				gameType="Cycling";
			} else if (newlist.get(0) instanceof Sprinter) {
				gameType="Run";
			}
            result.add(newlist2.get(myRand)); 
            newlist2.get(myRand).setGameType(gameType);
            newlist2.remove(myRand);  
        }
        rand = new Random();
        sizeOfArr=new Random();
        do {
        	size = sizeOfArr.nextInt(newlist.size());
		} while (size>8-result.size()||size<5-result.size());

        for (int i = 0; i < size; i++) {  
            int myRand = rand.nextInt(newlist.size());  
            result.add((Athlete) newlist.get(myRand));  
            newlist.remove(myRand);  
        }
		return result;
	}
	public static Official randomOfficial(List<Official> list){ 	//select a referee randomly
		Random random=new Random();
		int num=random.nextInt(list.size());
		return list.get(num);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		try {
//			List<Swimmer> list=AthletesInput(Swimmer.class, "Swimmer.txt");
//			System.out.println(list.get(0).compete());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
