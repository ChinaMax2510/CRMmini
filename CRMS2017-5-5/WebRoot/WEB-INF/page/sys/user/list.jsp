<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人事管理</title>
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function forward(strURL){
     window.location=strURL;
}

//删除
function deleteIds(){
        document.forms[1].action="userAction_userDelete.do";
	    document.forms[1].submit();
}

//启用
function  enable(){
	document.forms[1].action="userAction_enable.do";
    document.forms[1].submit();
}

//停用
function  disable(){
	  document.forms[1].action="userAction_disable.do";
    document.forms[1].submit();
}
//搜索
function toSearch(){

		document.forms[0].submit();

}
</script>
</head>

<body>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	<span class="menu_selected">人事管理</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  <tr>
    <th class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">人员搜索</div>
	</th>
    <th class="th_head" >
	</th>
  </tr>
  <tr>
	  <td colspan="2">
<s:form name="form1" method="post" action="userAction_userSearch.do" namespace="/sys">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
	<tr>
  	    <td width="13%" nowrap="nowrap">用户名：</td>
   	    <td width="12%" nowrap="nowrap">
   	        <s:textfield name="name" id="name" cssStyle="width:100px"  value=""/>
		</td>
  	    <td width="13%" nowrap="nowrap">中文名：</td>
		<td width="12%" nowrap="nowrap">
		    <s:textfield name="cnname" id="cnname" cssStyle="width:100px"  value=""/>
		</td>
		<td width="13%" nowrap="nowrap">所属部门：</td>
		<td width="12%" nowrap="nowrap">
		   <s:if test="#request.sysUserGroupSelect!=null">
			   <s:select list="#request.sysUserGroupSelect"  id='GroupID'  name="GroupID" cssStyle='width:90%'
					          listKey="id" listValue="name" headerKey=""  headerValue="--------">
			   </s:select>
		   </s:if>
			</td>
  	    <td width="25%" align="center">
			<div class="control">
				<button type='button' class='button' onMouseOver="this.className='button_over';" 
				        onMouseOut="this.className='button';"  onClick="toSearch();">
				        <img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' 
				        align='absmiddle'>&nbsp;搜索</button>
      		    <button type='button' class='button' 
      			        onMouseOver="this.className='button_over';" onMouseOut="this.className='button';" 
          			    onClick="forward('user.do?method=search')">
          			    <img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' 
          			    align='absmiddle'>&nbsp;清空</button>
			</div>
		</td>
	</tr>
	<tr>
		<td>状态：</td>
		<td>	<s:radio list="#{'Y':'启用','N':'停用'}"  name="status" id="status"  
				         listKey="key" listValue="value" /></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</s:form>
	  </td>
  </tr>
</table>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;人员列表</h3>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  
	        onClick="forward('${pageContext.request.contextPath}/sys/userAction_userAdd.do')">
	        <img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" title="新建" border='0' 
	        align='absmiddle'>&nbsp;</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="enable()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/qiyong.png" title="启用" border='0' 
	        align='absmiddle'>&nbsp;</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="disable()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/tingyong.png" title="停用" border='0' 
	        align='absmiddle'>&nbsp;</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  
	        onClick="deleteIds()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" title="删除" border='0' 
	        align='absmiddle'>&nbsp;</button>
</div>
<!-- list -->
<div class="border">
<s:form name="form2" method="post" action="sysUserAction_delete.do" namespace="/sys">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="4%" class="listViewThS1">
   	    <s:checkbox name="checkall"  id="checkall"  cssClass="checkbox"  onClick="checkAll();"/></td>
  	    <td width="13%" class="listViewThS1">用户名</td>
  	    <td width="13%" class="listViewThS1">中文名</td>
  	    <td width="15%" class="listViewThS1">操作权限组</td>
        <td width="10%" class="listViewThS1">所属部门</td>
        <td width="10%" class="listViewThS1">起始有效期</td>
		<td width="10%" class="listViewThS1">终止有效期</td>
		<td width="10%" class="listViewThS1">状态</td>
	</tr>
	<!-- data -->
 
  <s:if test="#request.users!=null">
	  <s:iterator value="#request.users" var="sysUser">
		<tr>
	    	<td>
	    	   <s:checkbox name="ids" fieldValue="%{#sysUser.id}" cssClass="checkbox"  onClick="changeCheckCount();"/>
			</td>
	  	    <td><a title="点击更改信息" href="${pageContext.request.contextPath}/sys/userAction_ToEdit.do?id=<s:property value="#sysUser.id"/>"><s:property value="#sysUser.name"  /></a></td>
	  	    <td><s:property value="#sysUser.cnname"/></td>
			<td><s:property value="#sysUser.Role.name"/></td>
			<td><s:property value="#sysUser.Group.name"/></td>
			<td><s:property value="#sysUser.beginDate"/></td>
			<td><s:property value="#sysUser.endDate"/></td>
			<td>
			   <s:if test='#sysUser.status=="Y"'>
			      <img src="${pageContext.request.contextPath}/ui/images/accept_inline.gif" width="13" height="13" border="0">
			   </s:if>
			   <s:else>
			      <img src="${pageContext.request.contextPath}/ui/images/close_dashboard.gif" width="13" height="13" border="0">
			   </s:else>
			</td>
		</tr>
	  </s:iterator> 
	</s:if>
 
</table>
</s:form>
</div>
<script type="text/javascript">
   function changeCheckCount(){
       var count=0;
	   $("input[type='checkbox'][name='ids']").each(function(index,data){
            if(this.checked){
            	count++;  
            }
	   });
	   $("#slt_ids_count2").empty();
 	   $("#slt_ids_count2").append(count);

       if(count== $("input[type='checkbox'][name='ids']").length){
    	   $("#checkall").attr("checked","checked");
       }else{
    	   $("#checkall").attr("checked",null);
       }
   }
   
   function  checkAll(){
      if($("#checkall")[0].checked){
    	  $("input[type='checkbox'][name='ids']").attr("checked","checked");
    	  $("#slt_ids_count2").empty();
    	  $("#slt_ids_count2").append($("input[type='checkbox'][name='ids']").length);
      }else{
    	  $("input[type='checkbox'][name='ids']").attr("checked",null);
    	  $("#slt_ids_count2").empty();
    	  $("#slt_ids_count2").append(0);
      }
   }
 </script>
</body>
</html>