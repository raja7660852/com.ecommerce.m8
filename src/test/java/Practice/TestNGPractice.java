package Practice;

import org.testng.annotations.Test;



public class TestNGPractice {
      
	@Test(priority = 1)
	public void createuser()
	{
		System.out.println("Create");
	}

	@Test(priority = 1)
	public void bodifyuser()
	{
		System.out.println("Modify");
	}
	
	@Test(priority=2)
	public void aeleteuser()
	{
		System.out.println("delete");
	}


}
