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
}
