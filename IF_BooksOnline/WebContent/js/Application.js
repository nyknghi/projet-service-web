/*
 * A gérer :
 * Il est nécessaire de gérer certaines variables d'application coté JS (du genre BaseURL)
 *
 *
 */
baseUrl = "http://localhost/Affisolution";
/*** Expression régulière de test d'email coté JS *****/
function is_valid_email(email)
{
    return /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(email);
}


/*** Expression régulière de test de caractère spéciaux coté JS , return true
 *lorsque la chaine a effectivement un caractère spéciale*****/

function hasspecialcar(caracstring){
    regex=eval("/^[0-9a-zA-Z]+$/");
    if(!regex.test(caracstring)){
        return true;
    }else{
        return false;
    }
}

/*** Expression régulière de test de nombre coté JS, return true
 * lorsque la chaine est effectivement un nombre*****/

function isnumber(caracstring){
    regex=eval("/^[0-9\ ]+$/");
    if(!regex.test(caracstring)){
        return true;
    }else{
        return false;
    }
}

/*** Expression régulière de  conversion d'une date coté JS en vue d'une comparaison, return une date de type Date
 * lorsque la chaine est effectivement sous la forme dd/mm/yy *****/

function getDate(strDate){
	if(strDate.length != 10){
		return null;
	}
	sep1 = strDate.charAt(2);
	sep2 = strDate.charAt(5);
	if((sep1 == sep2) && (sep1 == "/")){
	    day = strDate.substring(0,2);
	    month = strDate.substring(3,5);
	    year = strDate.substring(6,10);
	    d = new Date();
	    d.setDate(day);
	    d.setMonth(month);
	    d.setFullYear(year);	   
	    return d;
	}
	else{
		return null;
	}
}

/*** Expression régulière de  comparaison de deux dates, return 0 si date1=date2, 1 si date1>date2 et 2 si date2>date1
 * lorsque la chaine est effectivement sous la forme dd/mm/yy *****/

function compareDate(date_1, date_2){
    diff = date_1.getTime()-date_2.getTime();
    //return (diff==0?diff:diff/Math.abs(diff));
    alert(diff);
    if(diff == 0) {
        return 0;
    }
    if(diff > 0) {
        return 1;
    }
    if(diff < 0) {
        return 2;
    }

}
/**
  * Expression régulière de test de nombre coté JS, return true
  * lorsque la chaine est effectivement un nombre
  */
function isNumeric(sText){
    validChars = "0123456789.";
    var isNumber=true;
    char1="";


    for (i = 0; i < sText.length && isNumber == true; i++)
    {
        char1 = sText.charAt(i);
        if (validChars.indexOf(char1) == -1)
        {
            isNumber = false;
        }
    }
    return isNumber;

}

/**
 * Cette fonction recherche dans une chaîne expr toutes les occurrences d'une sous-chaîne a et les remplace par une sous-chaîne b.
 * Ce script fonctionne pour toutes les versions de navigateurs au-delà de 3.
 */

function Remplace(expr,a,b) {
    var i=0
    while (i!=-1) {
        i=expr.indexOf(a,i);
        if (i>=0) {
            expr=expr.substring(0,i)+b+expr.substring(i+a.length);
            i+=b.length;
        }
    }
    return expr
}

function showError(message){
    $("#error_login").empty();
    $("#error_login").append("<div class='message localMessage'>" +
        "<div class='panel confirm'>" +
        "<div class='icon'>" +
        "</div>" +
        "<p> " + message + "</p>" +
        "<div class='topleft'></div>" +
        "<div class='topright'> </div><div class='bottomleft'></div>" +
        "<div class='bottomright'></div>" +
        "</div>" +
        "</div>");
}

function TextError(message){
     $("#error_login").empty();
    $("#error_login").append(
        "<p> " + message + "</p>"
    );
}


Array.prototype.remove = function(from, to) {
    var rest = this.slice((to || from) + 1 || this.length);
    this.length = from < 0 ? this.length + from : from;
    return this.push.apply(this, rest);
};

/*Encodage et decode d'URL*/
$.extend({
    URLEncode:function(c){
        var o='';
        var x=0;
        c=c.toString();
        var r=/(^[a-zA-Z0-9_.]*)/;
        while(x<c.length){
            var m=r.exec(c.substr(x));
            if(m!=null && m.length>1 && m[1]!=''){
                o+=m[1];
                x+=m[1].length;
            }else{
                if(c[x]==' ')o+='+';
                else{
                    var d=c.charCodeAt(x);
                    var h=d.toString(16);
                    o+='%'+(h.length<2?'0':'')+h.toUpperCase();
                }
                x++;
            }
        }
        return o;
    },
    URLDecode:function(s){
        var o=s;
        var binVal,t;
        var r=/(%[^%]{2})/;
        while((m=r.exec(o))!=null && m.length>1 && m[1]!=''){
            b=parseInt(m[1].substr(1),16);
            t=String.fromCharCode(b);
            o=o.replace(m[1],t);
        }
        return o;
    }
});
