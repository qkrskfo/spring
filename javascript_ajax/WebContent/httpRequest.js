var xhr=null;
function getXMLHttpRequest() {
	if(window.XMLHttpRequest){ //이게 존재하면 true임
		return new XMLHttpRequest();
	}else{
		return null;
	}
}
function sendRequest(url, params, callback, method) {
	/*
	1. XMLHttpRequest 객체생성
	*/
	xhr = getXMLHttpRequest();
	/*
	2. 요청 속성 설정
	*/
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + httpParams;
	}
	
	
	/*
	응답이 도착했을 때 실행되는 콜백함수 등록 (이벤트 프로퍼티에 함수 등록)
	*/
	xhr.onreadystatechange = callback;
	xhr.open(httpMethod, httpUrl, true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	
	/*
	3. 요청
	*/
	
	xhr.send(httpMethod == 'POST' ? httpParams : null);
}
