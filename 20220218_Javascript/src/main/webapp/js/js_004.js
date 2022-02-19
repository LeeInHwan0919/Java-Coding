window.onload = function(){
	var btns = document.getElementsByTagName('button');
	console.log(btns.length);
	for(let i=0; i<btns.length-1; i++){
		btns[i].onclick = function(){
			console.log(this.textContent);
		}
	}
}