<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车载系统</title>
<link href="../../css/login.css" type="text/css" rel="stylesheet" />

</head>
<body id="userlogin_body">

<div id="user_login">
	<dl>
		<dd id="user_top">
			<ul>
				<li class="user_top_l"></li>
				<li class="user_top_c"></li>
				<li class="user_top_r"></li>
			</ul>
		</dd>
		<form action="/login" method="post">
			<dd id="user_main">
				<ul>
					<li class="user_main_l"></li>
					<li class="user_main_c">
						<div class="user_main_box">
							<ul>
								<li class="user_main_text">用户名： </li>
								<li class="user_main_input"><input name="username" maxlength="20" id="username" class="txtusernamecssclass"> </li>
							</ul>
							<ul>
								<li class="user_main_text">密 码： </li>
								<li class="user_main_input"><input type="password" name="password" id="password" class="txtpasswordcssclass"> </li>
							</ul>
						</div>
					</li>
					<li class="user_main_r"><input type="image" name="IbtnEnter" src="../../images/user_botton.gif" class="ibtnentercssclass"></li>
				</ul>
			</dd>
		</form>
		<dd id="user_bottom">
			<ul>
				<li class="user_bottom_l"></li>
				<li class="user_bottom_c"></li>
				<li class="user_bottom_r"></li>
			</ul>
		</dd>
	</dl>
</div>


</body>
</html>



















