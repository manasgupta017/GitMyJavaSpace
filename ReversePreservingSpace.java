public class ReversePreservingSpace
{
	public static String reverse(String str)
	{
		char[] inputArray = str.toCharArray();
		char[] result = new char[inputArray.length];

		//locate the spaces & put them in result
		for(int i=0;i<inputArray.length;i++)
		{
			if(inputArray[i] == ' ')
			{
				result[i] = inputArray[i];
			}
		}
		int j=inputArray.length -1;//denotes last index of result array
		//traversing inputString and putting it in resultArray from reverse
		for(int i=0;i<inputArray.length;i++)
		{
			//ignore space in input string
			if(inputArray[i] != ' ')
			{
				//ignoring space in result array
				if(result[j] == ' ')
				{
					j--;
				}
				result[j] = inputArray[i];
				j--;
			}
		}
		return String.valueOf(result);
	}
	public static void main(String[] args) {
		String rev = reverse("India is my country");
		System.out.println(rev);
	}
}