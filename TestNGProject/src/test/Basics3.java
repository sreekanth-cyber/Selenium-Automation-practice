package test;

import java.io.IOException;

import org.testng.annotations.Test;

public class Basics3 extends GlobalVariables{

	@Test
	public void WebDebitCardMethod1()
	{
		System.out.println("Debit Card Web Method TestCase 1");
	}
	@Test
	public void WebDebitCardMethod2()
	{
		System.out.println("Debit Card Web Method TestCase 2");
	}
	@Test
	public void launchbrowser() throws IOException
	{
		login();
	}
}
