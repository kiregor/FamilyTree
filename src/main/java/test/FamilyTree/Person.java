package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Person {
	private String name;
	private String gender;
	private Person[] parents;
	private List<Person> children;
	private List<Person> spouse;
	
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
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String newGender) {
		gender = newGender;
	}
	
	public List<Person> getChildren(){
		return children;
	}
	
	public void addToChildren(Person newChild) {
		children.add(newChild);
	}
	
	public List<Person> getSpouse(){
		return spouse;
	}
	
	public void addToSpouse(Person newSpouse) {
		spouse.add(newSpouse);
	}
	
	public void setParent(Person newParent, int i) {
		parents[i] = newParent;
	}
	
	public Person[] getParents() {
		return parents;
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
