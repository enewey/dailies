var fs = require('fs');
fs.readFile(process.argv[2], {encoding: 'utf-8'}, function(err, json) {
	hunt(JSON.parse(json), "");
});

function hunt(data, path) {
	for (var prop in data) {
		if (typeof data[prop] === "object" || typeof data[prop] === "array"){
			if (hunt(data[prop], path + prop + " -> "))	
				return true;
		} else if (data[prop] == "dailyprogrammer") {
			console.log(path + prop);
			return true;
		}
	}
};