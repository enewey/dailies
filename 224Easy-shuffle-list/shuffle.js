var arr = [
	'apple', 
	'blackberry', 
	'cherry', 
	'dragonfruit',
	'grapefruit',
	'kumquat',
	'mango',
	'nectarine',
	'persimmon',
	'raspberry',
	'raspberry'
];
for(var i=arr.length-1; i>0; i--) {
	var t = arr[i];
	var rand = (Math.random()*i) + 1;
	arr[i] = arr[rand];
	arr[rand] = t;
}
console.log(arr);