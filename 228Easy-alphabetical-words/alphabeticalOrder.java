public class alphabeticalOrder {

	 public static void main (String args[]){
	    String[] input = {"billowy", "biopsy", "chinos", "defaced", "chintz", "sponge", "bijoux", "abhors", "fiddle", "begins", "chimps", "wronged"};
	    for (String r: input){
	        String word = r.toLowerCase();
	        int temp = 1;
	        for (int i = 0; i<word.length()-1; i++){
                if ((int) word.charAt(i) <= (int) word.charAt(i+1)){
                    temp++;
                }   
	        }
	        if (temp == word.length()){
	            System.out.println(r + ": is in order");
	        }
            else if (temp == 1){
                System.out.println(r + ": is in reverse order");
            }
            else {
                System.out.println(r + ": is not in order");
            }
	    }
	}
}