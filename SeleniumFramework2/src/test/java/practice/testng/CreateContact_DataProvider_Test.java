package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider_Test {
	
	@Test(dataProvider = "getData")
	public void CreateContactTest(String firstName, String lastName, long phoneNumber) {
		System.out.println("FirstName :" + firstName + ", LastName:" + lastName + "phoneNumber: " + phoneNumber) ;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		objArr[0][0] = "pankaj";
		objArr[0][1] = "hr";
		objArr[0][2] = 9876543210l;

		objArr[1][0] = "sam";
		objArr[1][1] = "sh";
		objArr[1][2] = 03214452455l;

		
		objArr[2][0] = "john";
		objArr[2][1] = "smith";
		objArr[2][2] = 03214452425l;

		
		return objArr;
		
	}

}
