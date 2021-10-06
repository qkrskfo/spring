window.jQuery=function(selector){
	console.log('1.factory function:'+selector);
	console.log('2.selector type:'+ typeof selector)
	if(typeof selector=='string') {
		/*
		css selector
		*/
	} else if(typeof selector=='object') {
		/*
		css selector
		*/
	} else if(typeof selector=='function') {
		/*
		css selector
		*/
	}
}

window.$=window.jQuery;