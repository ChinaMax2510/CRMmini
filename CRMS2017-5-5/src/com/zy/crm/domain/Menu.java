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
	private MenuID id;//��������
	private Integer sort;//����
	private String menuName;//�˵�����
	private String title;//��������ʾ
	private String url;//����˵�����
	private String target;//�˵��������
	private String icom;//�˵�ͼƬ��ַ
	private String remark;//��ע
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
