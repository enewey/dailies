import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Discrepancy 
{
	final static String FILENAME = "input.txt";
	
	public static void main(String[] args) 
	{
		try {
			FileReader fr = new FileReader(FILENAME);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null)
			{
				//System.out.println("Doing line...");
				doDiscrepancy(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void doDiscrepancy(String line)
	{
		int biggestDiscrepancy = -1;
		int ret_n=0, ret_x=0, ret_y=0;
		
		StringBuilder builder = new StringBuilder(line);
		//System.out.println("Length of line: "+line.length());
		
		for (int i=0; i<=line.length(); i++)
		{
			for (int j=i; j<=line.length(); j++)
			{
				//System.out.println("Starting "+i+","+j);
				char[] sub = builder.substring(i,j).toCharArray();
				System.out.print("");
				for (int n=1; n<(j-i); n++)
				{
					int discrepancy = 0;
					for (int k = 0; k < sub.length; k+=n)
					{
						if (sub[k] == 'a')
							discrepancy++;
						else if (sub[k] == 'b')
							discrepancy--;
					}
					
					if (Math.abs(discrepancy) > biggestDiscrepancy)
					{
						biggestDiscrepancy = Math.abs(discrepancy);
						ret_n=n;
						ret_x=i;
						ret_y=j;
					}
				}
			}
		}
		
		System.out.println("" + biggestDiscrepancy + " ["+ret_x+":"+ret_y+":"+ret_n+"]");
	}
}
