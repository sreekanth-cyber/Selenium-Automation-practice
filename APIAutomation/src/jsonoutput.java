import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class jsonoutput {
	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\sree\\APIAutomation\\src\\files\\data.properties");
		prop.load(fis);
		prop.getProperty("HOST");
	}
	
	
	@Test
	public void APITest1() throws IOException
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
		body(GenerateStringFromResource("C:\\Users\\Online Test\\Documents\\jsoninput.json")).
		when().
		put(resources.resourceDataPut()).
		then().assertThat().statusCode(200).extract().response();
		String responseString1 = res1.asString();
		System.out.println(responseString1);

	}
	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
