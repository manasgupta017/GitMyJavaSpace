class Junk
{
	static int count=0;
	Junk()
	{
		count = count +1;
	}
	public static void main(String[] args) {
		Junk j1 = new Junk();
		Junk j2 = new Junk();
		Junk j3 = new Junk();
		Junk j4 = new Junk();
		Junk j5 = new Junk();
		Junk j6 = new Junk();
		System.out.println(Junk.count);

	}
}