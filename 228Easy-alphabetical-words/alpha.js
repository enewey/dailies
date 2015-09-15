	var alpha = function(a, b){ return (a.charCodeAt(0) >= b.charCodeAt(0)); };
	var reverse = function(a, b){ return (a.charCodeAt(0) <= b.charCodeAt(0)); };
	function testAlpha(word) {
		if (order(word, alpha)) return word+" IN ORDER";
		else if (order(word, reverse)) return word+" IN REVERSE ORDER";
		else return word+" NOT IN ORDER";
	}
	function order(word, comparator) {
		for (var i=1, arr = word.split(''); i<arr.length; i++) if (!comparator(arr[i], arr[i-1])) return false;
		return true;
	}