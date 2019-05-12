package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Collectors;

public class Family {
	List<Person> people;
	
	public Family() {
		people = new ArrayList<Person>();
	}
	
	public boolean male(String name) {
		boolean check = false;
		
		List<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).filter(p -> p.getGender().equals(null)).collect(Collectors.toList());
		
		try {
			Person updatePerson = checkList.get(0);
			if(updatePerson.gender == "female") {
				check = false;
			}
			else {
				updatePerson.name = name;
				updatePerson.gender = "male";
				check = true;
			}
		}
		catch(Exception e) {
			Person newPerson = new Person();
			newPerson.name = name;
			newPerson.gender = "male";
			check = true;
		}

		return check;
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
