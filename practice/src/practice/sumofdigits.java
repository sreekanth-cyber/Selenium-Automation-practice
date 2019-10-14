package practice;

public class sumofdigits {

	public static void main(String args[])
	{
		int ip=4235,sum=0;
		char[] c = Integer.toString(ip).toCharArray();
		for(int i=0;i<c.length;i++)
		{
			sum = sum + Integer.parseInt(Character.toString(c[i]));
		}
		System.out.println(sum);
	}
		
}
