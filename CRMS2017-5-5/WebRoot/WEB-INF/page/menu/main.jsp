<%@ page language="java" pageEncoding="GBK" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>�ͻ���ϵ����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<frameset rows="80,*" cols="*">
  <frame src="${pageContext.request.contextPath}/sys/menuAction_top.do" name="topFrame"  id="topFrame"  scrolling="NO" 
                noresize="noresize" frameborder="0" >
  <frameset cols="220,*" id="frmstOuter">
    <frame src="${pageContext.request.contextPath}/sys/menuAction_left.do"  name="leftFrame"  id="leftFrame" 
                  scrolling="auto""   frameborder="0" framespacing="1px" bordercolor="#4faad8">
    <frame name="rightFrame" id="rightFrame" src="${pageContext.request.contextPath}/sys/menuAction_welcome.do" >
  </frameset>
</frameset>
<noframes>
<body>
<h2>=============</h2>
</body>
</noframes>
</html>