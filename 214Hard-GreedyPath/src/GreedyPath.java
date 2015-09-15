import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class GreedyPath 
{
	final public static String FILENAME = "bonus.txt";
	
	static double getPath(Vector<SimplePoint> points)
	{
		double totalDist = 0.0;
		int iteratorCount = 0;
		
		SimplePoint currentPoint = new SimplePoint(0.5f, 0.5f);
		while (!points.isEmpty())
		{
			double shortestDist = 100.0; //arbitrary large value
			
			//Initialize starting conditions of iteration through list
			Iterator<SimplePoint> iterator = points.iterator();
			int indexOfCurrentPoint = -1;
			int indexOfShortestPoint = 0;
			
			//Start iterating through the list to find the shortest distance
			//	between currentPoint and a point within the list.
			while (iterator.hasNext())
			{
				indexOfCurrentPoint++;
				SimplePoint nextPoint = iterator.next();
				
				//Get the distance between points
				double dist = currentPoint.getDist(nextPoint);
				if (dist < shortestDist){
					shortestDist = dist;
					indexOfShortestPoint = indexOfCurrentPoint;
				}
			}	//End of iteration
			
			iteratorCount++;
			if (iteratorCount%100 == 0)
				System.out.println("Finished iterator count " + iteratorCount);
			
			totalDist += shortestDist;
			currentPoint = points.remove(indexOfShortestPoint);
		}
		
		return totalDist;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		Vector<SimplePoint> points = new Vector<SimplePoint>();
		int numOfPoints; //Not actually used currently...
		
		if (args.length == 0)
		{
			try {
				FileReader fr = new FileReader(FILENAME);
				BufferedReader br = new BufferedReader(fr);
				
				String line;
				numOfPoints = Integer.parseInt(br.readLine());
				while ((line = br.readLine()) != null)
				{
					String[] lineSplit = line.split(" ");
					points.add(
						new SimplePoint(Float.parseFloat(lineSplit[0]), Float.parseFloat(lineSplit[1]))
					);
					
				}
				
				System.out.println("Done reading file");
				br.close();
			} catch (FileNotFoundException e) { 
			} catch (IOException e) {
			}
		}
		else if (args.length%2 != 1)
		{
			System.out.println("Invalid argument length!");
			return;
		}
		else 
		{
			numOfPoints = Integer.parseInt(args[0]);

			for (int i=2; i<args.length; i+=2)
			{
				points.add(
					new SimplePoint(Float.parseFloat(args[i-1]), Float.parseFloat(args[i]))
				);
			}	
		}
		System.out.println("" + getPath(points));
	}
}

class SimplePoint
{
	float x,y;
	
	public SimplePoint(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getDist(SimplePoint point)
	{
		return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y-this.y, 2));
	}
}