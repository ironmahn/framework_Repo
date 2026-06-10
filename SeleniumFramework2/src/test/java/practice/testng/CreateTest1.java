package practice.testng;

import org.testng.annotations.Test;

public class CreateTest1 {
	
	@Test
	public void createContactTest() {
		System.out.println("execute createContact with ---->HDFC");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("Execute query modifyContactTest ---HDFC-->ICICI");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("Execute deleteContactTest ICICI");
	}

}
