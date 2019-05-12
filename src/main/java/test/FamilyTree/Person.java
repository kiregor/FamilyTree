package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
	String name;
	String gender;
	Person[] parents;
	List<Person> children;
	
	public Person() {
		parents = new Person[2];
		children = new ArrayList<Person>();
	}
	
	public Person(String newName) {
		parents = new Person[2];
		children = new ArrayList<Person>();
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public Person[] getParents() {
		return parents;
	}
}
