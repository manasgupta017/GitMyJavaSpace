import java.util.*;
public class RevTreeMap
{
	public static void main(String[] args) {
		TreeMap<Integer,Character> map = new TreeMap<>(new IntRev());
		map.put(12,'A');
		map.put(85,'B');
		map.put(23,'C');
		map.put(1,'D');
		map.put(2,'E');
		System.out.println(map);

		TreeMap<String,Integer> map1 = new TreeMap<>(new StringRev());
		map1.put("manas",21);
		map1.put("jai",21);
		System.out.println(map1);

		TreeSet<StringBuffer> set = new TreeSet<>(new BuffSort());
		set.add(new StringBuffer("Manas"));
		set.add(new StringBuffer("Jai"));
		System.out.println(set);
	}
}
class IntRev implements Comparator<Integer>
{
	public int compare(Integer i1 , Integer i2)
	{
		return -(i1-i2);
	}	
}
class StringRev implements Comparator<String>
{
	public int compare(String i1 , String i2)
	{
		return -i1.compareTo(i2);
	}	
}
class BuffSort implements Comparator<StringBuffer>
{
	public int compare(StringBuffer s1 , StringBuffer s2)
	{
		String str1 = s1.toString();
		String str2 = s2.toString();
		return (str1.compareTo(str2));
	}
}
/*
	let a , b are 2 int values

	a-b > 0 (a>b){b , a}

	a-b <0 (b>a){a,b}

	a-b =0 (b=a)

	TreeMap()
	TreeMap(SortedSet)
	TreeMap(Map)
	TreeMap(Comparator)

	Wrapper Classes and String class implements Comparable
*/