package com.zy.crm.domain;

import java.io.Serializable;

import org.hibernate.id.IntegralDataTypeHolder;

public class Menu implements Serializable {
	
	/**
	 *  
		sort
		menuName
		title
		url
		target
		icon
		remark
                 int
				varchar
				varchar
				varchar
				varchar
				varchar
text

	 */
	private MenuID id;//联合主键
	private Integer sort;//排序
	private String menuName;//菜单名称
	private String title;//鼠标放入提示
	private String url;//点击菜单连接
	private String target;//菜单框架类型
	private String icom;//菜单图片地址
	private String remark;//备注
	public MenuID getId() {
		return id;
	}
	public void setId(MenuID id) {
		this.id = id;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIcom() {
		return icom;
	}
	public void setIcom(String icom) {
		this.icom = icom;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
