package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Person {
	private String name;
	private String gender;
	private List<Person> parents;
	private List<Person> children;
	private List<Person> spouse;
	
	public Person() {
		parents = new ArrayList<Person>();
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
		parents.add(newParent);
	}
	
	public Optional<List<Person>> getParents() {
		return Optional.of(parents);
	}
	
	public boolean checkParents(String name) {
		boolean check = false;
		
		if(parents.size() > 0) {
			if(parents.stream().filter(p -> p.name.equals(name)).count() != 1) {
				check = true;
				check = parents.stream().allMatch(p -> p.checkParents(name));
			}
			else {
				check = false;
			}
		}
		
		return check;
	}
}
