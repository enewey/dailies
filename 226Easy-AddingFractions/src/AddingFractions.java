import java.util.Vector;

public class AddingFractions {
	
	public static Vector<Long> addFrac(long a, long b, long x, long y) {
		long gcd, denom;
		while ((gcd = gcd(a,b)) != 1) { //Reduce first fraction
			a /= gcd;
			b /= gcd;
		}
		while ((gcd = gcd(x,y)) != 1) { //Reduce second fraction
			x /= gcd;
			y /= gcd;
		}
		if (b != y) { //Do cross multiplication, if necessary
			denom = y*b;
			a *= y;
			x *= b;
		} else {
			denom = y;
		}
		Vector<Long> ret = new Vector<Long>(2);
		ret.add(a+x); //Sum of numerators
		ret.add(denom); //Denominator
		return ret;
	}
	
	/**
	 * Implementation of the Euclidean algorithm
	 */
	public static long gcd(long a, long b) {
		if (a==b) return a; //GCD of two equal numbers
		long sub = Math.max(a, b) - Math.min(a, b); //Subtract smaller value from bigger value
		while (sub != 0) {
			if (a>b) a=sub; //Replace bigger value with the difference
			else b=sub;
			sub = Math.max(a, b) - Math.min(a, b); //Keep doing subtraction until sub is 0
		}
		return Math.min(a, b); //GCD will be the non-zero number after the final subtraction
	}
	
	public static void main(String[] args) {
		long a=0, b=0;
		String[] f = args[1].split("\\/");
		a = Long.parseLong(f[0]);
		b = Long.parseLong(f[1]);
		for (int i=2; i<args.length; i++) {
			String[] longs = args[i].split("\\/");
			Vector<Long> frac = addFrac(a,b,Long.parseLong(longs[0]),Long.parseLong(longs[1]));
			a = frac.get(0);
			b = frac.get(1);
		}
		long d;
		while ((d = gcd(a,b)) != 1){
			a /= d;
			b /= d;
		}
		System.out.println("Sum: " + a + " / " + b);
	}
}
