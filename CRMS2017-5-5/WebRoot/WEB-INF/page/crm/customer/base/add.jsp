<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>客户资料新建</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<!--处理日期 开始 -->
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
<!--处理日期结束  -->

<script type="text/javascript">
	function name2pinyin(){
       var nameValue=$("#name").val();
       $.post("${pageContext.request.contextPath}/com/Company_pinyin.do",{name:nameValue},function(data,textStatuts){
              $("#pycode").val(data);
       });
	}

	function showCity(value){
		
		//json:  处理Javascript 和web服务器端的之间数据交换
	    $.post("${pageContext.request.contextPath}/com/Company_showCity.do",{name:value} ,function(data,textStatuts){
             //alert(data);
             //eval本身的问题。 由于json是以”{}”的方式来开始以及结束的，在JS中，
             //它会被当成一个语句块来处理，所以必须强制性的将它转换成一种表达式。
             var dataObj=eval("("+data+")");//转成Object对象。
             //alert(dataObj);
             
             //删除城市 删除原来的数据，
             $("select[name='city'] option[value!='']").remove();
             
             // <select name="city" style="width:90%">
                 //<option value="">--------</option>
             //</select>
             for(var i=0;i<dataObj.length;i++){
                   var $option=$("<option></option>");
                   $option.attr("value",dataObj[i].name);
                   $option.text(dataObj[i].name);
                   $("select[name='city']").append($option);
             }
        });
	}
	
</script>
</head>
<body>
<s:form name="companyForm" method="post" action="Company_save.do" namespace="/crm">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	客户-新建
</div>
<br>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';" 
		   onClick="document.forms[0].submit()">
	      <img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="">
		  <img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
    <span class="remarkText"></span>
</div>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">基本信息</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu1">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="16%" class="red">客户编码：</td>
			<td width="34%"><s:textfield id="code" name="code" value="%{#request.code}"  cssStyle="width:90%"/></td>
			<td width="16%" class="red">客户名称：</td>
			<td width="34%"> 
			  <s:textfield id="name" name="name" value=""  cssStyle="width:90%"  onblur="name2pinyin()"/>
			</td>
		  </tr>
		  <tr>
			<td>拼音码：</td>
			<td> 
			  <s:textfield id="pycode" name="pycode" value="" cssStyle="width:90%" readonly="true" cssClass="disabled"/>
			</td>
			<td>客户等级：</td>
			<td>
			   <s:if test="%{#request.grades!=null}">
			        <s:select list="%{#request.grades}" name="grade" id="grade" 
			                listKey="value"  listValue="value"
			                
			                cssStyle="width:90%"></s:select>
			   </s:if>    
			  
			</td>
		  </tr>
		  <tr>
			<td>区域名称：</td>
			<td>
			     <s:if test="#request.regionName!=null">
			        <s:select list="#request.regionName" name="regionName" id="regionName"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
            </td>
			<td>客户来源：</td>
			<td>
                <s:if test="#request.source!=null">
			        <s:select list="#request.source" name="source" id="source"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
			 </td>
		  </tr>
		  <tr>
			<td>所属行业：</td>
			<td><s:if test="#request.trade!=null">
			        <s:select list="#request.trade" name="trade" id="trade"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
           </td>
			<td>公司规模：</td>
			<td><s:if test="#request.scale!=null">
			        <s:select list="#request.scale" name="scale" id="scale"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
              </td>
		  </tr>
		  <tr>
			<td>省份：</td>
			<td>
			  <s:if test="#request.provinces!=null">
			      <s:select list="#request.provinces" name="province" id="province"  
			                listKey="name" listValue="name" 
			                headerKey="" headerValue="点击选择"
			                onchange="showCity(this.value)" cssStyle="width:90%"></s:select>
			  </s:if><!-- onchange事件在域的内容改变时发生 -->
			</td>
			<td>城市：</td>
			<td>
			     <s:select list="{}" name="city" id="city"
			                headerKey="" headerValue="点击选择" cssStyle="width:90%"></s:select>
		    </td>
		  </tr>
		  <tr>
			<td>邮政编码：</td>
			<td>
			  <s:textfield  name="postcode" value="" id="postcode"  cssStyle="width:90%"/>
			</td>
		  </tr>
		  <tr>
			<td>联系地址：</td>
			<td colspan="3">
			   <s:textfield  name="address" value="" id="address"  cssStyle="width:96%"/>
			</td>
			</tr>
		  <tr>
			<td>电子邮件：</td>
			<td>
			  <s:textfield  name="email" id="email"  cssStyle="width:96%"  value=""/>
			</td>
			<td>公司网站：</td>
			<td>
			   <s:textfield  name="web" id="web"  cssStyle="width:90%"  value=""/>
			</td>
		  </tr>
		  <tr>
			<td>电话一：</td>
			<td><s:textfield  name="tel1" id="tel1"  cssStyle="width:90%"  value=""/></td>
			<td>传真：</td>
			<td><s:textfield  name="fax" id="fax"  cssStyle="width:90%"  value=""/></td>
		  </tr>
		  <tr>
		  	<td>手机：</td>
			<td>
			    <s:textfield  name="mobile" id="mobile"  cssStyle="width:90%"  value=""/>
			</td>
			<td>电话二：</td>
			<td>
			    <s:textfield  name="tel2" id="tel2"  cssStyle="width:90%"  value=""/>
			</td>
		  </tr>
		  <tr>
			<td>下次联系时间:</td>
			<td>
			   <s:textfield  name="nextTouchDate" id="nextTouchDate"  cssStyle="width:90%" cssClass="dateClassStyle"  value=""/>
		    </td>
			<td>客户性质：</td>
			<td><s:if test="#request.quality!=null">
			        <s:select list="#request.quality" name="quality" id="quality"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
            </td>
		  </tr>
		  <tr>
			<td valign="top">备注：</td>
			<td colspan="3">
			  <s:textarea name="remark" rows="4" id="remark" cssStyle="width:96%"></s:textarea>
			</td>
		  </tr>
		  </table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" class="th_head">
		<div id="menuArrow2" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle2" style="font-weight:bold">企业信息</div>
	</th>
  </tr>
  <tr>
  	<td>
  <div id="menu2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="16%">经营范围：</td>
			<td width="34%">
				<s:if test="#request.manage_type!=null">
			        <s:select list="#request.manage_type" name="manage_type" id="manage_type"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
          </td>
			<td width="16%">企业性质：</td>
			<td width="34%">
			   <s:if test="#request.kind!=null">
			        <s:select list="#request.kind" name="kind" id="kind"  
			                listKey="value" listValue="value"
			                headerKey="" headerValue="点击选择"
			                cssStyle="width:90%"></s:select>
			     </s:if>
          </td>
		  </tr>
		  <tr>
			<td>法人代表：</td>
			<td>
			   <s:textfield  name="artificialPerson" id="artificialPerson"  cssStyle="width:90%"  value=""/></td>
			<td>注册资金：</td>
			<td><s:textfield  name="registeMoney" id="registeMoney"  cssStyle="width:90%"  value=""/></td>
		  </tr>
		  <tr>
			<td>开户银行：</td>
			<td><s:textfield  name="bank" id="bank"  cssStyle="width:90%"  value=""/></td>
			<td>银行账户：</td>
			<td><s:textfield  name="account" id="account"  cssStyle="width:90%"  value=""/></td>
		  </tr>
		  <tr>
			<td>公司税号：</td>
			<td><s:textfield  name="taxCode" id="taxCode"  cssStyle="width:90%"  value=""/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
  		</table>
	</div>
	</td>
	</tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" class="th_head">
		<div id="menuArrow3" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle3" style="font-weight:bold">其他信息</div>
	</th>
  </tr>
  <tr>
  	<td>
  <div id="menu3">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="16%">创建人：</td>
			<td width="34%">
			   <s:textfield  name="creater" id="creater"  cssStyle="width:90%" cssClass="disabled" />
			</td>
			<td width="16%">创建日期：</td>
			<td width="34%">
			  <s:textfield  name="createTime" id="createTime"  cssStyle="width:90%" cssClass="disabled" />
		   </td>
		  </tr>
		  <tr>
			<td>修改人：</td>
			<td>
			   <s:textfield  name="updater" id="updater"  cssStyle="width:90%" cssClass="disabled" />
			</td>
			<td>修改日期：</td>
			<td>
			<s:textfield  name="updateTime" id="updateTime"  cssStyle="width:90%"  cssClass="disabled" />
		   </td>
		  </tr>
		  <tr>
			<td>所属人：</td>
			<td>
			<s:if test="%{#request.user!=null}">
   			  <!-- 保存所有人的姓名 -->
   			  <s:textfield value="%{#request.user.cnname}" name="dispensePerson" id="dispensePerson"  cssStyle="width:90%" cssClass="disabled"/>
			  <!-- 保存所属人的id -->
			  <s:hidden name="ownerUser"value="%{#request.user.id}"/>
			  </s:if>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
  		</table>
	</div>
	</td>
  </tr>
</table>
</s:form>
<script src="${pageContext.request.contextPath}/ui/js/menu.js" type="text/javascript"></script>
</body>
</html>