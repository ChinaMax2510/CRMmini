<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${applicationScope.rootpath}js/jqgrid/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript">
            var jq=jQuery.noConflict();
        </script>
<script type="text/javascript">
    jq(document).ready(function() {
        jq(".ulhead").bind("click",function(){
            var nextUl = jq(this).next("ul");
            var classInfo = nextUl.attr("class");
            //控制按钮样式
            var btObj = jq(this).find(".button");
            if(classInfo == ''){
                //隐藏子菜单
                nextUl.addClass("hideen_block");
                btObj.html("+");
            }else if(classInfo.indexOf("hideen_block") > -1){
                //显示子菜单
                nextUl.removeClass("hideen_block");
                btObj.html("-");
            }
        });
    });
</script>
<style type="text/css">
.main_left{
}
 
.store_left{height:1000px;width:206px;background:#EDF6FF;margin-top:10px;}
 
.store_menue { 
 margin: 0 auto; 
 padding-top: 15px; 
 list-style: none; 
 width: 150px; 
 border: 0px solid green; 
 font-size:16px;
 }
 /**
 标题父亲
 */
.ulhead{
display:inline-block;
width:100%;
font-weight:bold;
color:green;
cursor:pointer;
}
.ulhead .button{
    display:inline-block;
    float:left;
    width:10px;
    height:10px;
    line-height:10px;
    display:block;
    cursor: pointer;
    color: green;
    border:1px solid green;
    text-align:center;
}
 
/**
内容孩子
*/
.store_menue li{
margin-top:5px;
 list-style: none; 
}
 .store_menue li a { 
 display: block; 
 text-decoration: none; 
 color: blue; 
 background: #fff; 
 padding: 5px; 
 border: 0px solid #ccc; 
 text-decoration:underline;
 background:#EDF6FF;
 }
 
.store_menue li a:hover,.ulhead:hover {
 background:#bbead0; 
 } 
 .hideen_block{
 display:none;
 }
</style>
<div class="store_left">
    <ul class="store_menue">  
    <li>
      <span class="ulhead"><span class="button">-</span>店铺管理</span>  
      <ul>  
        <li><a href="#">店铺基本设置</a></li>  
        <li><a href="#">子账号管理</a></li>  
        <li><a href="#">帐房</a></li>  
      </ul>  
    </li>  
    <li>
      <span class="ulhead"><span class="button">-</span>交易管理</span>  
      <ul>  
        <li><a href="#">订单管理</a></li>  
        <li><a href="#">评价管理</a></li>  
      </ul>  
    </li> 
    <li>
      <span class="ulhead"><span class="button">-</span>宝贝管理</span>  
      <ul>  
        <li><a href="#">发布宝贝</a></li>  
        <li><a href="#">出售中的宝贝</a></li>  
        <li><a href="#">仓库中的宝贝</a></li>  
      </ul>  
    </li> 
    <li>
      <span class="ulhead"><span class="button">-</span>营销管理</span>  
      <ul>  
        <li><a href="#">占位申请</a></li>    
      </ul>  
    </li> 
  </ul>
 </div>