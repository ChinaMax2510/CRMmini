package com.zy.crm.domain;
/**
 * Ȩ�޲���
 */
import java.io.Serializable;

/**�˱�������������  Ҫ����������д��һ������
 * popedomModule	varchar	30	0	0	0	0	0	0		0		gb2312	gb2312_chinese_ci		-1	0
popedomPrivilege	varchar	30	0	0	0	0	0	0		0		gb2312	gb2312_chinese_ci		-1	0
sort	int	11	0	-1	0	0	0	0		0					0	0
title	varchar	200	0	-1	0	0	0	0		0		gb2312	gb2312_chinese_ci		0	0
popedomName	varchar	200	0	-1	0	0	0	0		0		gb2312	gb2312_chinese_ci		0	0
remark	text	0	0	-1	0	0	0	0		0		gb2312	gb2312_chinese_ci		0	0

 * @author Administrator
 *
 */
public class Popdeom implements Serializable {
	
	private PopdeomID id;
	private Integer sort;//����
	private String title;//������ʾ
	private String popedomName;//Ȩ������
	private String remark;//��ע
	public PopdeomID getId() {
		return id;
	}
	public void setId(PopdeomID id) {
		this.id = id;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPopedomName() {
		return popedomName;
	}
	public void setPopedomName(String popedomName) {
		this.popedomName = popedomName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
