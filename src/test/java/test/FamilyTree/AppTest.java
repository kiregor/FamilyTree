package test.FamilyTree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
	public void testMale() {
		Family fam = new Family();
		Boolean test = fam.male("TEST");
		assert(test);
	}
	
}
