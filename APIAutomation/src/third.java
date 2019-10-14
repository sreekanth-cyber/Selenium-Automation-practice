import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class third {
	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\sree\\APIAutomation\\src\\files\\data.properties");
		prop.load(fis);
		//prop.getProperty("JIRAHOST");
	}
	
	
	@Test
	public void APITest1()
	{
		//step1
		RestAssured.baseURI = prop.getProperty("JIRAHOST");
		Response res = given().
		given().
		header("Content-Type","application/json").
		body("{\"username\": \"sreekanth\",\"password\": \"J@v@l!1234\"}").
		when().
		post("rest/auth/1/session").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		extract().response();
		
		//step2
		String responseString =  res.asString();
		System.out.println(responseString);
		
		JsonPath js = new JsonPath(responseString);
		String session_id = js.get("session.value");
		System.out.println(session_id);
		
		//step3
		Response res1 = given().
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+session_id).
		body("{\r\n" + 
				"	\"fields\":\r\n" + 
				"	{\r\n" + 
				"		\"project\":\r\n" + 
				"		{\r\n" + 
				"			\"key\": \"MSSP\"\r\n" + 
				"		},\r\n" + 
				"		\"summary\": \"something's wrong with the app\",\r\n" + 
				"		\"description\": \"This is a new bug\",\r\n" + 
				"		\"issuetype\":\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"Bug\"\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}").
		when().
		post("rest/api/2/issue").
		then().assertThat().statusCode(201).extract().response();
		String responseString1 = res1.asString();
		System.out.println(responseString1);
		
		JsonPath js1 = new JsonPath(responseString1);
		String issue_id = js1.get("id");
		System.out.println(issue_id);

		//step4
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+session_id).
		body("{\r\n" + 
				"	\"body\": \"This is my test comment through automation\",\r\n" + 
				"	\"visibility\":\r\n" + 
				"	{\r\n" + 
				"		\"type\": \"role\",\r\n" + 
				"		\"value\": \"Administrators\"\r\n" + 
				"	}\r\n" + 
				"}").
		when().
		post("rest/api/2/issue/"+issue_id+"/comment").
		then().assertThat().statusCode(201).extract().response();
	}

}
