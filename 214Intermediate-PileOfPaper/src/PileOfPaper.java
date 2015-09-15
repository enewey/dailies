public class PileOfPaper 
{
	static public int[] doPile(int[] paper)
	{
		short[][] pile;
		int width,height;
		
		width = paper[0];
		height = paper[1];
		
		pile = new short[width][height];
		
		int highestColor = 0;
		for (int i=6; i<paper.length; i+=5)
		{
			int x,y,w,h;
			short color;
			color = (short)	paper[i-4];
			x = 		paper[i-3];
			y = 		paper[i-2];
			w = 		paper[i-1];
			h = 		paper[i];
			
			if (highestColor < color)
				highestColor = (int)color;
			
			for (int j=x; j<w+x && j<width; j++)
				for (int k=y; k<h+y && k<height; k++)
					pile[j][k] = color;
		}
		
		int[] areas = new int[highestColor+1];
		
		for (int j=0; j<width; j++)
			for (int k=0; k<height; k++)
				areas[pile[j][k]]++;
		
		return areas;
	}
	
	static public int[] parseArgs(String[] args)
	{
		int[] argsToInt;
		
		if ((args.length - 2)%5 != 0)
			return null;
	
		argsToInt = new int[args.length];
		for (int i = 0; i < args.length; i++)
			argsToInt[i] = Integer.parseInt(args[i]);
		
		return argsToInt;
	}
	
	public static void main(String[] args) 
	{
		int[] paper;
		if ((paper=parseArgs(args)) == null)
		{
			System.out.println("Invalid argument length.");
			return;
		}
		
		int[] ret = doPile(paper);
		for (int i=0; i<ret.length; i++)
		{
			System.out.println(i +" " + ret[i]);
		}
	}

}
