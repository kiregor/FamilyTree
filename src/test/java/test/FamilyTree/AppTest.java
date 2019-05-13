package test.FamilyTree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
	public void testMale() {
		Family fam = new Family();
		Boolean test = fam.male("TEST");
		assertTrue(test);
	}
	
	public void testFemale() {
		Family fam = new Family();
		Boolean test = fam.female("TEST2");
		assertTrue(test);
	}
	
	public void testFemaleWithSameNameAsMale() {
		Family fam = new Family();
		fam.male("TEST");
		Boolean test = fam.female("TEST");
		assertTrue(!test);
	}
	
	public void testIsMale() {
		Family fam = new Family();
		Boolean check1, check2;
		check1 = !fam.isMale("TEST");
		fam.male("TEST");
		check2 = fam.isMale("TEST");
		assertTrue(check1&check2);
	}
	
	public void testIsFemale() {
		Family fam = new Family();
		Boolean check1, check2;
		check1 = fam.isFemale("TEST");
		fam.female("TEST");
		check2 = fam.isFemale("TEST");
		assertTrue(!check1&check2);
	}
	
	public void testSetParent() {
		Family fam = new Family();
		Boolean check;
		fam.female("TEST");
		check = fam.setParent("TEST", "TEST2");
		assertTrue(check);
	}
	
	public void testGetParent() {
		Family fam = new Family();
		String[] exp = {"TEST", "TEST2"};
		fam.female("TEST3");
		System.out.println(exp[0] + " " + exp[1]);
		fam.setParent("TEST3", "TEST");
		System.out.println(exp[0] + " " + exp[1]);
		fam.setParent("TEST3", "TEST2");
		System.out.println(exp[0] + " " + exp[1]);
		String[] res = fam.getParents("TEST3");
		System.out.println(res[0] + " " + res[1]);
		assertEquals(exp[0], res[0]);
	}
	
	public void testGetChildren() {
		Family fam = new Family();
		String[] exp = {"TEST2"};
		fam.female("TEST2");
		fam.setParent("TEST2", "TEST");
		String[] res = fam.getChildren("TEST");
		assertEquals(exp[0], res[0]);
	}
	
	public void testFull() {
		Family fam = new Family();
		Boolean check;
		check = fam.setParent("Frank", "Morgan");
		System.out.println(check + " - Frank Parent Morgan");
		check = check && fam.setParent("Frank", "Dylan");
		System.out.println(check + " - Frank Parent Dylan");
		check = check && fam.male("Dylan");
		System.out.println(check + " - Dylan Male");
		check = check && fam.setParent("Joy", "Frank");
		System.out.println(check + " - Joy Parent Frank");
		check = check && fam.male("Frank");
		System.out.println(check + " - Frank Male");
		check = check && !fam.male("Morgan");
		System.out.println(check + " - Morgan Male");
		check = check && fam.setParent("July", "Morgan");
		System.out.println(check + " - July Parent Morgan");
		check = check && (!fam.isMale("Joy") || fam.isFemale("Joy"));
		System.out.println(check + " - Joy Male/Female");
		String[] test = {"Frank", "July"};
		check = check && (fam.getChildren("Morgan").equals(test));
		System.out.println(check + " - Morgan Children");
		check = check && fam.setParent("Jennifer", "Morgan");
		System.out.println(check + " - Jennifer Parent Morgan");
		test = new String[] {"Frank", "July", "Jennifer"};
		check = check && (fam.getChildren("Morgan").equals(test));
		System.out.println(check + " - Morgan Children 2");
		test = new String[] {"Frank"};
		check = check && (fam.getChildren("Dylan").equals(test));
		System.out.println(check + " - Dylan Children");
		test = new String[] {"Morgan", "Dylan"};
		check = check && !fam.setParent("Morgan", "Frank");
		System.out.println(check + " - Morgan Parent Frank");
		assertTrue(check);
	}
}
