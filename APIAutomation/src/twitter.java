import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class twitter {

	String ConsumerKey ="2Xtd4ILUtinfACHehAvCNcbjW";
	String ConsumerSecret ="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token ="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret ="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	@Test
	public void createTweet()
	{
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		Response res = given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		queryParam("status","This is my tweet through automation").
		when().
		post("/update.json").
		then().extract().response();
		
		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String id = js.get("id").toString();
		String text = js.get("text").toString();
		System.out.println(id);
		System.out.println(text);
		
		given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		when().post("/destroy/"+id+".json").
		then().assertThat().statusCode(200);
	}
}
