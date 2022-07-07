/**
 * to_LowerCase - Convert String to LowerCase
 */
public class ToLowerCase
{
	/*public class Solution
	{
		public String toLower(string S)
		{
			System.out.println(s);
		}
	}*/
	static String toLower(String S)
	{
		char caracter;
		String lower = "";
		
		int len = S.length();

		for (int i = 0; i < len; i++)
		{
			caracter = S.charAt(i);
			if (caracter >= 65 && caracter <= 90)
				caracter += 32;
			lower = lower + caracter;
		}
		return (lower);
	}

	public static void main(String[] args)
	{
		String reversed = "MAYUSCULA";

		System.out.println(reversed);
		reversed = toLower(reversed);
		System.out.println(reversed);
	}
}
