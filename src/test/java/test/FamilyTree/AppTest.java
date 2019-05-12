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
		check1 = fam.isMale("TEST");
		fam.male("TEST");
		check2 = fam.isMale("TEST");
		assertTrue(!check1&check2);
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
		fam.setParent("TEST3", "TEST");
		fam.setParent("TEST3", "TEST2");
		String[] res = fam.getParents("TEST3");
		assertEquals(exp[0], res[0]);
	}
	
	public void testGetChildren() {
		Family fam = new Family();
		String[] exp = {"TEST", "TEST2"};
		fam.female("TEST3");
		fam.setParent("TEST3", "TEST");
		fam.setParent("TEST3", "TEST2");
		String[] res = fam.getChildren("TEST");
		
	}
	
	public void fullTest() {
		Family fam = new Family();
		Boolean frankPar1 = fam.setParent("Frank", "Morgan");
		Boolean frankPar2 = fam.setParent("Frank", "Dylan");
		fam.male("Dylan");
	}
}
