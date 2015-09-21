import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class XSNameChainTest {
	@SuppressWarnings("unchecked")

	XSNameChain _nc = null; 
	
	@Before
	public void setUp() throws Exception{
		_nc = new XSNameChain();
	}
	
	@Test
	public void testFirstChar1() {
		assertEquals(_nc.getFirstChar("John Lennon"),"John");
	}
	
	@Test
	public void testFirstChar2() {
		assertEquals(_nc.getFirstChar("John "),"John");
	}
	
	@Test
	public void testFirstChar3() {
		assertEquals(_nc.getFirstChar("John Lennon Smith"),"John");
	}
	
	@Test
	public void testFirstChar4() {
		assertEquals(_nc.getFirstChar(" Lennon"),"");
	}
	
	@Test
	public void testFirstChar5() {
		assertEquals(_nc.getFirstChar(" "),"");
	}
	
	@Test
	public void testLastChar1() {
		assertEquals(_nc.getLastChar("John Lennon"),"Lennon");
	}
	
	@Test
	public void testLastChar2() {
		assertEquals(_nc.getLastChar("John "),"");
	}
	
	@Test
	public void testLastChar3() {
		assertEquals(_nc.getLastChar("John Lennon Smith"),"Lennon Smith");
	}
	
	@Test
	public void testLastChar4() {
		assertEquals(_nc.getLastChar(" Lennon"),"Lennon");
	}

	@Test
	public void testLastChar5() {
		assertEquals(_nc.getLastChar(" "),"");
	}
	
	@Test
	public void testNameChain1(){
		assertEquals(_nc.maxPathLength,0);
	}
	
	
	@SuppressWarnings("static-access")
	
	public void run() {
		String[] test = {"Elton John","Lebron James","James Faulkner","James Elton","John Lennon"};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,4);
	}
	
	public void run1() {
		String[] test = {"Elton John","Lebron James","James Faulkner","James Elton","John Lennon"};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,4);
	}
	
	public void run2() {
		String[] test = {"Elton John","James Elton","John Lennon"};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,3);
	}
	
	public void run3() {
		String[] test = {"Elton John","Lebron James","James Faulkner","John Lennon"};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,2);
	}
	
	public void run4() {
		String[] test = {"Lebron James","John Lennon"};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,1);
	}
	
	public void run5() {
		String[] test = {"Elton John"};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,1);
	}
	public void run6() {
		String[] test = {""};
		_nc.getNameChain(test);
		assertEquals(_nc.maxPathLength,0);
	}
}

