package test.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
	String name;
	String gender;
	String[] parents;
	List<String> children;
	
	public Person() {
		parents = new String[2];
		children = new ArrayList<String>();
	}
	
	public String getName(){
		return name;
	}
	
	public String getGender() {
		return gender;
	}
}
