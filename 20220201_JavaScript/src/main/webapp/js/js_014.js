window.onload = function() {
	var val = prompt("원하는 홀수 마방진을 입력해주세요", '');
	if (!isNaN(val) && val % 2 == 1) {
		magicPrint(parseInt(val));
	} else {
		alert("정확한 홀수 값을 입력해 주세요.")
	}
}

function magicPrint(m) {
	var odd = new OddMagicSquare(m);
	odd.make(); // 객체 의 내부함수 this로 되어 있는 것들
	var magic = odd.getMagic();
	console.log(magic);

	var table = "<table>";
	for (var i = 0; i < magic.length; i++) {
		table +="<tr>";
		for (var j = 0; j < magic.length; j++) {
			table += "<td>" + magic[i][j] + "</td>"
		}
		table += "</tr>";
	}
	table += "</table>";
	document.getElementById("magicView").innerHTML=table;
}







//2차원 배열(중첩배열) 생상
var OddMagicSquare = function(m) {
	var magic;
	this.makeMagic = function() {
		magic = new Array(m);
		for (var i = 0; i < magic.length; i++) {
			//중첩배열 [ [<undefined, undefined, undefined>],
			//		   [<undefined, undefined, undefined>],
			//		   [<undefined, undefined, undefined>] ]
			magic[i] = new Array(m);
		}
	}

	this.make = function() {
		this.makeMagic();//중첩배열 생성
		var n = magic.length;

		var x = 0;
		var y = ~~(n / 2);// ~~ 소수점을 버려준다는 뜻
		magic[x][y] = 1;

		for (var i = 2; i < n * n + 1; i++) {
			var tempX = x;
			var tempY = y;
			if (x - 1 < 0) {
				x = n - 1;
			} else {
				x--;
			}

			if (y + 1 > n - 1) {
				y = 0;
			} else {
				y++;
			}

			if (magic[x][y] != undefined) {
				x = tempX + 1;
				y = tempY;
			}
			magic[x][y] = i;
		}
	}

	this.getMagic = function() {
		return magic;
	}

};






















