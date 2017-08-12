<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.net.URLDecoder"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>客户关系管理系统</title>

<link href="assets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="assets/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
  function changeCheckNum(){
    var checkNumImage_=document.getElementById("checkNumImage");
    checkNumImage_.src="${pageContext.request.contextPath}/image.jsp?timeStamp="+new Date().getTime();
  }
  
  function checkSubmit(){
	    if($("#name").val().length<=0){
	        alert("登陆的用户名不能为空");
	        return false;
	    }
	    if($("#password").val().length<=0){
	        alert("登陆的密码不能为空");
	        return false;
	    }
	   /*if($("#checkNum").val().length<=0){
	        alert("验证码不能为空");
	        return false;
	    }*/
	    document.forms[0].submit();
	  }
	  function Submit(){
	  
	  document.forms[0].submit();
	  
	  }
</script>

</head>

<body onLoad="sendRequest()" >
<%
   String name="";
   String psw="";
   String checked="";
   Cookie[] cookies=request.getCookies();
   if(cookies!=null&&cookies.length>0){
	   for(int i=0;i<cookies.length;i++){
		   Cookie cookie=cookies[i];
		   if("name".equals(cookie.getName())){
			   name=URLDecoder.decode(cookie.getValue(),"utf-8");
			   checked="checked";
		   }
		   if("psw".equals(cookie.getName())){
			   psw=cookie.getValue();
		   }
	   }
   }


%>
<div class="videozz"></div>
	<video  autoplay muted loop poster="assets/images/fallba1ck.jpg">
		<source src="assets/images/mov.mp4">		
		你的游览器不支持video支持
	</video>
    
<div class="box">
	<div class="box-a">
    <div class="m-2">
          <div class="m-2-1">
            <form name="form1" method="post" action="${pageContext.request.contextPath}/sys/sysUserAction_isLogin.do">
                <div class="m-2-2">
                   
                   <input name="name" type="text" placeholder="请输入账号" value="<%= name %>" id="name"/><s:fielderror fieldName="name"/>
                </div>
                <div class="m-2-2">
                   
                   <input name="password" placeholder="请输入密码" type="password" value="<%= psw %>" id="password">
                </div>
                <div class="m-2-2-1">
                   <input type="text" placeholder="请输入验证码"/>
                   <img src="${pageContext.request.contextPath}/image.jsp"onClick="changeCheckNum()" 
			  	           title="点击换一张" style="cursor:hand"><s:fielderror fieldName="checkNum"/>
                </div>
                <div class="m-2-2">
                   <button type="submit" value="登录" onClick="checkSubmit();"> 登录
                  </button>
                </div>
                    
            </form>
          </div>
    </div>
    <div class="m-5"> 
    <div id="m-5-id-1"> 
    <div id="m-5-2"> 
    <div id="m-5-id-2">  
    </div> 
    <div id="m-5-id-3"></div> 
    </div> 
    </div> 
    </div>   
    <div class="m-10"></div>
    <div class="m-xz7"></div>
    <div class="m-xz8 xzleft"></div>
    <div class="m-xz9"></div>
    <div class="m-xz9-1"></div>
    <!-- <div class="m-x10"></div>
    <div class="m-x11"></div>
    <div class="m-x12 xzleft"></div>
    <div class="m-x13"></div>
    <div class="m-x14 xzleft"></div>
    <div class="m-x15"></div>
    <div class="m-x16 xzleft"></div>-->
    <div class="m-x17 xzleft"></div>
    <div class="m-x18"></div>
    <div class="m-x19 xzleft"></div>
    <div class="m-x20"></div>  
    <div class="m-8"></div>
    <div class="m-9"><div class="masked1" id="sx8">客户关系管理系统</div></div> 
    <div class="m-11">
    	<div class="m-k-1"><div class="t1"></div></div>
        <div class="m-k-2"><div class="t2"></div></div>
        <div class="m-k-3"><div class="t3"></div></div>
        <div class="m-k-4"><div class="t4"></div></div>
        <div class="m-k-5"><div class="t5"></div></div>
        <div class="m-k-6"><div class="t6"></div></div>
        <div class="m-k-7"><div class="t7"></div></div>
    </div>   
    <div class="m-14"><div class="ss"></div></div>
    <div class="m-15-a">
    <div class="m-15-k">
    	<div class="m-15xz1">
            <div class="m-15-dd2"></div>
        </div>
    </div>
    </div>
    <div class="m-16"></div>
    <div class="m-17"></div>
    <div class="m-18 xzleft"></div>
    <div class="m-19"></div>
    <div class="m-20 xzleft"></div>
    <div class="m-21"></div>
    <div class="m-22"></div>
    <div class="m-23 xzleft"></div>
    <div class="m-24" id="localtime"></div>
    </div>
</div>
<script src="assets/js/common.min.js"></script>
<div style="text-align:center;">
<a href="">xxxxxxx</a>
</div>
</body>
</html>