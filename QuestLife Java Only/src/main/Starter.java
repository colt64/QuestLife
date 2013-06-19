package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Starter {

	static ArrayList<Quest> quests = new ArrayList<Quest>();



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean keepGoing = true;
		String newQuest;
		while(keepGoing){
		System.out.println("Welcome to QuestLife");
		System.out.println("You have " + quests.size() + " active quests.");
		System.out.print("Create new quest?  ");
		Scanner input = new Scanner(System.in);
		newQuest = input.next();
		if(newQuest.equals("y") || newQuest.equals("yes") || newQuest.equals("Y") || newQuest.equals("Yes")){
			createQuest();
		}
		else{
			keepGoing = false;
		}
		}
	}
public static void createQuest(){
	Quest q = new Quest();
	int diff;
	String name;
	String dueDate;
	Date realDate = null;
	long dateTotal;
	Long today = new Date().getTime();
	long xpVal;
	
	quests.add(q);
	q.setDateCreated();
	System.out.print("Quest Name: ");
	Scanner input = new Scanner(System.in);
	name = input.next();
	System.out.print("Due Date MM.DD.YY:  ");
	dueDate = input.next();
	try {
		realDate = new SimpleDateFormat("MM.dd.yy", Locale.ENGLISH).parse(dueDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dateTotal = (realDate.getTime());
	System.out.print("Difficulty (1-3): ");
	diff = Integer.parseInt(input.next());
	
	xpVal =  ((((dateTotal - today) / 3600000) * 10)/2);
	
	q.setDateDue(dateTotal);
	q.setName(name);
	q.setDifficulty(diff);
	q.setComplete(false);
	
	System.out.println("Name: " + name + "\n" + "Due Date: " + realDate +   "\n" +  "Difficulty: " + diff);
	System.out.println("XP Value: " + (xpVal));
}
}
