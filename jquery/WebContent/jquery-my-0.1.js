window.jQuery=function(selector){
	//console.log('1.factory function:'+selector);
	//console.log('2.selector type:'+ typeof selector)
	if(typeof selector=='string') {
		/*
		css selector
		 1.selector를 사용해서 DOM Tree Node(Element)검색
		 2.jQueryWrapper객체를 생성하고 css,text,each함수추가
		 3.jQueryWrapper객체반환
		*/
		var elementNodeList = document.querySelectorAll(selector);
		var elementNode=document.querySelector(selector);
		
		var jQueryWrapperObject={
			//이건 javascript object객체임(json객체)
			//JSON new Object();
			'elementNodeList':elementNodeList,
			'elementNode':elementNode,
			'css':function(colorArg){
				if(colorArg){
					for(var i=0;i<this.elementNodeList.length;i++){
						this.elementNodeList[i].style.color=colorArg;
					}
				}else if(colorArg === undefined){
					return this.elementNode.style.color;
				}
				
				return this;
			},
			'text':function(textArg){
				if(textArg){
					for(var i=0;i<this.elementNodeList.length;i++){
						this.elementNodeList[i].firstChild.nodeValue=textArg;
					}
				}else if(textArg === undefined){
					return this.elementNode.firstChild.nodeValue;
				}	
				return this;
				//근데 02번에 만든거랑 이거랑 무슨 차이야..ㅠㅠ
				//메소드를 만들려면 json에서 어떤식으로 만들어야하죠?
			},
			'each':function(funcArg){
				for(var i=0;i < this.elementNodeList.length;i++){
					funcArg(i,this.elementNodeList[i]);
				}
			 }
			
		};
		return jQueryWrapperObject;
		
	} else if(typeof selector=='object') {
		/*
		javascript 표준객체(Node,Document,Element,Text)
			(document부터 dom tree에 있는 객체가 뭐라도 들어오면..)
		*/
		if(selector instanceof Document){
			console.log('Document');
		} else if(selector instanceof Element) {
			//console.log('selector->'+selector);
			//console.log('Element');
			
			/**객체 복사붙여넣기 ******************/
				var jQueryWrapperObject={
				//이건 javascript object객체임(json객체)
					'elementNode':selector,
					'text':function(textArg){
						if(textArg){
							this.elementNode.firstChild.nodeValue=textArg;
						}else if(textArg === undefined){
							return this.elementNode.firstChild.nodeValue;
						}	
						return this;
					}
				};
			/**객체 복사붙여넣기 끝 ******************/
			return jQueryWrapperObject;
			
		}
		
	} else if(typeof selector=='function') {
		/*
		function객체
		*/
		//window.onlad=selector;
		/*
		인자로 대입된 function을 DOM tree 생성 직후 & 랜더링 직전 호출하도록
		window.onload이벤트에 등록
		*/
		window.addEventListener('load',selector);
	}
}

/**************static function****************/
window.jQuery.each = function(array,funcArg){
	for(var i=0;i<array.length;i++){
		funcArg(i,array[i]);
	}
};
window.jQuery.ajax = function(){
	
};


window.$=window.jQuery;