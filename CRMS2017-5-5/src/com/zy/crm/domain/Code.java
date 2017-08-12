package com.zy.crm.domain;

import java.io.Serializable;

public class Code implements Serializable {
	
	/**
	 * id	int	11
module	varchar	20
areaPrefix	varchar	20
areaTime	varchar	20
glideBit	int	11
currentCode	varchar	50
tabName	varchar	50
available	char	10
nextseq	varchar	20
curDate	varchar	10

	 */
	
	private Integer id;
	private String module;//类型
	private String areaPrefix;//编码前缀
	private String areaTime;//编码时间
	private Integer glideBit;//编码位数   如： 3  001
	
	public Integer getGlideBit() {
		return glideBit;
	}
	public void setGlideBit(Integer glideBit) {
		this.glideBit = glideBit;
	}
	private String currentCode;//结果预览
	private String tabName;//对应表名
	private String availavle;//是否是是第一次更改，如果之前没改动过，为 “Y" 否则为 ”N“
	private String nextseq;//下一个编号，预存
	private String curDate;//当前时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getAreaPrefix() {
		return areaPrefix;
	}
	public void setAreaPrefix(String areaPrefix) {
		this.areaPrefix = areaPrefix;
	}
	public String getAreaTime() {
		return areaTime;
	}
	public void setAreaTime(String areaTime) {
		this.areaTime = areaTime;
	}
	
	public String getCurrentCode() {
		return currentCode;
	}
	public void setCurrentCode(String currentCode) {
		this.currentCode = currentCode;
	}
	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	public String getAvailavle() {
		return availavle;
	}
	public void setAvailavle(String availavle) {
		this.availavle = availavle;
	}
	public String getNextseq() {
		return nextseq;
	}
	public void setNextseq(String nextseq) {
		this.nextseq = nextseq;
	}
	public String getCurDate() {
		return curDate;
	}
	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}

}
