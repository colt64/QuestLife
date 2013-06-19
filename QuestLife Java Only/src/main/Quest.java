package main;

import java.util.Date;

public class Quest {
private String name;
private long dateCreated;
private long dateDue;
private int difficulty;
private boolean complete;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getDateCreated() {
	return dateCreated;
}
public void setDateCreated() {
	this.dateCreated = new Date().getTime();
}
public long getDateDue() {
	return dateDue;
}
public void setDateDue(long dateDue) {
	this.dateDue = dateDue;
}
public int getDifficulty() {
	return difficulty;
}
public void setDifficulty(int difficulty) {
	this.difficulty = difficulty;
}


public boolean isComplete() {
	return complete;
}
public void setComplete(boolean complete) {
	this.complete = complete;
}

public int turnInQuest(){
	int xpValue = 0;
	this.calculateXP();
	this.complete = true;
	return xpValue;
}

public int calculateXP(){
	long today = new Date().getTime();
	long dueDate = this.dateDue;
	long timeBetween = today - dueDate;
	int xpValue = (int) (timeBetween/1000);	
	return xpValue;
}



}
