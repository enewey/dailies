public class SquareSpirals {
	public SquareSpirals(int size, int count) {
		int x = (size/2)+1;
		int y = x-1;
		long corners = 0, counter=2;
		for (long i = 0; counter < Long.MAX_VALUE; i+=8, counter+=i, corners++) {
			x+=1;
			y+=1;
			if (count < counter)
				break;
		}
		long maxStop = (corners*2)+1;
		foundIteration:
		for (int s=-1; counter!=count; s*=-1){
			long stop = maxStop--;
			while (stop-- > 0){
				x += s;
				counter--;
				if (counter==count) break foundIteration;
			}
			stop = maxStop;
			while (stop-- > 0) {
				y += s;
				counter--;
				if (counter==count) break foundIteration;
			}
		}
		System.out.println("("+x+","+y+")");
	}
	
	public SquareSpirals(int size, int findX, int findY) {
		int mid = ((size/2) + 1);
		int vecX = mid-findX < 0 ? 1 : -1;
		int vecY = mid-findY < 0 ? 1 : -1;
		int limit = Math.abs(mid-findX) > Math.abs(mid-findY) ? findX : findY;
		
		 // up-left case
		int x = mid-1; //position of y to start from
		int y = mid-1; //position of y to start from
		int s = 1; //which way we move x/y when finding the iteration
		long iteration = 5, i=4; //iteration = # in spiral, i = counting mechanism
		
		if (vecX >= 0 && vecY < 0) { //up-right case
			iteration = 3;
			i = 2;
			x = mid+1; 
			y = mid-1;
		}
		else if (vecX >= 0 && vecY >= 0) { //down-right case
			iteration = 2;
			i = 0;
			x = mid+1; 
			s = -1;
		}
		else if (vecX < 0 && vecY >= 0) { //down-left case
			iteration = 7;
			i = 6;
			x = mid-1; 
			y = mid+1;
			s = -1;
		}
		for (; x!=limit && y!=limit; i+=8, iteration+=i, x+=vecX, y+=vecY); //find the ballpark estimate
		for (; (x!=findX || y!=findY); iteration--){ //hone in on the answer
			if (x!=findX) { x += s; }
			else { y += s; }
		}
		System.out.println(iteration);
	}
	
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		if (args.length > 2)
			new SquareSpirals(size, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		else
			new SquareSpirals(size, Integer.parseInt(args[1]));
	}
}
