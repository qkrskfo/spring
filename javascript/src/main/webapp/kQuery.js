/**
 * 
 */
function hello(name, funcArg) {
	document.write(">>> hello(name, funcArg) 실행<br>");
	var msg = name+"님 안녕하세요!!";
	funcArg(msg);
}

function forEach(array, userCallbackFunction) {
	document.write(">>> forEach(array, userCallbackFunction) 실행<br>");
	for(var i =0; i<array.length; i++) {
		userCallbackFunction(i, array[i]);
	}
}