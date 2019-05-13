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
		
		List<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
		
		if(checkList.size() == 1) {
			Person updatePerson = checkList.get(0);
			
			
			if(updatePerson.children.size() > 0) {
				if(updatePerson.spouse.stream().map( s -> s.gender).filter(g -> g.equals("male")).count() > 0) {
					check = false;
				}
				else {
					if(updatePerson.gender == "female") {
						check = false;
					}
					else {
						updatePerson.gender = "male";
						check = true;
					}
					
					updatePerson.spouse.stream().forEach(s -> s.setGender("female"));
				}
				
				
			}
		}
		else {
			Person newPerson = new Person();
			newPerson.name = name;
			newPerson.gender = "male";
			people.add(newPerson);
			check = true;
		}

		return check;
	}
	
	public boolean female(String name) {
		boolean check = false;
		
		List<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
		
		if(checkList.size() == 1) {
			Person updatePerson = checkList.get(0);
			if(updatePerson.gender == "male") {
				check = false;
			}
			else {
				updatePerson.gender = "female";
				check = true;
			}
		}
		else {
			Person newPerson = new Person();
			newPerson.name = name;
			newPerson.gender = "female";
			people.add(newPerson);
			check = true;
		}

		return check;
	}
	
	public boolean isMale(String name) {
		boolean check = false;
		
		List<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
		
		if(checkList.size() == 1) {
			Person updatePerson = checkList.get(0);
			if(updatePerson.gender == "male") {
				check = true;
			}
			else {
				check = false;
			}
		}
		else {
			Person newPerson = new Person();
			newPerson.name = name;
			people.add(newPerson);
			check = false;
		}
		
		return check;
	}
	
	public boolean isFemale(String name) {
		boolean check = false;
		
		List<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
		
		if(checkList.size() == 1) {
			Person updatePerson = checkList.get(0);
			if(updatePerson.gender == "female") {
				check = true;
			}
			else {
				check = false;
			}
		}
		else {
			Person newPerson = new Person();
			newPerson.name = name;
			people.add(newPerson);
			check = false;
		}
		
		return check;
	}
	
	public boolean setParent(String nameChild, String nameParent) {
		Boolean check = false;
		Person child, parent;
		
		List<Person> checkListChild = people.stream().filter(p -> p.getName().equals(nameChild)).collect(Collectors.toList());
		List<Person> checkListParent = people.stream().filter(p -> p.getName().equals(nameParent)).collect(Collectors.toList());
				
		if(checkListChild.size() == 1) {
			child = checkListChild.get(0);
			if(child.checkParents(nameChild)) {
				if(child.parents[0] == null) {
					if(checkListParent.size() == 1) {
						parent = checkListParent.get(0);
						parent.children.add(child);
					}
					else {
						parent = new Person();
						parent.name = nameParent;
						parent.children.add(child);
						people.add(parent);
					}
					child.parents[0] = parent;
					check = true;
				}
				else if(child.parents[1] == null) {
					if(child.parents[0].name == nameParent) {
						check = true;
					}
					else {
						if(checkListParent.size() == 1) {
							parent = checkListParent.get(0);
							parent.children.add(child);
						}
						else {
							parent = new Person();
							parent.name = nameParent;
							parent.children.add(child);
							people.add(parent);
						}
						child.parents[1] = parent;
						child.parents[1].spouse.add(child.parents[0]);
						child.parents[0].spouse.add(child.parents[1]);
						check = true;
					}
				}
				else {
					check = false;
				}
			}
		}
		else {
			child = new Person();
			people.add(child);
			child.name = nameChild;
			if(checkListParent.size() == 1) {
				parent = checkListParent.get(0);
			}
			else {
				parent = new Person();
				parent.name = nameParent;
				people.add(parent);
			}
			child.parents[0] = parent;
			parent.children.add(child);
			check = true;
		}

		return check;
	}
	
	public String[] getParents(String name) {
		List<Person> person = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
		String[] parents = {};
		
		if(person.size() == 1) {
			Person checkPerson = person.get(0);
			parents = Stream.of(checkPerson.parents).map(p -> p.name).toArray(String[]::new);
		}
		 
		return parents;
	}
	
	public String[] getChildren(String name) {
		List<Person> person = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
		String[] children = {};
		
		if(person.size() == 1) {
			Person checkPerson = person.get(0);
			children = checkPerson.children.stream().map(c -> c.name).toArray(String[]::new);
		}
		return children;
	}
}
