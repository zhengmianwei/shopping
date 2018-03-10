$(function(){
    $(window).resize(function() {
        $(".datagrid  .datagrid-view > table").each(function(index,item){
            $(this).datagrid('resize', {
                width:$(this).width()
            });
        });
            $("div[id$=Panel]").panel('resize', {
                width:$(this).width()
            });
    });
});

/**
 * 日期格式 （yyyy-MM-dd hh:mm:ss）
 * @param val
 * @returns {string}
 * @constructor
 */
ShowDate=function(val){
  if(val==null||val==undefined||val=="") return"";
    try{
        var dateNumber=parseInt(val);
        var dateTime=new Date(dateNumber);
        var hh=dateTime.getHours();
        var mm=dateTime.getMinutes();
        var ss=dateTime.getSeconds();

         hh=hh>9?(""+hh):("0"+hh);
         mm=mm>9?(""+mm):("0"+mm);
         ss=ss>9?(""+ss):("0"+ss);

        var yy=dateTime.getFullYear();
        var MM=dateTime.getMonth()+1;  //因为1月这个方法返回为0，所以加1
        var dd=dateTime.getDate();

         MM=MM>9?(""+MM):("0"+MM);
         dd=dd>9?(""+dd):("0"+dd);
        return yy+"-"+MM+"-"+dd+" "+ hh+":"+mm+":"+ss;
    }catch(err){
        return val+"[error:"+err+"]";
    }

};

/* 取只保留年月日时间 例：2014-04-08*/
function getSimpleTime(time){
	var dateTime = new Date(time);
	return dateTime.getFullYear() + "-"
	+ ((""+(dateTime.getMonth() + 1)).length == 1 ? "0" + (dateTime.getMonth() + 1) : (dateTime.getMonth() + 1)) + "-"
	+ ((""+dateTime.getDate()).length == 1 ? "0" + dateTime.getDate() : dateTime.getDate());
}

/* 取完整的时间 例：2014-04-08 05:06:07*/
function getFullTime(time){
	if(time==null||time==undefined||time=="") return"";
	var dateTime = new Date(time);
	return dateTime.getFullYear() + "-"
	+ ((""+(dateTime.getMonth() + 1)).length == 1 ? "0" + (dateTime.getMonth() + 1) : (dateTime.getMonth() + 1)) + "-"
	+ ((""+dateTime.getDate()).length == 1 ? "0" + dateTime.getDate() : dateTime.getDate()) + " " 
	+ ((""+dateTime.getHours()).length == 1 ? "0" + dateTime.getHours() : dateTime.getHours()) + ":" 
	+ ((""+dateTime.getMinutes()).length == 1 ? "0" + dateTime.getMinutes() : dateTime.getMinutes()) + ":"
	+ ((""+dateTime.getSeconds()).length == 1 ? "0" + dateTime.getSeconds() : dateTime.getSeconds());
}

/**
 * 取当前系统时间的时间戳
 */
function getTimestamp(){
	return new Date().getTime();
}

/**
 * 验证非负整数（正整数 + 0）
 * @param val:需验证的值
 * @return true:验证通过 false:验证未通过
 */
function validNonnegativeInt(val)
{
	var regExp=/^[1-9]\d*|0$/;
	if(regExp.test(val))
	{
		return true;
	}
	else
	{
		return false;
	} 
}

/**
 * 验证正整数
 * @param val:需验证的值
 * @return true:验证通过 false:验证未通过
 */
function validPositiveInt(val)
{
  var intReg = /^[1-9]+[0-9]*]*$/;//正整数表达式
  if(!intReg.test(val))
  {
    return false;
  }

  return true;  
}

/**
 * 将select元素设为只读
 * @param selectId:select元素ID 
 */
function setSelectReadonly(selectId)
{
 /* 因低版本的jquery不支持以下语法，故注释掉，采用每个事件单独绑定的方式
 $('#'+selectId).bind({
    focus:function(){this.blur();}
    beforeactivate:function(){return false;}
    mouseover:function(){this.setCapture();},
    mouseout:function(){this.releaseCapture();}
  });
  */
  
  $('#'+selectId).bind("focus",function(){this.blur();}).
  bind("beforeactivate",function(){return false;}).
  bind("mouseover",function(){this.setCapture();}).
  bind("mouseout",function(){this.releaseCapture();});
}
