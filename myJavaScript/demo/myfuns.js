function jiSuan(v1,v1,val){//�����Ĳ���ǰ��Ҫ��var
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
		abc(--num1);//�ݹ�
	}
	document.writeln(num1);
}

function test2(){//���Խ��ն���������������ǵĺ�
	window.alert(arguments.length);//arguments���Է������д���ֵ
	for(var i=0;i<arguments.length;i++){
		document.writeln(arguments[i]);
	}
}