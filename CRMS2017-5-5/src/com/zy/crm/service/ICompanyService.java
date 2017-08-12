package com.zy.crm.service;

import java.util.List;

import com.zy.crm.bean.CompanySearch;
import com.zy.crm.domain.Company;
import com.zy.crm.domain.User;

public interface ICompanyService {
	
	/**
	 * ��������ѯ���пͻ�
	 * @return �ͻ�����
	 */
	public List<Company> findAllCompany(User user);
	/**
	 *���������ͻ�
	 * ��������ѯ�ͻ�����
	 * @param companySearch �ͻ���������
	 * @return
	 */
	public List<Company> findAllCompany(CompanySearch companySearch,User user);
	/**
	 * ��ʾ��¼�û��Ŀͻ���Ϣ
	 * @param userid
	 * @return
	 */
	public List<Company> findAllCompany(Integer userid,User user);
	/**
	 * �������
	 * @param string ��������
	 * @return
	 */
	public String codeRule(String string);
	/**
	 * ����ͻ������ݿ�
	 * @param company �ͻ�����
	 */
	public void saveCompany(Company company,User user);
	/**
	 * ͨ��IDɾ���ͻ�
	 * @param ids
	 */
	public void deleteCompanyByID(String[] ids,User user);
	/**
	 * ͨ���ͻ�ID��ȡ��Ӧ�ͻ�����
	 * @param companyID �ͻ�ID
	 * @return �ͻ�����
	 */
	public Company findCompanyByID(String companyID,User user);
	/**
	 * ���¿ͻ�
	 * @param company �ͻ�����
	 */
	public void updateCompany(Company company,User  user);
	/**
	 * �ͻ�����/ί�������û�����
	 * @param companyID ͨ���ͻ�ID��ȡ�ͻ��޸Ŀͻ���Ϣ
	 * @param userIDs  �û�ID���� ���ѿͻ�ί�и���Щ�û�����/����
	 * @param moduleName ��������
	 */
	public void addUpdateShareSetOne(String companyID, Integer[] userIDs, String moduleName,User user);
	/**
	 * ���ٹ�������
	 * @param companyID
	 * @param userIDs
	 * @param moduleName
	 */
	public void minusUpdateShareSetOne(String companyID, Integer[] userIDs, String moduleName,User user);
	/**
	 * ȡ���ͻ�������
	 * @param compamyID�ͻ�ID��
	 * @param s_module ȡ������
	 */
	public void updateShareCanael(String compamyID,String s_module,User user);
	/**
	 * ��ʾ�ͻ����������Щ�û�
	 * @param compamyID �ͻ�ID
	 * @return �û�����
	 */
	public List<User> shareView(String compamyID,User user);
	/**
	 * �����´���ϵʱ��
	 * @param ids �����Ŀͻ�ID
	 * @param next_touch_date ָ��ʱ��
	 */
	public void updateTouchTime(String ids, String next_touch_date,User user);
	/**
	 * �����˱�������ǰѿͻ����������û�����
	 * @param userid
	 * @param companyids
	 */
	public void updateChangePerson(String userid, String companyids,User user);

}
