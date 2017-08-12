package com.zy.crm.domain;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Company implements Serializable {
	
	private Integer id;//����ID
	private String code;//�ͻ�����
	private String name;//�ͻ�����
	private String pycode;//ƴ����
	private String grade;//�ͻ��ȼ�------
	private String regionName;//������������
	private String source;//�ͻ���Դ----------
	private String trade;//������ҵ
	private String scale;//��˾��ģ
	private String province;//����
	private String city;//����
	private String postcode;//��������
	private String address;//��ϵ��ַ
	private String email;//����
	private String web;//��ַ
	private String tel1;//�绰
	private String fax;//����
	private String mobile;//�ֻ�
	private String tel2;//�绰��
	private Date nextTouchDate;//�´���ϵʱ��
	private String quality;//�ͻ�����-----------
	private String remark;//��ע
	private String dealin;//��ҵ��Ӫ��Χ�������б�
	private String kind;//��ҵ���ʣ������б�)
	private String artificialPerson;//���˴��������ˣ�
	private String registeMoney;//ע���ʽ�
	private String bank;//��������
	private String account;//�����˺�
	private String taxCode;//��˾˰��
	private String creater;//������
	private String createTime;//����ʱ��
	private String updater;//�޸ĸ���
	private String updateTime;//�޸�����
	private String dispensePerson;              //�����˵ķ�������
	private String dispenseDate;                //#��������(�����˱��������)-----
	private Character shareFlag;                //#�����־ Y(����)��N(������)
	private String shareIds;   
	//����ͻ���Ӧһ���û�  ���
	private User ownerUserID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPycode() {
		return pycode;
	}
	public void setPycode(String pycode) {
		this.pycode = pycode;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public Date getNextTouchDate() {
		return nextTouchDate;
	}
	public void setNextTouchDate(Date nextTouchDate) {
		this.nextTouchDate = nextTouchDate;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDealin() {
		return dealin;
	}
	public void setDealin(String dealin) {
		this.dealin = dealin;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getArtificialPerson() {
		return artificialPerson;
	}
	public void setArtificialPerson(String artificialPerson) {
		this.artificialPerson = artificialPerson;
	}
	public String getRegisteMoney() {
		return registeMoney;
	}
	public void setRegisteMoney(String registeMoney) {
		this.registeMoney = registeMoney;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDispensePerson() {
		return dispensePerson;
	}
	public void setDispensePerson(String dispensePerson) {
		this.dispensePerson = dispensePerson;
	}
	public String getDispenseDate() {
		return dispenseDate;
	}
	public void setDispenseDate(String dispenseDate) {
		this.dispenseDate = dispenseDate;
	}
	public Character getShareFlag() {
		return shareFlag;
	}
	public void setShareFlag(Character shareFlag) {
		this.shareFlag = shareFlag;
	}
	public String getShareIds() {
		return shareIds;
	}
	public void setShareIds(String shareIds) {
		this.shareIds = shareIds;
	}
	public User getOwnerUserID() {
		return ownerUserID;
	}
	public void setOwnerUserID(User ownerUserID) {
		this.ownerUserID = ownerUserID;
	}
	
	
	
	
}
