<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码规则</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script type="text/javascript">
 function forward(strURL){
     window.location=strURL;
 }
</script>
</head>

<body>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	<span class="menu_selected">编码规则</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  <tr>
    <th class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">编码规则搜索</div>
	</th>
    <th class="th_head" >
	</th>
  </tr>
  <tr>
	  <td colspan="2">
<form name="SearchForm" method="post" action="rule.do">
<input type="hidden" name="method" value="search">
<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
	<tr>
    	<td width="38%" nowrap>模块名称：
			<input name="module" type="text" id="module" value="" style="width:140px">
    	</td>
  	    <td width="39%" nowrap>&nbsp;</td>
  	    <td width="23%" align="center">
		<div class="control">
		<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.SearchForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
		<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('rule.do?method=search')"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
		</div>
		</td>
	</tr>
</table>
</form>
	  </td>
  </tr>
</table>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;编码规则列表</h3>

<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('add.jsp')"><img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align='absmiddle'>&nbsp;新建</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="delForm('rule.do?method=delete')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
</div>

<!-- list -->
<div class="border">
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="7%" class="listViewThS1">
   	    <input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();">   	  		</td>
  	    <td width="22%" class="listViewThS1">模块名称</td>
  	    <td width="21%" class="listViewThS1">编码前缀</td>
  	    <td width="19%" class="listViewThS1">日期位</td>
  	    <td width="15%" class="listViewThS1">流水位</td>
		<td width="16%" class="listViewThS1">预览</td>
	</tr>
	<!-- data -->

	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="10" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="edit.jsp">
			商品类别</a></td>
		<td>PTYPE</td>
		<td>yyyyMMdd</td>
		<td>3</td>
		<td>PTYPE-20071015-001</td>
	</tr>
	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="9" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="rule.do?method=load&id=9">
			联系人</a></td>
		<td>MAN</td>
		<td>yyyyMMdd</td>
		<td>3</td>
		<td>MAN-20071015-001</td>
	</tr>
	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="8" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="rule.do?method=load&id=8">
			商品资料</a></td>
		<td>P</td>
		<td>&nbsp;</td>
		<td>5</td>
		<td>P-00001</td>
	</tr>
	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="5" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="rule.do?method=load&id=5">
			收款单</a></td>
		<td>GATHER</td>
		<td>yyyyMMdd</td>
		<td>3</td>
		<td>GATHER-20071015-001</td>
	</tr>
	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="4" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="rule.do?method=load&id=4">
			销售单</a></td>
		<td>SALE</td>
		<td>yyyyMMdd</td>
		<td>3</td>
		<td>SALE-20071015-001</td>
	</tr>
	
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="3" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="rule.do?method=load&id=3">
			客户资料</a></td>
		<td>C</td>
		<td>yyyyMMdd</td>
		<td>3</td>
		<td>C-20100808-001</td>
	</tr>
	

</table>
</form>
 
</div>

</body>
</html>