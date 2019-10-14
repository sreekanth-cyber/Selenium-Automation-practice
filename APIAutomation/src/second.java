import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import files.Payload;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class second {
	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\sree\\APIAutomation\\src\\files\\data.properties");
		prop.load(fis);
		prop.getProperty("HOST");
	}
	
	
	@Test(dataProvider="NameData")
	public void APITest1(String fname,String lname)
	{
		//step1
		RestAssured.baseURI = prop.getProperty("HOST");
		Response res = given().
		given().
		param("page","2").
		/*body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").*/
		when().
		get(resources.resourceData()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		extract().response();
		
		//step2
		String responseString =  res.asString();
		System.out.println(responseString);
		
		JsonPath js = new JsonPath(responseString);
		String finame = js.get("data[0].first_name");
		System.out.println(finame);
		
		//step3
		Response res1 = given().
		given().
		body(Payload.getPayload(fname,lname)).
		when().
		put(resources.resourceDataPut()).
		then().assertThat().statusCode(200).extract().response();
		String responseString1 = res1.asString();
		System.out.println(responseString1);

	}
	
	@DataProvider(name="NameData")
	public Object[][] getValues()
	{
		return new Object[][] {{"test1","test2"},{"test3","test4"},{"test5","test6"}};
	}
}
