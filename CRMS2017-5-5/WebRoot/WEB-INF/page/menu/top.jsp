<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.zy.crm.utils.SessionUtils,com.zy.crm.domain.User,java.util.*"%>
<%@ page language="java"  pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/menu/css/top.css" rel="stylesheet" type="text/css">
</head>
<%
User user = SessionUtils.getUserSession(request);
String usercname=user.getCnname();
Date d=new Date();
SimpleDateFormat time=new SimpleDateFormat("yy-MM-dd");
String nowtime=time.format(d);
 %>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="top">
  <tr> 
    <td class="logo">
        <div class="subNav"><%=usercname %>，欢迎您！今天是：<%=nowtime %> | <a href="http://127.0.0.1:8080/CRM/sys/loginAction_UserLogin.do">退出
           </a> | <a href="www.google.com" >帮助</a>
        </div>
    </td>
  </tr>
</table>
</body>
</html>
