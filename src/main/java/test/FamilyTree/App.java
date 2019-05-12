package test.FamilyTree;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Family fam = new Family();
		String[] exp = {"TEST", "TEST2"};
		fam.female("TEST3");
		fam.setParent("TEST3", "TEST");
		fam.setParent("TEST3", "TEST2");
		String[] res = fam.getChildren("TEST");
    }
}
