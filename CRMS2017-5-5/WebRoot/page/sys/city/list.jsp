<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>城市资料</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script type="text/javascript">
 function forward(strURL){
     window.location=strURL;
 }
</script>
</head>

<body>
<div id="popshow" style='border:1px solid #6A82A8;width=650px;position: absolute; visibility: hidden; left: 0; top: 0; z-index: 10;'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr style='background-color:#6A82A8;'>
		<th width='80%' height="25" align='left' onMouseDown=initializedragie(popshow) style="cursor:move" onselectstart="return false">
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
<iframe src="javascript:false" style="position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-1; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)'; frameborder='0';"></iframe>
</div>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	城市资料
</div>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;城市资料搜索</h3>
<form name="SearchForm" method="post" action="city.do">
<input type="hidden" name="method" value="search">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm" name="base" id="base">

	<tr>
    	<td width="38%" height="45" nowrap>省份：
   	    	<select id='pid' name='pid' style='width:140px' onChange='doSearch()'>
<option value='1' selected>北京市</option>
<option value='2'>上海市</option>
<option value='3'>天津市</option>
<option value='4'>重庆市</option>
<option value='5'>安徽省</option>
<option value='6'>福建省</option>
<option value='7'>甘肃省</option>
<option value='8'>广东省</option>
<option value='9'>广西</option>
<option value='10'>贵州省</option>
<option value='11'>河北省</option>
<option value='12'>河南省</option>
<option value='13'>黑龙江省</option>
<option value='14'>湖北省</option>
<option value='15'>湖南省</option>
<option value='16'>吉林省</option>
<option value='17'>江苏省</option>
<option value='18'>江西省</option>
<option value='19'>辽宁省</option>
<option value='20'>内蒙古</option>
<option value='21'>宁夏</option>
<option value='22'>青海省</option>
<option value='23'>山东省</option>
<option value='24'>山西省</option>
<option value='25'>陕西省</option>
<option value='26'>四川省</option>
<option value='27'>西藏</option>
<option value='28'>新疆</option>
<option value='29'>云南省</option>
<option value='30'>浙江省</option>
<option value='31'>海南省</option>
<option value='32'>香港</option>
<option value='33'>台湾省</option>
<option value='34'></option>
</select>
		</td>
  	    <td width="39%" nowrap>&nbsp;</td>
  	    <td width="23%" align="center">
		<div class="control">
		</div>
		</td>
	</tr>
</table>
</form>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;城市资料列表</h3>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="OpenDiv('add.jsp')"><img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align='absmiddle'>&nbsp;新建</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="delForm('city.do?method=delete')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('city.do?method=search&pid=1')"><img src="${pageContext.request.contextPath}/ui/images/button/shuaxin.png" border='0' align='absmiddle'>&nbsp;刷新</button>
</div>
<!-- list -->
<div class="border">
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="7%" class="listViewThS1">
   	    <input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();">   	  		</td>
  	    <td width="33%" class="listViewThS1">名称</td>
  	    <td width="30%" class="listViewThS1">拼音码</td>
  	    <td width="15%" class="listViewThS1">邮政编码</td>
  	    <td width="15%" class="listViewThS1">区号</td>
        </tr>
	<!-- data -->

	
	<tr>
    	<td><input type="checkbox" name="ids" value="1" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="#" onClick="OpenDiv('edit.jsp')">北京</a></td>
		<td>bj</td>
		<td>100000</td>
		<td>010</td>
		</tr>
	
	<tr>
    	<td><input type="checkbox" name="ids" value="3" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="#" onClick="OpenDiv('city.do?method=load&id=3')">昌平</a></td>
		<td>cp</td>
		<td>102200</td>
		<td>010</td>
		</tr>
	
	<tr>
    	<td><input type="checkbox" name="ids" value="4" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="#" onClick="OpenDiv('city.do?method=load&id=4')">大兴</a></td>
		<td>dx</td>
		<td>102600</td>
		<td>010</td>
		</tr>
	
	<tr>
    	<td><input type="checkbox" name="ids" value="8" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="#" onClick="OpenDiv('city.do?method=load&id=8')">怀柔</a></td>
		<td>hr</td>
		<td>101400</td>
		<td>010</td>
		</tr>
</table>
</form>
 
</div>
</body>
</html>