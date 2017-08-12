package com.zy.crm.service;

import java.util.List;

import com.zy.crm.bean.CompanySearch;
import com.zy.crm.domain.Company;
import com.zy.crm.domain.User;

public interface ICompanyService {
	
	/**
	 * 无条件查询所有客户
	 * @return 客户集合
	 */
	public List<Company> findAllCompany(User user);
	/**
	 *条件搜索客户
	 * 有条件查询客户集合
	 * @param companySearch 客户查新条件
	 * @return
	 */
	public List<Company> findAllCompany(CompanySearch companySearch,User user);
	/**
	 * 显示登录用户的客户信息
	 * @param userid
	 * @return
	 */
	public List<Company> findAllCompany(Integer userid,User user);
	/**
	 * 编码规则
	 * @param string 编码类型
	 * @return
	 */
	public String codeRule(String string);
	/**
	 * 保存客户到数据库
	 * @param company 客户对象
	 */
	public void saveCompany(Company company,User user);
	/**
	 * 通过ID删除客户
	 * @param ids
	 */
	public void deleteCompanyByID(String[] ids,User user);
	/**
	 * 通过客户ID获取对应客户对象
	 * @param companyID 客户ID
	 * @return 客户对象
	 */
	public Company findCompanyByID(String companyID,User user);
	/**
	 * 更新客户
	 * @param company 客户对象
	 */
	public void updateCompany(Company company,User  user);
	/**
	 * 客户分享/委托其他用户管理
	 * @param companyID 通过客户ID获取客户修改客户信息
	 * @param userIDs  用户ID数组 ，把客户委托给这些用户管理/共享
	 * @param moduleName 共享类型
	 */
	public void addUpdateShareSetOne(String companyID, Integer[] userIDs, String moduleName,User user);
	/**
	 * 减少共享数量
	 * @param companyID
	 * @param userIDs
	 * @param moduleName
	 */
	public void minusUpdateShareSetOne(String companyID, Integer[] userIDs, String moduleName,User user);
	/**
	 * 取消客户被分享
	 * @param compamyID客户ID号
	 * @param s_module 取消类型
	 */
	public void updateShareCanael(String compamyID,String s_module,User user);
	/**
	 * 显示客户共享给了哪些用户
	 * @param compamyID 客户ID
	 * @return 用户集合
	 */
	public List<User> shareView(String compamyID,User user);
	/**
	 * 更改下次联系时间
	 * @param ids 被更改客户ID
	 * @param next_touch_date 指定时间
	 */
	public void updateTouchTime(String ids, String next_touch_date,User user);
	/**
	 * 经手人变更，就是把客户交给其他用户管理
	 * @param userid
	 * @param companyids
	 */
	public void updateChangePerson(String userid, String companyids,User user);

}
