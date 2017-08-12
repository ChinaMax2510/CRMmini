<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择菜单</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>

<style type="text/css">
<!--
fieldset div {
	float:left;
	width:24%;
	text-align:left;
	line-height:25px;
}
td div {
	float:left;
	width:24%;
	text-align:left;
	line-height:25px;
}
-->
</style>
<script language="javascript">
   function goSelect(id){
      var valueStr=$("#"+id).val();
	  var array=valueStr.split(",");
	  if(array[0] != array[1]){
	     if($("#"+id)[0].checked){
		 	 var supid=array[0]+"_"+array[0];
		 	 $("#"+ supid).attr("checked","checked"); 
		 }else{
		 	 var $jihe=$("input[type='checkbox'][value^="+array[0]+"]:not([value$="+array[0]+"])"); 
			 var flag=false;
			 
			 $jihe.each(function(index,domEle){
				 if(this.checked){
				 	flag=true;
					return;
				 }
			 });
			 
			 if(!flag){
			 	  var supid=array[0]+"_"+array[0];
		 	       $("#"+ supid).attr("checked",null); 
			 }
		 }
	  }
	  
	  if(array[0]==array[1]){
	  	 if($("#"+id)[0].checked){
		     $("input[type='checkbox'][value^="+array[0]+"]").attr("checked","checked");   	
		 }else{
		 	  $("input[type='checkbox'][value^="+array[0]+"]").attr("checked",null); 
		 }
	  }
  }
  
  function SelectAllBox(){
     $("input[type=checkbox][name=menuModule]").attr("checked","checked");
  }

  function UnSelectAllBox(){
	     $("input[type=checkbox][name=menuModule]").attr("checked",null);
  }
</script>
</head>
<body>
<s:form name="ActionForm" method="post" action="sysRoleAction_updateMenu.do" namespace="/sys">
<s:hidden name="roleId"  value="%{#request.sysRole.id}"></s:hidden>
<br/>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';" 
		    onClick="SelectAllBox()">
		    <img src="${pageContext.request.contextPath}/ui/images/button/quanbuxz.png" border='0' 
		    align='absmiddle'>&nbsp;全部选中</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="UnSelectAllBox()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/quanbubxz.png" border='0' 
	        align='absmiddle'>&nbsp;全部不选中</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="document.forms[0].submit();">
	        <img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' 
	        align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="parent.close();">
	        <img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png" border='0' 
	        align='absmiddle'>&nbsp;关闭</button>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#6A82A8">
	<tr>
		<td align="center" height="25"><span style="color:#FFFFFF; font-weight:bold">操作权限组：<s:property value="%{#request.sysRole.name}"/></span></td>
	</tr>
</table>
<div class="border" style="padding:3px">
 <c:if test="${! empty menuArray }">
 	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			 <c:forEach items="${menuArray }" var="menuOUT">
			 <c:if test="${menuOUT.id.menuModule==menuOUT.id.menuPrivilege }">
			 		<fieldset style='padding:5px;clear:left;'><!-- 修饰 -->
			 		
			 			<!-- 菜单是否被选择 -->
			 			<c:forEach items="${privileges }" var="p">
			 				<c:if test="${menuOUT.id.menuModule==p.id.menuModule &&
			 				               menuOUT.id.menuPrivilege==p.id.menuPrivilege}">
			 					<c:set property="checked" value="checked" var="x" />
			 				</c:if>     
						</c:forEach>	
								      <legend><input type='checkbox' class='checkbox' name='menuModule'  ${x }
								           value='${menuOUT.id.menuModule },${menuOUT.id.menuPrivilege}' 
								           id='${menuOUT.id.menuModule }_${menuOUT.id.menuPrivilege}'
								           title="${menuOUT.title }"
								           onClick='goSelect(this.id)'>${menuOUT.menuName }<!-- 一级菜单显示 -->
								      </legend>
								      <!-- 删除此属性设置，从新设置属性 -->
						          <c:remove var="x" scope="page"/>
								      
					      <c:forEach items="${menuArray }" var="menuIN" >
					         <c:if test="${menuIN.id.menuModule!=menuIN.id.menuPrivilege && menuOUT.id.menuModule==menuIN.id.menuModule  }">
								         
								         <c:forEach items="${privileges }" var="pp">
							 				<c:if test="${menuIN.id.menuModule==pp.id.menuModule &&
							 				               menuIN.id.menuPrivilege==pp.id.menuPrivilege}">
							 					<c:set property="checked" value="checked" var="xx" />
							 				</c:if>     
										  </c:forEach>	
								         
								         <div><input type='checkbox' class='checkbox' name='menuModule'   ${xx }
								               value='${menuIN.id.menuModule },${menuIN.id.menuPrivilege}' 
								               id='${menuIN.id.menuModule }_${menuIN.id.menuPrivilege}'
								               title="${menuIN.title }"
								                onClick='goSelect(this.id)' >${menuIN.menuName }<!-- 二级菜单显示 -->
								         </div>
						         <!-- 删除此属性设置，从新设置属性 -->
						          <c:remove var="xx" scope="page"/>
						         
						         
						     </c:if>
						  </c:forEach>
					 </fieldset>
			</c:if>
			 </c:forEach>
	       </td>
		</tr>
	</table>
	
 </c:if>
</div>
</s:form>
</body>

</html>