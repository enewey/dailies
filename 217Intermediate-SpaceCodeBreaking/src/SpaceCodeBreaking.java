import java.util.ArrayList;
import java.util.Collections;

public class SpaceCodeBreaking 
{
	final static String VOWELS_AND_SPACES = "AEIOU ";
	final static String[] PLANETS = {"OmicronV", "Hoth", "RyzaIV", "Htrae"};
	
	public SpaceCodeBreaking(ArrayList<ArrayList<Integer>> input)
	{
		for (ArrayList<Integer> list : input)
		{
			StringBuffer[] strings = new StringBuffer[4];
			for (int i=0; i<4; i++) strings[i] = new StringBuffer();
			for (int num : list)
			{
				strings[0].append((char)(num^16));
				strings[1].append((char)(num-10));
				strings[2].append((char)(num+1));
				strings[3].insert(0, ((char)(num)));
			}
			ArrayList<Integer> check = new ArrayList<Integer>();
			check.add(vowelAndSpaceCount(strings[0].toString()));
			check.add(vowelAndSpaceCount(strings[1].toString()));
			check.add(vowelAndSpaceCount(strings[2].toString()));
			check.add(vowelAndSpaceCount(strings[3].toString()));

			int corr = check.indexOf(Collections.max(check)); //Correct answer will have most spaces & vowels
			System.out.println(PLANETS[corr] + " => " + strings[corr].toString());
		}
	}
	
	private int vowelAndSpaceCount(String in)
	{
		int count=0;
		for (int i=0; i<in.length(); i++)
			if (VOWELS_AND_SPACES.toUpperCase().contains(in.charAt(i)+"".toUpperCase())) count++;
		return count;
	}
	
	public static void main(String[] args) 
	{
		//Parse the arguments
		ArrayList<ArrayList<Integer>> send = new ArrayList<ArrayList<Integer>>();
		int counter = 0;
		for (String s : args) 
		{
			String[] sp = s.split(" ");
			send.add(new ArrayList<Integer>());
			for (String n : sp)
				if (n.equals("")) continue;
				else send.get(counter).add(Integer.parseInt(n));
			counter++;
		}
		
		new SpaceCodeBreaking(send);
	}
}
