<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!-- 自定义标签 -->
<%@ taglib uri="/WEB-INF/tlds/menu.tld"  prefix="myTag"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单操作</title>
<style type="text/css">
ul{list-style:none;padding:0;}
#menu .tree1{padding:14px 14px 14px 39px;color:#6F93FF;font-size:16px;font-family:"黑体";border-bottom:solid 1px #eee;}
#menu #tree_root{overflow:auto;}
#menu #tree_root li span{display:block;height:18px;line-height:18px;color:#222;cursor:pointer;}
#menu #tree_root li span.tree2{padding:6px 6px 6px 20px;}
#menu #tree_root li span.tree3{padding:6px 6px 6px 34px;}
#menu #tree_root li span.tree4{padding:6px 6px 6px 48px;}
#menu #tree_root li span.tree5{padding:6px 6px 6px 62px;}
#menu li .hover,#menu li span:hover{background-color:#e9edf6;}
#menu ul{overflow:hidden;}
#menu ul li b{font-weight:normal;position:relative;padding-left:16px;}
#menu ul li b:before{display:block;font-size:0;top:5px;left:0;content:"";width:4px;height:4px; border:solid 1px transparent;transform:rotate(45deg);-o-transform:rotate(45deg);-ms-transform:rotate(45deg);-moz-transform:rotate(45deg);-webkit-transform:rotate(45deg);position:absolute;}
#menu ul li .On:before,#menu ul li .On2Off:before{top:3px;border-bottom-color:#999;border-right-color:#999;}
#menu ul li .Off:before{top:5px;border-top-color:#999;border-right-color:#999;}
#menu ul li .On2Off:before{transform:rotate(0deg);-o-transform:rotate(0deg);-ms-transform:rotate(0deg);-moz-transform:rotate(0deg);-webkit-transform:rotate(0deg);}

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!--http://code.jquery.com/jquery-1.11.1.min.js-->
<script type="text/javascript">
$(function(){
	//目录树折叠按钮 -------------------------------
	function setTreeStyle(obj){//方法回调
		var objStyle = obj.children("b");
		var objList = obj.siblings("ul");
		if(objList.length == 1){
			var style = objStyle.attr("class");
			objStyle.attr("class","On2Off");
			setTimeout(
				function(){
					if(style == "Off"){
						objList.parent().siblings("li").children("span").children(".On").each(function(){
							setTreeStyle($(this).parent());	
						});
						var H = objList.innerHeight()
						objList.css({display:"block",height:"0"});
						objList.animate({height:H},300,function(){$(this).css({height:"auto"});});
						objStyle.attr("class","On");
					}
					else if(style == "On"){
						objList.find("li").children("span").children(".On").each(function(){
							setTreeStyle($(this).parent());	
						});
						var H = objList.innerHeight()
						objList.animate({height:0},300,function(){$(this).css({height:"auto",display:"none"})});
						objStyle.attr("class","Off");
					}
				},
				42
			);
		}
	}
	$("#tree_root").find("li").children("span").click(function(){
		setTreeStyle($(this));
	});
	// -----------------------------------------	
	$('.tree3 a').on('click',function(e){
		var that =this;
		$('#rightFrame',parent.document).attr('src',$(that).data('href'));
		
	});
})
</script>
</head>

<div id="menu">
    <h1 class="tree1">菜单操作</h1>
    
    <c:if test="${ ! empty menus }" >
    <ul id="tree_root">
    	<c:forEach items="${menus }" var="menuOUT">
    	  <c:if test="${menuOUT.id.menuModule==menuOUT.id.menuPrivilege }">
    	  	<myTag:checkMemu privilege="${menuOUT.id.menuPrivilege }" module="${menuOUT.id.menuModule}">
	        <li>
	            <span class="tree2"><b class="Off">${menuOUT.menuName }</b></span>
	            <ul style="display:none;">
	            	<c:forEach items="${menus }" var="menuIN">
	            		<c:if test="${menuOUT.id.menuModule==menuIN.id.menuModule &&
	            						menuIN.id.menuModule!=menuIN.id.menuPrivilege }">
	            		<myTag:checkMemu privilege="${menuIN.id.menuPrivilege }" module="${menuIN.id.menuModule }">
	                  		<li><span class="tree3"><b><a  data-href="${pageContext.request.contextPath }${menuIN.url}">${menuIN.menuName }</a></b></span></li>
	            		</myTag:checkMemu>
	                	</c:if>
	                </c:forEach>
	            </ul>
	        </li>
	        </myTag:checkMemu>    
          </c:if>
       </c:forEach>
        
        
    </ul>
    </c:if>
</div>

</html>
