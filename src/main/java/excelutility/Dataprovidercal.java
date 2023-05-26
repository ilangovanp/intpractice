package excelutility;

import java.util.Map;

import org.testng.annotations.Test;

public class Dataprovidercal {

	
	@Test(dataProvider="dp",dataProviderClass=excelutility.Mapindataprovider.class)
	public void getdata(Map h)  {
		
		String usernames=h.get("Username").toString();
		String Password=h.get("Password").toString();
		String dateofbirth=h.get("DateOfBirth").toString();
		
		System.out.println(usernames+" "+Password+" "+dateofbirth);

	}

}
