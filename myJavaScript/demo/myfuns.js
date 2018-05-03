function jiSuan(v1,v1,val){//变量的参数前不要带var
	var res=0;
	if(val=="+"){
		res=v1+v2;
	}else if(val=="-"){
		res=v1-v2;
	}else if(val=="*"){
		res=v1*v2;
	}else if(val=="/"){
		res=v1/v2;
	}
	return res;
}

function test(val){
	window.alert(val);
}

function abc(num1){
	if(num1>3){
		abc(--num1);//递归
	}
	document.writeln(num1);
}

function test2(){//可以接收多个数，并计算他们的和
	window.alert(arguments.length);//arguments可以访问所有传入值
	for(var i=0;i<arguments.length;i++){
		document.writeln(arguments[i]);
	}
}