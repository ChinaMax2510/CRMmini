<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>省份资料</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
</head>

<body>
<!-- 处理弹出窗口 -->
<div id="popshow" 
    style='border:1px solid #6A82A8;width=650px;position: absolute; visibility: hidden; left: 0; top: 0; z-index: 10;'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr style='background-color:#6A82A8;'>
		<th width='80%' height="25" align='left' onMouseDown=initializedragie(popshow)  style="cursor:move" onselectstart="return false">
		<font color='#FFFFFF'>&nbsp;详细信息</font>
		</th>
		<td align='right' onselectstart="return false">	
			<a href='#' onClick="close_window();">
			<img src="${pageContext.request.contextPath}/ui/images/xpclose.jpg" width="20" height="20" border="0" onClick="" align="absmiddle"></a>
		</td>
	</tr>
	<tr>
		<td colspan="2" onselectstart="return false">
		<div id='gedit'></div>
		</td>
	</tr>
</table>
<iframe src="javascript:false" 
    style="position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-1; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)'; frameborder='0';">
</iframe>
</div>
<!-- 处理弹出窗口结束 -->

<!-- 查询开始 -->
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	省份资料
</div>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;省份资料搜索</h3>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm"  id="base">
	<tr>
    	<td width="38%" height="45" nowrap>省份名称：
			<input name="name" type="text" id="name" value="" style="width:140px" />
    	</td>
  	    <td width="39%" nowrap>&nbsp;</td>
  	    <td width="23%" align="center">
		<div class="control">
		<button class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="">
		<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align="middle">&nbsp;搜索</button>
      	<button class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="">
      	<img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align="middle">&nbsp;清空</button>
		</div>
		</td>
	</tr>
</table>
<!-- 查询结束 -->
<br>
<!--列表开始 -->
<h3><img src="${pageContext.request.contextPath}/ui/images/khlb.png" border="0" >&nbsp;省份资料列表</h3>
<div class="control">
	<button class='button'  onmouseover="this.className='button_over';" onMouseOut="this.className='button';"  
	   onClick="OpenDiv('add.jsp')">
	   <img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align="middle">&nbsp;新建</button>
	<button class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="delForm('province.do?method=delete')">
	   <img src="${pageContext.request.contextPath}/ui/images//button/shanchu.png" border='0' align="middle">&nbsp;删除</button>
	<button class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('province.do?method=search')">
	   <img src="${pageContext.request.contextPath}/ui/images/button/shuaxin.png" border='0' align="middle">&nbsp;刷新</button>
</div>
<!-- list -->
<div class="border">
<!-- 上部分页结束 -->
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="4%" class="listViewThS1">
   	    <input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();">   	  		</td>
  	    <td width="19%" class="listViewThS1">编号</td>
  	    <td width="27%" class="listViewThS1">省份名称</td>
  	    <td width="50%" class="listViewThS1">拼音码</td>
      </tr>
	<!-- data -->
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="5" class="checkbox"  onClick="changeCheckCount();">
		</td>
  	    <td>5</td>
		<td><a href="#" onClick="OpenDiv('edit.jsp')">安徽省</a></td>
		<td>ahs</td>
	  </tr>
	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="1" class="checkbox"  onClick="changeCheckCount();">
		</td>
  	    <td>1</td>
		<td><a href="#" onClick="OpenDiv('province.do?method=load&id=1')">北京市</a></td>
		<td>bjs</td>
	  </tr>
</table>
</form>
 
</div>
<!--列表结束-->
</body>
</html>