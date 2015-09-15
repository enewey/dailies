import java.util.ArrayList;

public class SadCycle 
{
	public static ArrayList<Long> sadCycle(long base, long start)
	{		
		ArrayList<Long> cycle;//return value;
		ArrayList<Long> values = new ArrayList<Long>(); //sequential list of values
		
		String parseMe = start + "";
		while (true) 
		{
			long val = 0;
			for (int i=0; i<parseMe.length(); i++) //iterate through number as a string
				val += Math.pow(Long.parseLong(parseMe.charAt(i)+""), base);

			if (values.contains(val))
			{
				int pos = values.indexOf(val);
				cycle = new ArrayList<Long>(values.subList(pos, values.size()-1));
				break;
			}
			else 
			{
				values.add(val);
				parseMe = val+"";
			}
		}
		
		return cycle;
	}
	
	public static void main(String[] args) 
	{
		if (args.length != 2)
			return;
		
		long base = Long.parseLong(args[0]);
		long start = Long.parseLong(args[1]);
		
		ArrayList<Long> cycle = sadCycle(base, start);
		String ret = ""+cycle.get(0);
		for (int i=1; i<cycle.size(); i++)
			ret += ", " + cycle.get(i);
			
		System.out.println(ret);
	}
}
