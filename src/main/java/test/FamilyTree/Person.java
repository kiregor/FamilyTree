package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Person {
	String name;
	String gender;
	Person[] parents;
	List<Person> children;
	List<Person> spouse;
	
	public Person() {
		parents = new Person[2];
		children = new ArrayList<Person>();
		spouse = new ArrayList<Person>();
	}
	
	public Person(String newName) {
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String newGender) {
		gender = newGender;
	}
	
	public boolean checkParents(String name) {
		boolean check = false;
		
		if(parents[0] != null) {
			if(Stream.of(parents).filter(p -> p.name.equals(name)).count() != 1) {
				check = true;
				parents[0].checkParents(name);
				if(parents[1] != null)
					parents[1].checkParents(name);
			}
			else {
				check = false;
			}
		}
		else {
			check = true;
		}
		
		return check;
	}
}
