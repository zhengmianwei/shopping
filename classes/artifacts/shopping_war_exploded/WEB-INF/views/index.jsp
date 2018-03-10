<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/admin/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="/admin/zTree_v3/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="/admin/index.js"></script>
</head>
<body class="easyui-layout">

<!-- top -->
<div id="header" data-options="region:'north',border:false" style="height:55px" >

    <div class="headerNav">
        <ul class="nav" style="list-style: none outside none;float: left">
            <li> 欢迎,${sessionScope.LOGIN_USER_INFO.username}<b></b></li>
            <input type="hidden" name="username" id="username" 
            	value="${sessionScope.LOGIN_USER_INFO.username}">
            <li id="dateVal"></li>
            <li><a href="javascript:void(0)" id="moditypwdBut">修改密码</a>&nbsp;&nbsp; 
            <a href="logout">安全退出</a></li>
        </ul>


           <ul class="themeList" id="themeList" style="display: none">
                  <li class="default" theme="default"><div class="selected">蓝色 </div></li>
            <li class="purple" theme="metro"><div class="">紫色 </div></li>
            <li class="silver" theme="gray"><div class="">银色</div></li>
            <li class="azure" theme="bootstrap"><div class="">天蓝</div></li>
        </ul>
    </div>

</div>

<!-- left-->
<div data-options="region:'west',split:true" style="width:220px" title="主菜单">
	<ul id="menutree" class="ztree">
	</ul>
</div>


<!--center-->
<div data-options="region:'center',split:true"  >

    <!--tabs-->
    <div id="tabs" class="easyui-tabs" fit="true"  border="false">
        <!--默认tab-->
        <div title="首页" style="padding:10px">
            <p style="font-size:14px"><h1>欢迎登陆车载后台管理系统</h1></p>
        </div>


    </div>

</div>

<!--footer-->
<div id="footer" data-options="region:'south'" class="panel-title" style="height:21px">
    Copyright © 2016 BET500
</div>









<div id="modifyPWDDialog" class="easyui-dialog" title="修改密码"  style="top:50px;width:360px;height:280px;padding:10px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons: '#modifyPWD-buttons',cache: true">
    <form id="modifyPWDForm" method="post">
        <table>
            <input type="hidden" name="username" value="${sessionScope.LOGIN_USER_INFO.username}">
            <tr>
                <td>旧密码:</td>
                <td>
                    <input class="easyui-validatebox" id="oldpwd" name="oldpwd" type="password"   data-options="required:true" />
                </td>
            </tr>

            <tr>
                <td>新密码:</td>
                <td>
                    <input class="easyui-validatebox" id="newpwd" name="newpwd" type="password"   onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value) data-options="required:true" />
                </td>
            </tr>
            <tr>
                <td>密码强度:</td>
                <td>
                    <div id="result" style="color: red"></div>
                </td>
            </tr>

            <tr>
                <td>确认密码:</td>
                <td>
                    <input class="easyui-validatebox" id="cmpwd" name="cmpwd" type="password"   data-options="required:true" />
                </td>
            </tr>

        </table>
    </form>
    <div id="modifyPWD-buttons">
        <a href="javascript:void(0)"  id="saveModifyPWDBut" class="easyui-linkbutton" >保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#modifyPWDDialog').dialog('close')">取消</a>
    </div>
</div>

</body>
</html>
