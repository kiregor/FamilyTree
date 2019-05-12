package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Family {
	List<Person> people;
	
	public Family() {
		people = new ArrayList<Person>();
	}
	
	public boolean male(String name) {
		return false;
	}
	
	public boolean female(String name) {
		return false;
	}
	
	public boolean isMale(String name) {
		return false;
	}
	
	public boolean isFemale(String name) {
		return false;
	}
	
	public boolean setParent(String nameChild, String nameParent) {
		return false;
	}
	
	public String[] getParents(String name) {
		String[] temp = {"hi"};
		return temp;
	}
	
	public String[] getChildren(String name) {
		String[] temp = {"hi"};
		return temp;
	}
}
