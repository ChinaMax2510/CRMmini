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
	private String module;//����
	private String areaPrefix;//����ǰ׺
	private String areaTime;//����ʱ��
	private Integer glideBit;//����λ��   �磺 3  001
	
	public Integer getGlideBit() {
		return glideBit;
	}
	public void setGlideBit(Integer glideBit) {
		this.glideBit = glideBit;
	}
	private String currentCode;//���Ԥ��
	private String tabName;//��Ӧ����
	private String availavle;//�Ƿ����ǵ�һ�θ��ģ����֮ǰû�Ķ�����Ϊ ��Y" ����Ϊ ��N��
	private String nextseq;//��һ����ţ�Ԥ��
	private String curDate;//��ǰʱ��
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
