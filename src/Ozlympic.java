import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Ozlympic {		//This is the main setup method

	private static int select;
	private static int userChooseInt;
	private static List<Swimmer> swimmers;
	private static List<Sprinter> Sprinters;
	private static List<Cyclist> Cyclists;
	private static List<SuperAthlete> SuperAthletes;
	private static List<Official> officials;
	private static Game game;
	private static List<Athlete> participates;
	private static List<Game> resultSet;
	private static Athlete predict;
	private static boolean flag=false;


	public static int scan(int a, String outputFirst) { // Method scan to
														// collect Users' input
														// (Integer)
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in); 
			System.out.print(outputFirst);
			a = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter an Integer number! \n");
			scan(a, outputFirst);
		}
		return a;
	}

	public static void exit() {		//Exit the program
		System.out.println("Thank you for using ~~ See you next time !!");
		System.exit(0);
	}

	public static String outputParticipate(List<Athlete> participant ){	//display menu1
		int num=1;
		String output="Please input your input: \n";
		String [] outlist=new String[participant.size()+1];
		for (Iterator<Athlete> i = participant.iterator(); i.hasNext();) {
			Athlete a = (Athlete) i.next();
			outlist[num]=num+"   Name: "+a.getName()+"\n";
			num++;
		}
		for (int i = 1; i < outlist.length; i++) {
			output=output+outlist[i];
		}
		return output;
	}
	public static String outputGameId(List<Game> resultSet ){		//display menu2
		Iterator<Game> iterator=resultSet.iterator();
		int num=1;
		String output="Please input your input: \n";
		String [] outlist=new String[resultSet.size()+1];
		while (iterator.hasNext()) {
			Game a=iterator.next();
			outlist[num]=num+"   GameID: "+a.getGameID()+"\n";
			num++;
		}
		for (int i = 1; i < outlist.length; i++) {
			output=output+outlist[i];
		}
		return output;
	}
	
	
	public static void main(String[] args) {
		
		resultSet=new ArrayList<Game>();		
		DAO dao = new DAO();
		try {
			officials=dao.fileInput(Official.class);
			swimmers=dao.fileInput(Swimmer.class);
			Sprinters=dao.fileInput(Sprinter.class);
			Cyclists=dao.fileInput(Cyclist.class);
			SuperAthletes=dao.fileInput(SuperAthlete.class);//load athletes and official
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		do {
			System.out.println();
			select = scan(userChooseInt, "Ozlympic Game \n" + "=================================== \n"
					+ "Input 1	  Select a game to run \n" 
					+ "Input 2	  Predict the winner of the game \n"
					+ "Input 3	  Start the game \n" 
					+ "Input 4	  Display the final results of all games \n"
					+ "Input 5	  Display the points of all athletes \n" 
					+ "Input 6	  Exit \n\n" + "Enter an option: ");
			switch (select) {
			case 1:
				select = scan(userChooseInt,
						"Please select a game to run \n" + "=================================== \n"
								+ "Input 1	  Swim \n" 
								+ "Input 2	  Cycling \n" 
								+ "Input 3	  Running \n"
								+ "Enter an option: ");
				
				switch (select) {
				case 1:
					game=new Swim();flag=true;
					participates=MyTools.randomAssembleAthlete(swimmers, SuperAthletes);//distribute athletes randomly
					game.setOfficial(MyTools.randomOfficial(officials));//distribute referee randomly
					game.setPlayers(participates);
					break;
				case 2:
					game=new Cycling();flag=true;
					participates=MyTools.randomAssembleAthlete(Cyclists, SuperAthletes);
					game.setOfficial(MyTools.randomOfficial(officials));
					game.setPlayers(participates);
					break;
				case 3:
					game=new Run();flag=true;
					participates=MyTools.randomAssembleAthlete(Sprinters, SuperAthletes);
					game.setOfficial(MyTools.randomOfficial(officials));
					game.setPlayers(participates);
					break;
				default:
					System.out.println("Please input an integer between 1 and 3 !!!");  //deal with misInput
					break;
					
				}
				
				break;
			case 2:		//Predict the winner 
				select = scan(userChooseInt, outputParticipate(participates));
				System.out.println("Your prediction is:  "+select);
				predict=participates.get(select-1);
				System.out.println(predict);
				break;
			case 3:		//Start the game
				if (flag==false) {
					System.out.println("You have not chosen a game to run!!!");
					break;
				}
				game.gameStart();
				game.getOfficial().setThisResult(game.getThisResultSet());
				game.getOfficial().Summary();
				if(predict==null){
					System.out.println("You did not make any predict!!!");
				}else if (game.getThisResultSet().first().thisResult==predict.thisResult) {
					System.out.println("Congratulations!!!!!!  Your predict is True!!");
				}else {
					System.out.println("Sorry, your predict is wrong!!!");
				}
				
				//save game results in List
				resultSet.add(game);				
				predict=null;
				flag=false;
				break;
			case 4:		//Display the final results by GameID
				select = scan(userChooseInt, outputGameId(resultSet));
				if (select>=outputGameId(resultSet).split("\n").length) {
					System.out.println("Invalid Input!!");
					break;
				}
				resultSet.get(select-1).printResult();
				break;
			case 5:		//Display the points of all athletes
				for (Athlete a : swimmers) {
					System.out.println(a.getName()+" : "+a.getScoreTotle());
				}
				for (Athlete a : Sprinters) {
					System.out.println(a.getName()+" : "+a.getScoreTotle());
				}
				for (Athlete a : Cyclists) {
					System.out.println(a.getName()+" : "+a.getScoreTotle());
				}
				for (Athlete a : SuperAthletes) {
					System.out.println(a.getName()+" : "+a.getScoreTotle());
				}
				break;
			case 6:		//Exit
				exit();
				break;
			default :
				System.out.println("Please input an integer between 1 and 6 !!!");
				break;
			}
			
			
		} while (true);

	}
	

}
