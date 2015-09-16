	function wordBalancer(word) {
		for (var i=0; i<word.length; i++) {
			var left=0, right=0; 
			for (var k=1; k<=i; k++) left += (word.charAt(i-k).charCodeAt(0) - 64)*k;
			for (var k=1; i+k<word.length; k++) right += (word.charAt(i+k).charCodeAt(0) - 64)*k;
			if (left==right) 
				return word.slice(0,i) + " " + word.charAt(i) + " " + word.slice(i+1, word.length) + " - " + left;
		}
		return word + " DOES NOT BALANCE";
	}