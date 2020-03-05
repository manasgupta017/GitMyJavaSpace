public class CharOccur
{
	public static int countChar(String str , char c)
	{
		char[] arr = str.toCharArray();
		int count =0;
		for (int i=0;i<arr.length ; i++) 
		{
				if(arr[i] == c)
				{
					count++;
				}
		}
		return count;
	}
	public static void countEveryChar(String str , char c)
	{
		int count = countChar(str,c);
		System.out.print(c+" "+count+"\n");
	}
	public static void main(String[] args) {
		//int count = countChar("missisippi",'s');
		//System.out.println(count);
		String str = "Jspiders and Qspiders";
		//char[] arr =str.toCharArray();
		for (int i=0;i<str.length() ;i++ ) {
			countEveryChar(str,str.charAt(i));
		}
	}
}