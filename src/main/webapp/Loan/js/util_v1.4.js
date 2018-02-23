/*
 v1.3 cw
 * */

Date.prototype.Format = function(fmt) { //author: meizz
	var o = {
		"M+": this.getMonth() + 1, //月份 
		"d+": this.getDate(), //日 
		"h+": this.getHours(), //小时 
		"m+": this.getMinutes(), //分 
		"s+": this.getSeconds(), //秒 
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		"S": this.getMilliseconds() //毫秒 
	};
	if(/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for(var k in o)
		if(new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

Date.prototype.pattern = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份           
		"d+": this.getDate(), //日           
		"h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时           
		"H+": this.getHours(), //小时           
		"m+": this.getMinutes(), //分           
		"s+": this.getSeconds(), //秒           
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度           
		"S": this.getMilliseconds() //毫秒           
	};
	var week = {
		"0": "/u65e5",
		"1": "/u4e00",
		"2": "/u4e8c",
		"3": "/u4e09",
		"4": "/u56db",
		"5": "/u4e94",
		"6": "/u516d"
	};
	if(/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if(/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
	}
	for(var k in o) {
		if(new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
}



function getDateFormatStr(timeVar, formatStr) {
	formatStr = typeof(formatStr) != "undefined" && formatStr != null ? formatStr : "yyyy-MM-dd"
	timeVar = typeof(timeVar) == 'string' ? timeVar.replace(/-/g, "/") : timeVar
	return new Date(timeVar).Format(formatStr);
}

var base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var base64DecodeChars = new Array(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
/** 
 * base64编码 
 * @param {Object} str 
 */
function base64encode(str) {
	var out, i, len;
	var c1, c2, c3;
	len = str.length;
	i = 0;
	out = "";
	while(i < len) {
		c1 = str.charCodeAt(i++) & 0xff;
		if(i == len) {
			out += base64EncodeChars.charAt(c1 >> 2);
			out += base64EncodeChars.charAt((c1 & 0x3) << 4);
			out += "==";
			break;
		}
		c2 = str.charCodeAt(i++);
		if(i == len) {
			out += base64EncodeChars.charAt(c1 >> 2);
			out += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
			out += base64EncodeChars.charAt((c2 & 0xF) << 2);
			out += "=";
			break;
		}
		c3 = str.charCodeAt(i++);
		out += base64EncodeChars.charAt(c1 >> 2);
		out += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
		out += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >> 6));
		out += base64EncodeChars.charAt(c3 & 0x3F);
	}
	return out;
}
var keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
//将Ansi编码的字符串进行Base64编码
function encode64(input) {
	var output = "";
	var chr1, chr2, chr3 = "";
	var enc1, enc2, enc3, enc4 = "";
	var i = 0;
	do {
		chr1 = input.charCodeAt(i++);
		chr2 = input.charCodeAt(i++);
		chr3 = input.charCodeAt(i++);
		enc1 = chr1 >> 2;
		enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
		enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
		enc4 = chr3 & 63;
		if(isNaN(chr2)) {
			enc3 = enc4 = 64;
		} else if(isNaN(chr3)) {
			enc4 = 64;
		}
		output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2) +
			keyStr.charAt(enc3) + keyStr.charAt(enc4);
		chr1 = chr2 = chr3 = "";
		enc1 = enc2 = enc3 = enc4 = "";
	} while (i < input.length);
	return output;
}
//将Base64编码字符串转换成Ansi编码的字符串
function decode64(input) {
	var output = "";
	var chr1, chr2, chr3 = "";
	var enc1, enc2, enc3, enc4 = "";
	var i = 0;
	if(input.length % 4 != 0) {
		return "";
	}
	var base64test = /[^A-Za-z0-9\+\/\=]/g;
	if(base64test.exec(input)) {
		return "";
	}
	do {
		enc1 = keyStr.indexOf(input.charAt(i++));
		enc2 = keyStr.indexOf(input.charAt(i++));
		enc3 = keyStr.indexOf(input.charAt(i++));
		enc4 = keyStr.indexOf(input.charAt(i++));
		chr1 = (enc1 << 2) | (enc2 >> 4);
		chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
		chr3 = ((enc3 & 3) << 6) | enc4;
		output = output + String.fromCharCode(chr1);
		if(enc3 != 64) {
			output += String.fromCharCode(chr2);
		}
		if(enc4 != 64) {
			output += String.fromCharCode(chr3);
		}
		chr1 = chr2 = chr3 = "";
		enc1 = enc2 = enc3 = enc4 = "";
	} while (i < input.length);
	return output;
}

function utf16to8(str) {
	var out, i, len, c;
	out = "";
	len = str.length;
	for(i = 0; i < len; i++) {
		c = str.charCodeAt(i);
		if((c >= 0x0001) && (c <= 0x007F)) {
			out += str.charAt(i);
		} else if(c > 0x07FF) {
			out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
			out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
			out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
		} else {
			out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
			out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
		}
	}
	return out;
}

function utf8to16(str) {
	var out, i, len, c;
	var char2, char3;
	out = "";
	len = str.length;
	i = 0;
	while(i < len) {
		c = str.charCodeAt(i++);
		switch(c >> 4) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				// 0xxxxxxx
				out += str.charAt(i - 1);
				break;
			case 12:
			case 13:
				// 110x xxxx 10xx xxxx
				char2 = str.charCodeAt(i++);
				out += String.fromCharCode(((c & 0x1F) << 6) | (char2 & 0x3F));
				break;
			case 14:
				// 1110 xxxx 10xx xxxx 10xx xxxx
				char2 = str.charCodeAt(i++);
				char3 = str.charCodeAt(i++);
				out += String.fromCharCode(((c & 0x0F) << 12) |
					((char2 & 0x3F) << 6) |
					((char3 & 0x3F) << 0));
				break;
		}
	}
	return out;
}


function getPreUrl() {
	return "/CaiWeiWx";
}

function postSerData(url, param, func, tagStr,tout) {
	$.ajax({
		type: 'post',
		url: getPreUrl() + url,
		data: JSON.stringify(param),
		dataType: 'json',
		contentType: 'application/json',
		timeout:tout?tout:20000,
		async: true,
		success: function(data) {
			if(data == null) {
				error('服务器太拥挤，请稍后再试');
			} else {
				if(typeof(func) === 'function') {
					func(data);
				}
			}
		},
		error: function(xhr, type) {
			error('网络不稳定，获取数据失败 ');
			console.log(tagStr + ":" + type);
			console.log(tagStr + ":" + xhr);
		}
	});
}

function postSerDataWithHeaders(url, param, func, tagStr,pheaders,tout) {
	$.ajax({
		type: 'post',
		url: getPreUrl() + url,
		headers:pheaders,
		data: JSON.stringify(param),
		dataType: 'json',
		contentType: 'application/json',
		timeout:tout?tout:20000,
		async: true,
		success: function(data) {


			if(data == null) {
				error('服务器太拥挤，请稍后再试');
			} else {
				if(typeof(func) === 'function') {
					func(data);
				}
			}
		},
		error: function(xhr, type) {
			error('网络不稳定，获取数据失败 ');
			console.log(tagStr + ":" + type);
			console.log(tagStr + ":" + xhr);
		}
	});
}

function postSerDataWithHeader(url, param, func, tagStr,tout) {
	if(localStorage.caiweiWx){
		var caiweiWx=JSON.parse(localStorage.caiweiWx);
        var cwobj = JSON.parse(localStorage.caiweiObj);
        $.ajax({
            type: 'post',
            url: getPreUrl() + url,
            headers:{
				openId:caiweiWx.openId,
				at:cwobj.token
            },
            data: JSON.stringify(param),
            dataType: 'json',
            contentType: 'application/json',
            timeout:tout?tout:20000,
            async: true,
            success: function(data) {
                if(data == null) {
                    error('服务器太拥挤，请稍后再试');
                } else {
                    if(typeof(func) === 'function') {
                        func(data);
                    }
                }
            },
            error: function(xhr, type) {
                error('网络不稳定，获取数据失败 ');
                console.log(tagStr + ":" + type);
                console.log(tagStr + ":" + xhr);
            }
        });


	}else{
		error("微信授权过期!");
	}

}

function asyncSerDataWithHeader(url, param, func, tagStr,tout) {
	if(localStorage.caiweiWx){
        $('#myModal').show();
        var caiweiWx=JSON.parse(localStorage.caiweiWx);
        var cwobj = JSON.parse(localStorage.caiweiObj);
        $.ajax({
            type: 'post',
            url: getPreUrl() + url,
            headers:{
                openId:caiweiWx.openId,
                at:cwobj.token
            },
            data: JSON.stringify(param),
            dataType: 'json',
            contentType: 'application/json',
            timeout:tout?tout:20000,
            async: true,
            success: function(data) {
                $('#myModal').hide();
                if(data == null) {
                    error('服务器太拥挤，请稍后再试');
                } else {
                    if(typeof(func) === 'function') {
                        func(data);
                    }
                }
            },
            error: function(xhr, type) {
                $('#myModal').hide();
                error('网络不稳定，获取数据失败 ');
                console.log(tagStr + ":" + type);
                console.log(tagStr + ":" + xhr);
            }
        });


	}else{
		error("微信授权过期!");
	}

}



function getTimeStamp() {
	return (new Date()).valueOf();
}


function validatePhone(phone){
    if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))){
        error("请输入11位正确的手机号码");
        return false;
    }
    return true;
}


function validateCode(code) {
	if(!(/^\d{4}$/.test(code))){
        error("请输入正确的四位数字验证码");
        return false;
	}
	return true;
}

function validateSendCode(code) {
    if(!(/^\d{4,6}$/.test(code))){
        error("请输入正确的验证码");
        return false;
    }
    return true;
}
function validateTpwdCode(code) {
    if(!(/^\d{6}$/.test(code))){
        error("请输入正确的6位交易密码");
        return false;
    }
    return true;
}


function validatePassword(pwd) {
	if(!/^[\d_a-zA-Z]{6,12}$/.test(pwd)){
        error("请输入6至12位密码，只能输入字母，数字及下划线");
        return false;
	}
    return true;
}

function validatePwd(pwd) {
	if(!(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,16}$/.test(pwd))){
        error("请输入6至16位密码，必须包含字母和数字");
        return false;
	}
    return true;
}


function  validateBankCard(card) {
    if(!(/^[\d]{16,21}$/.test(card))){
        error("请输入正确的银行卡号");
        return false;
    }
    return true;
}


function validateSpace(value) {
	if(value.indexOf(" ")!=-1){
        error("不能包含空格");
        return false;
	}
	return true;
}


function validateIdCard(idCard) {
	if(!(/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(idCard))){
        error("请输入正确的身份证号码");
        return false;
	}
	return true;
}


function validateName(name) {
	if(!(/^[\u4e00-\u9fa5]+$/.test(name))){
        error("请输入真实姓名");
        return false;
	}
	return true;
}