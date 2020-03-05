import java.util.*;
public class CharOcurrMap
{
	public static void countChar(String str)
	{
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		char[] arr= str.toCharArray();

		for (Character c:arr ) 
		{
			if(map.containsKey(c))
			{
				map.put(c,map.get(c)+1);
			}	
			else
			{
				//if it's not avail set value to 1
				map.put(c,1);
			}
		}
		Set<Map.Entry<Character,Integer>> eSet = map.entrySet();
		System.out.println(eSet);
	}
	public static void main(String[] args) {
		countChar("Test Yantra Sofware Solutions");
	}
}