import java.util.ArrayList;

public class StandardDeviation 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<args.length; i++) { list.add(Integer.parseInt(args[i])); }
		double mean = 0;
		double variance = 0;
		for (int num : list) {	mean += num;	}
		mean /= list.size();
		for (int num : list) {
			double diff = Math.pow((num - mean),2);
			variance += diff;
		}
		variance /= list.size();
		double std = Math.round(Math.sqrt(variance) * 10000.0)/10000.0;
		System.out.println("Standard deviation: " + std);
	}
}
