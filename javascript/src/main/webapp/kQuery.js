/**
 * 
 */
function hello(fArg,name){
	var msg = name+" 님 안녕하세요!!";
	fArg(msg);
}

function forEach(array,userCallbackFunc){
	for(var i=0;i<array.length;i++){
			userCallbackFunc(i,array[i]);	
	}
}