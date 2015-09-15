	function makeCard(input, idNo) { //assuming length 4
		return {
			id : idNo, //unique identifier for this card
			shape : input.charAt(0),
			color : input.charAt(1),
			number : input.charAt(2),
			shading : input.charAt(3),
			str : function() { return this.shape + this.color + this.number + this.shading; }
		};
	}

	function determineMatch(cardA, cardB, cardC) {
		for (var k in cardA)
			if (!((cardA[k] == cardB[k] && cardB[k] == cardC[k]) || 
				  (cardA[k] != cardB[k] && cardC[k] != cardB[k] && cardC[k] != cardA[k])))
				return false;
		return true;
	}

	function findSets() {
		var cards = [];
		var sets = [];

		for (var i=2; i<process.argv.length; i++)
			cards.push(makeCard(process.argv[i], i-2));

		for (var i=0; i<cards.length-2; i++) {
			for (var j=i+1; j<cards.length-1; j++) {
				for (var k=j+1; k<cards.length; k++) {
					var key = [ cards[i].id, cards[j].id, cards[k].id ].sort().join();
					if (determineMatch(cards[i], cards[j], cards[k]) && sets.indexOf(key) < 0) {
						sets.push(key); //store the set as the id's separated by commas (id,id,id)
						console.log(cards[i].str() + " " + cards[j].str() + " " + cards[k].str());
					}
						
				}
			}
		}	
	}
	findSets();