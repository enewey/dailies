function start(arg) { //string of 1s and 0s
	for (var i=0, arr=arg.split(''); i<arr.length; i++)
		arr[i] = parseInt(arr[i]);
	for (var i=0; i<25; i++) {
		draw(arr);
		arr = step(arr);
	}
}
function step(input) { //assuming an array of 1s and 0s
	input.splice(input.length,0,0);
	input.splice(0,0,0);
	for (var i=1, ret=[]; i<input.length-1; i++)
		ret[i-1] = (input[i-1] != input[i+1]) ? 1 : 0;
	return ret;
}
function draw(automata) {
	var printer = [];
	for (var i=0; i<automata.length; i++)
		printer[i] = (automata[i] == 1) ? 'x' : ' ';
	console.log(printer.join(''));
}
start(process.argv[2]);