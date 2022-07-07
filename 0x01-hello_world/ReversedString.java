/**
 * ReversedString - reversed String
 */
public class ReversedString
{
	/*public class Solution
	{
		public String toLower(string S)
		{
			System.out.println(s);
		}
	}*/
	static String rev(String S)
	{
		char caracter;
		String reversed = "";
		
		int len = S.length();

		for (int i = 0; i < len; i++)
		{
			caracter = S.charAt(i);
			reversed = caracter + reversed;
		}
		return (reversed);
	}

	public static void main(String[] args)
	{
		String reversed = "ANTES DE REVERSAR";

		System.out.println(reversed);
		reversed = rev(reversed);
		System.out.println(reversed);
	}
}
