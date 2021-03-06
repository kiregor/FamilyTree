package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Family {
	List<Person> people;

	public Family() {
		people = new ArrayList<Person>();
	}

	public boolean male(String name) {
		boolean check = false;

		Optional<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).findFirst();

		if (checkList.isPresent()) {
			Person updatePerson = checkList.get();
			if(!updatePerson.checkSpouse("male")) {
				if (updatePerson.getGender() == "female") {
					check = false;
				} else {
					updatePerson.setGender("male");
					check = true;
				}
			}
			else {
				check = false;
			}
		} else {
			Person newPerson = new Person();
			newPerson.setName(name);
			newPerson.setGender("male");
			people.add(newPerson);
			check = true;
		}

		return check;
	}

	public boolean female(String name) {
		boolean check = false;

		Optional<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).findFirst();

		if (checkList.isPresent()) {
			Person updatePerson = checkList.get();
			if(!updatePerson.checkSpouse("female")) {
				if (updatePerson.getGender() == "male") {
					check = false;
				} else {
					updatePerson.setGender("female");
					check = true;
				}
			}
			else {
				check = false;
			}
		} else {
			Person newPerson = new Person();
			newPerson.setName(name);
			newPerson.setGender("female");
			people.add(newPerson);
			check = true;
		}

		return check;
	}

	public boolean isMale(String name) {
		boolean check = false;

		Optional<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).findFirst();

		if (checkList.isPresent()) {
			Person updatePerson = checkList.get();
			if (updatePerson.getGender() == "male") {
				check = true;
			} else {
				check = false;
			}
		} else {
			Person newPerson = new Person();
			newPerson.setName(name);
			people.add(newPerson);
			check = false;
		}

		return check;
	}

	public boolean isFemale(String name) {
		boolean check = false;

		Optional<Person> checkList = people.stream().filter(p -> p.getName().equals(name)).findFirst();

		if (checkList.isPresent()) {
			Person updatePerson = checkList.get();
			if (updatePerson.getGender().equals("female")) {
				check = true;
			} else {
				check = false;
			}
		} else {
			Person newPerson = new Person();
			newPerson.setName(name);
			people.add(newPerson);
			check = false;
		}

		return check;
	}

	public boolean setParent(String nameChild, String nameParent) {
		Boolean check = false;
		Person child, parent;

		Optional<Person> checkListChild = people.stream().filter(p -> p.getName().equals(nameChild)).findFirst();
		Optional<Person> checkListParent = people.stream().filter(p -> p.getName().equals(nameParent)).findFirst();

		if (checkListChild.isPresent()) {
			child = checkListChild.get();
			if (!child.checkParents(nameChild)) {
				if (child.getParents().get().size() == 0) {
					if (checkListParent.isPresent()) {
						parent = checkListParent.get();
						parent.addToChildren(child);
					} else {
						parent = new Person();
						parent.setName(nameParent);
						parent.addToChildren(child);
						people.add(parent);
					}
					child.setParent(parent, 0);
					check = true;
				} else if (child.getParents().isPresent() && !child.getParents().get().isEmpty()) {
					if(child.getParents().get().stream().anyMatch(p -> p.getName().equals(nameChild)))
						check = false;
					else {
						if (checkListParent.isPresent()) {
							parent = checkListParent.get();
							parent.addToChildren(child);
						} else {
							parent = new Person();
							parent.setName(nameParent);
							parent.addToChildren(child);
							people.add(parent);
						}
					
						child.setParent(parent, 1);
						child.getParents().get().get(1).getSpouse().add(child.getParents().get().get(0));
						child.getParents().get().get(0).getSpouse().add(child.getParents().get().get(1));
						check = true;
					}
				} else {
					check = false;
				}
			}
		} else {
			child = new Person();
			people.add(child);
			child.setName(nameChild);
			if (checkListParent.isPresent()) {
				parent = checkListParent.get();
			} else {
				parent = new Person();
				parent.setName(nameParent);
				people.add(parent);
			}
			child.setParent(parent, 0);
			parent.addToChildren(child);
			check = true;
		}

		return check;
	}

	public String[] getParents(String name) {
		Optional<Person> person = people.stream().filter(p -> p.getName().equals(name)).findFirst();
		String[] parents = {};

		if (person.isPresent()) {
			Person checkPerson = person.get();
			parents = checkPerson.getParents().get().stream().map(p -> p.getName()).sorted().toArray(String[]::new);
		}

		return parents;
	}

	public String[] getChildren(String name) {
		Optional<Person> person = people.stream().filter(p -> p.getName().equals(name)).findFirst();
		String[] children = {};

		if (person.isPresent()) {
			Person checkPerson = person.get();
			children = checkPerson.getChildren().stream().map(c -> c.getName()).sorted().toArray(String[]::new);
		}
		return children;
	}
}
