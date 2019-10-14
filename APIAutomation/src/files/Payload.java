package files;

public class Payload {

	public static String getPayload(String fname, String lname)
	{
		String payload = "{\r\n" + 
				"    \"name\": \""+fname+"\"\",\r\n" + 
				"    \"job\": \"\""+fname+"\"\r\n" + 
				"}";
		return payload;
	}
}
