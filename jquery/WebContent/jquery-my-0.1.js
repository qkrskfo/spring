window.jQuery=function(selector){
	//console.log('1.factory function:'+selector);
	//console.log('2.selector type:'+ typeof selector)
	if(typeof selector=='string') {
		/*
		css selector
		1. selector를 사용해서 Node검색
		*/
		var elementNodeList = document.querySelectorAll(selector);
		var elementNode = document.querySelector(selector);
		
		var jQueryWrapperObject={
			//이건 javascript object객체임(json객체)
			//JSON new Object();
			'elementNodeList':elementNodeList,
			'elementNode':elementNode,
			'css':function(colorArg){
				if(colorArg) {
					for(var i=0; i<this.elementNodeList.length; i++){
						this.elementNodeList[i].style.color=colorArg;
					}
				} else if(colorArg==undefined) {
					return this.elementNodeList.style.color;
				}	
				return this;
			},
			'text':function(textArg){
				for(var i=0; i<this.elementNodeList.length; i++) {
					this.elementNodeList[i].firstChild.nodeValue=textArg;
				}
				return this;
			}
			//근데 02번에 만든거랑 이거랑 무슨 차이야..ㅠㅠ
			//메소드를 만들려면 json에서 어떤식으로 만들어야하죠?
			
			
		};
		return jQueryWrapperObject;
		
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