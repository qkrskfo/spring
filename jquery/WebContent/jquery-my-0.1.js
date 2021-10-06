window.jQuery=function(selector){
	console.log('1.factory function:'+selector);
	console.log('2.selector type:'+ typeof selector)
	if(typeof selector=='string') {
		/*
		css selector
		*/
	} else if(typeof selector=='object') {
		/*
		javascript의 표준객체
		(dom객체, json, array, ...)
			(document부터 dom tree에 있는 객체가 뭐라도 들어오면..)
		*/
	} else if(typeof selector=='function') {
		/*
		css selector
		*/
	}
}

window.$=window.jQuery;