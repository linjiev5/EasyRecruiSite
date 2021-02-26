var windowHeightPx = $(window).height();

var openZindex = 1000000;


var clockEval = '';
function addClock(){
    clearInterval(addClockId);
    if(clockEval){
    	eval(clockEval);
    }
    clockEval='';
    $('.ts_img').remove();
}
var addClockId = null;

function tiShiText(type,src,code){
	var html = '<img id="ts_'+openZindex+'" src="tpl/images/'+src+'.png" class="ts_img pos_f" style="z-index:20010;wdith:160px;height:80px;top:'+((windowHeightPx-80)/2)+'px;left:'+(($(window).width()-150)/2)+'px" />';

	$('body').append(html);
	clockEval = code;
	addClockId = setInterval(addClock,1000);

	openZindex++;
}




function oAlert(arg){
	var button = arg.button == undefined?'我知道了':arg.button;
	var func = arg.func == undefined?'':arg.func;
	var con = arg.con == undefined?'':arg.con;

	var html = '<div id="openBox'+openZindex+'" class="w100per pos_f bbox " style="height:'+windowHeightPx+'px;z-index:'+openZindex+';top:0px;left:0px;background:url(tpl/images/openBg.png);">';
	html += '<div id="openConBox'+openZindex+'" class=" borderR  mauto  pos_r" style="background:#fff;width:300px;height:auto;">';
	html += '<a href="javascript:"><img src="tpl/images/guanbi2.png"  style="height:13px;width:12px;top:10px;right:10px" class="pos_a" onclick="$(\'#openBox'+openZindex+'\').remove();'+func+';"></a>';
	html += '<div id="openCon'+openZindex+'" class="w100per fl ta_c bbox  " style="padding:30px 30px;color:#373737;font-size:16px;">'+con+'</div>';
	html += '<a href="javascript:"><div class=" ta_c  bbox fl bghong1 borderR" style="font-size:14px;height:35px;line-height:35px;color:#ffffff;width:90px;margin-left:105px" onclick="$(\'#openBox'+openZindex+'\').remove();'+func+';">'+button+'</div></a>';

	html += '</div></div>';
	$('body').append(html);

	var h = ($('#openCon'+openZindex).outerHeight()+50);

	$('#openConBox'+openZindex).css({'height':h+'px','margin-top':((windowHeightPx-h)/2)+'px'});
	openZindex++;
}

function oMsg(arg){
	var con = arg.con == undefined?'':arg.con;
	var hClose = arg.hClose == undefined?false:arg.hClose;

	var html = '<div id="openBox'+openZindex+'" class="w100per pos_f bbox " style="height:'+windowHeightPx+'px;top:0px;z-index:'+openZindex+';left:0px;background:url(tpl/images/openBg.png);">';
	html += '<div id="openConBox'+openZindex+'" class=" borderR  mauto pos_r" style="background:#fff;width:300px;margin-top:100px;height:auto;">';
	html += '<div id="openCon'+openZindex+'" class="w100per fl ta_c bbox " style="padding:30px 30px;color:#373737;font-size:16px;">'+con+'</div>';
	if(!hClose){
		html += '<a href="javascript:"><img src="tpl/images/guanbi2.png"  style="height:13px;width:12px;top:10px;right:10px" class="pos_a" onclick="$(\'#openBox'+openZindex+'\').remove();" /></a>';
	}
	html += '</div>';
	html += '</div>';
	$('body').append(html);

	var h = ($('#openCon'+openZindex).outerHeight()+10);
	$('#openConBox'+openZindex).css({'height':h+'px','margin-top':((windowHeightPx-h)/2)+'px'});
	openZindex++;
}

function oConfirm(arg){
	var button1 = arg.button1 == undefined?'是':arg.button1;
	var button2 = arg.button2 == undefined?'否':arg.button2;
	var func1 = arg.func1 == undefined?'':arg.func1;
	var func2 = arg.func2 == undefined?'':arg.func2;
	var con = arg.con == undefined?'':arg.con;
	var colorbutton = arg.color == undefined?2:1;

	var html = '<div id="openBox'+openZindex+'" class="w100per pos_f bbox" style="height:'+windowHeightPx+'px;z-index:'+openZindex+';top:0px;left:0px;background:url(tpl/images/openBg.png);">';
	html += '<div id="openConBox'+openZindex+'" class=" borderR  mauto  pos_r" style="background:#fff;width:300px;margin-top:100px;height:auto;">';
	html += '<a href="javascript:"><img src="tpl/images/guanbi2.png"  style="height:13px;width:12px;top:10px;right:10px" class="pos_a" onclick="$(\'#openBox'+openZindex+'\').remove();'+func2+';"></a>';
	html += '<div id="openCon'+openZindex+'" class="w100per fl ta_c bbox  " style="padding:30px 30px;color:#373737;font-size:16px;">'+con+'</div>';
	html += '<div class="w100per ta_c  bbox fl paddinglr30" style="height:50px;line-height:50px;color:#4497e9">';
	html += '<a href="javascript:"><div style="width:45%;height:35px;line-height:35px;color:#ffffff" class="fl bbox bghong1 borderR" onclick="$(\'#openBox'+openZindex+'\').remove();'+func1+';">'+button1+'</div></a>';
	html += '<a href="javascript:"><div style="width:45%;height:35px;line-height:35px;" class="fr bbox bd2hongse fncolorhongse borderR" onclick="$(\'#openBox'+openZindex+'\').remove();'+func2+';">'+button2+'</div></a>';

	//html += '<div style="width:50%;height:49px;'+(colorbutton==1?'color:#fd4746':'')+';line-height:49px;border-right:1px solid #d4d4d4;" class="fl bbox" onclick="$(\'#openBox'+openZindex+'\').remove();'+func1+';">'+button1+'</div>';
	//html += '<div style="width:50%;height:49px;'+(colorbutton==2?'color:#fd4746':'')+';line-height:49px;" class="fl bbox" onclick="$(\'#openBox'+openZindex+'\').remove();'+func2+';">'+button2+'</div>';

	html += '</div></div></div>';
	$('body').append(html);


	var h = ($('#openCon'+openZindex).outerHeight()+50);
	$('#openConBox'+openZindex).css({'height':h+'px','margin-top':((windowHeightPx-h)/2)+'px'});
	openZindex++;
}


function timer(second,showDiv,endStr){
	var intDiff = second;
	window.setInterval(function(){
		var day=0,
			hour=0,
			minute=0,
			second=0;//时间默认值
		if(intDiff > 0){
			//day = Math.floor(intDiff / (60 * 60 * 24));
			//hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
			minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
			second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
			if (minute <= 9) minute = '0' + minute;
			if (second <= 9) second = '0' + second;
			$('#'+showDiv).html(minute+':'+second);
		}
		else{
			$('#'+showDiv).html(endStr);
		}
		intDiff--;
	}, 1000);
}


function convertCpt(){
	return $(window).width()/640;
}


function convert(obj){
	_this=obj;
	var num=convertCpt();

	var memberB = '';
	var str="";
	for(var key in _this){
		var v= _this[key]*num;
		if(key=='font-size' || key=='line-height'){
			if(v<12){
				v = 12;
			}
		}
	    memberB += key+':'+v+'px;';
	}
	return memberB;
}

//高度自适应函数
function convertH(obj){
	_this=obj;
	var num=convertCptH();

	var memberB = '';
	var str="";
	for(var key in _this){
	    memberB += key+':'+_this[key]*num+'px;';
	}
	return memberB;
}

function converts(arg){
	var _this = '';
	for(i=0; i<arg.length; i++){
		_this+= arg[i];
	}
	return _this;
}

function addStyles(styles){
	var styleElt, styleSheet;
	if(document.createStyleSheet){
		styleSheet = document.createStyleSheet();
	}
	else{
		var head = document.getElementsByTagName('head')[0];
		styleElt = document.createElement('style');
		head.appendChild(styleElt);
		styleSheet = document.styleSheets[document.styleSheets.length-1];
	}


	if(typeof styles === 'string'){
		if(styleElt){
			styleElt.innerHTML = styles;
		}
		else{
			styleSheet.cssTet = styles;
		}
	}
	else{
		var i =0;
		for(selector in styles){
			if(typeof styles[selector] === 'string'){
				if(styleSheet.insertRule){
					var rule = selector+"{"+styles[selector]+"}";
					styleSheet.insertRule(rule,i++);
				}
				else{
					styleSheet.addRule(selector,styles[selector],i++);
				}
			}
			else{
				for(selector2 in styles[selector]){
					if(styleSheet.insertRule){
						var rule = selector2+"{"+styles[selector][selector2]+"}";
						styleSheet.insertRule(rule,i++);
					}
					else{
						styleSheet.addRule(selector2,styles[selector][selector2],i++);
					}
				}
			}

		}
	}
}
function getCheckBoxValue( name ){
	var r = document.getElementsByName( name );
	var result = '';
	if( r ){
		for(var j=0;j<r.length;j++){
			if(r[j].checked == true){
				if( result != '' ) result += '_';
				result +=  r[j].value;
			}
		}
	}
	return result;
}