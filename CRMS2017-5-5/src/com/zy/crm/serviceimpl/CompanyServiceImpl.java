package com.zy.crm.serviceimpl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.zy.crm.bean.CompanySearch;
import com.zy.crm.dao.ICodeRuleDao;
import com.zy.crm.dao.ICompanyDao;
import com.zy.crm.dao.IOperateLoggDao;
import com.zy.crm.dao.IUserDao;
import com.zy.crm.domain.Code;
import com.zy.crm.domain.Company;
import com.zy.crm.domain.OperateeLogg;
import com.zy.crm.domain.User;
import com.zy.crm.service.ICompanyService;
import com.zy.crm.utils.SessionUtils;
import com.zy.crm.utils.TypeChange;

public class CompanyServiceImpl implements ICompanyService {
	
	@Resource(name="CompanyDaoImpl")
	private ICompanyDao companyDao;
	@Resource(name="CodRuleDaoImpl")
	private ICodeRuleDao coderuleDao;
	@Resource(name="UserDaoImpl")
	private IUserDao userdao;
	@Resource(name="OperateLoggImpl")
	private IOperateLoggDao OperateeLogg;
	OperateeLogg operateeLogg=new OperateeLogg();
	@Override
	public List<Company> findAllCompany(User curUser) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String , String>();
		map.put(" g.id ", " asc ");
		
		return companyDao.findObjectConditionNoPage(map);
	}
	@Override
	public String codeRule(String string) {
		// TODO Auto-generated method stub
		String curCode=null;
		String curTime=null;
		String areaPreFix=null;
		if(StringUtils.isNotBlank(string)){
			String hql=" and g.tabName = ? ";
			String params[]={string};
			List<Code> codes=coderuleDao.findObjectConditionNoPage(hql, params);
			if(codes==null||codes.size()!=1){
				throw new RuntimeException("客户编码生成有误！！！");
			}else{
				Code code=codes.get(0);
				curTime=DateFormatUtils.format(new Date(), code.getAreaTime());
				if(code.getAvailavle().equals("Y")||!code.getCurDate().equals(curTime)){//如果是Y说明之前没被修改过，这是第一次
					//获取流水位数
					Integer glideBit=code.getGlideBit();
					String fristNumber=TypeChange.getFristNumber(glideBit);
					curTime=DateFormatUtils.format(new Date(), code.getAreaTime());
					areaPreFix=code.getAreaPrefix();
					curCode=areaPreFix+"-"+curTime+"-"+fristNumber;
					//更新数据库
					code.setAvailavle("N");
					code.setCurrentCode(curCode);
					code.setCurDate(curTime);
					code.setNextseq(TypeChange.getNextNumber(fristNumber));
					coderuleDao.update(code);
				}else{
					String nextseq=code.getNextseq();//获取预存编码号
					curTime=DateFormatUtils.format(new Date(), code.getAreaTime());
					areaPreFix=code.getAreaPrefix();
					curCode=areaPreFix+"-"+curTime+"-"+nextseq;
					//更新数据库
					code.setCurrentCode(curCode);
					code.setCurDate(curTime);
					code.setNextseq(TypeChange.getNextNumber(nextseq));
					coderuleDao.update(code);
				}
			}
		}
		return curCode;
	}
	@Override
	public List<Company> findAllCompany(Integer userid,User curUser) {
		// TODO Auto-generated method stub
		String hql="";
		if(userid!=null){
			hql=hql+" and g.ownerUserID.id = ? ";
		}
		Integer []params={userid};
		HashMap<String, String> map=new HashMap<>();
		map.put(" g.id ", " asc ");
		
		operateeLogg.setUserName(curUser.getName());
		operateeLogg.setCnname(curUser.getCnname());
		operateeLogg.setActionType("查看所有客户");
		operateeLogg.setActionDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		operateeLogg.setActionContent("用户"+curUser.getCnname()+"在"+operateeLogg.getActionDate()+"查看了所有客户列表");
		OperateeLogg.save(operateeLogg);
		return companyDao.findObjectConditionNoPage(hql, params,map);
	}
	@Override
	public List<Company> findAllCompany(CompanySearch companySearch,User curUser) {
		// TODO Auto-generated method stub
		String hql="";
		List<String> param=new ArrayList<>();
		 if(StringUtils.isNotBlank(companySearch.getCode())){
			hql=hql+" and g.code = ? ";
			param.add(companySearch.getCode());
		}else if(StringUtils.isNotBlank(companySearch.getGrade())){
			hql=hql+" and g.grade = ? ";
			param.add(companySearch.getGrade());
		}else if(StringUtils.isNotBlank(companySearch.getName())){
			hql=hql+" and g.name = ?";
			param.add(companySearch.getName());
		}else if(StringUtils.isNotBlank(companySearch.getPycode())){
			hql=hql+" and g.pycode = ?";
			param.add(companySearch.getPycode());
		}else if(StringUtils.isNotBlank(companySearch.getQuality())){
			hql=hql+" and g.quality = ?";
			param.add(companySearch.getQuality());
		}else if(StringUtils.isNotBlank(companySearch.getSource())){
			hql=hql+" and g.source = ?";
			param.add(companySearch.getSource());
		}else if(StringUtils.isNotBlank(companySearch.getTel1())){
			hql=hql+" and g.tel1 = ?";
			param.add(companySearch.getTel1());
		}
		Object []params= param.toArray();
		HashMap<String, String> map=new HashMap<>();
		map.put(" g.id ", " asc ");
		operateeLogg.setUserName(curUser.getName());
		operateeLogg.setCnname(curUser.getCnname());
		operateeLogg.setActionType("条件搜索客户信息");
		operateeLogg.setActionDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		operateeLogg.setActionContent("用户"+curUser.getCnname()+"在"+operateeLogg.getActionDate()+"搜索了客户列表");
		OperateeLogg.save(operateeLogg);
		return companyDao.findObjectConditionNoPage(hql, params,map);
	}
	@Override
	public void saveCompany(Company company,User curUser) {
		// TODO Auto-generated method stub
		if(company!=null){
			companyDao.save(company);
		}
	}
	@Override
	public void deleteCompanyByID(String[] ids,User curUser) {
		// TODO Auto-generated method stub<
		List<Company> list=new ArrayList<Company>();
		if(ids!=null){
			for(int i=0 ; i<ids.length;i++){
			Company company=companyDao.findById(Integer.parseInt(ids[i]));
			list.add(company);
			}
			companyDao.deleteAll(list);
		}
	}
	@Override
	public Company findCompanyByID(String companyID,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(companyID)){
			String hql=" and g.id = ? ";
			Object []params={Integer.parseInt(companyID)};
			List<Company> companies=companyDao.findObjectConditionNoPage(hql, params);
			if(companies!=null&&companies.size()==1){
				return companies.get(0);
			}
		}
		return null;
	}
	@Override
	public void updateCompany(Company company,User curUser) {
		// TODO Auto-generated method stub
		if(company!=null){
			companyDao.update(company);
		}
	}

	@Override
	public void addUpdateShareSetOne(String companyID, Integer[] userIDs, String moduleName,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(companyID)){
			//仅共享客户资料
			if(StringUtils.isNotBlank(moduleName)&&moduleName.equals("c_company")){
				Company company=companyDao.findById(Integer.parseInt(companyID));
				if(company!=null){
					StringBuffer buffer=new StringBuffer();
					for(int i=0;i<userIDs.length;i++){
						buffer.append(userIDs[i]+"#");
					}
					if(company.getShareFlag()=='N'){
						company.setShareFlag('Y');//private Character shareFlag;  
						company.setShareIds("#"+buffer);
						companyDao.update(company);
					}else{
						company.setShareFlag('Y');
						company.setShareIds(company.getShareIds()+buffer);
						companyDao.update(company);
					}
				}
			}
		}
	}

	@Override
	public void minusUpdateShareSetOne(String companyID, Integer[] userIDs, String moduleName,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(moduleName)&&StringUtils.isNotBlank(companyID)){
			Company company=companyDao.findById(Integer.parseInt(companyID));
			if(company!=null){
				if('Y'==company.getShareFlag()){
					String shareIDs=company.getShareIds();
					for(int i =0 ; i<userIDs.length;i++){
						String uid="#"+userIDs[i]+"#";
								while(true){
									if(shareIDs.contains(uid)){
										shareIDs=shareIDs.replaceAll(uid, "#");
									}else{
										break;//跳出循环。
									}
								}
								if("#".equals(shareIDs)){
									company.setShareFlag('N');
									company.setShareIds(null);
									companyDao.update(company);
								}else{
									company.setShareIds(shareIDs);
									companyDao.update(company);
								}
					}
				}
			}
		}
	}

	@Override
	public void updateShareCanael(String compamyID,String s_module,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(compamyID)&&StringUtils.isNotBlank(s_module)){
			if("c_company".equals(s_module)){
			    Company company=companyDao.findById(Integer.parseInt(compamyID));
				if(company!=null){
					company.setShareFlag('N');
					company.setShareIds(null);
					companyDao.update(company);
				}
			}
		}
		
	}

	@Override
	public List<User> shareView(String compamyID,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(compamyID)){
			Company company=companyDao.findById(Integer.parseInt(compamyID));
			if(company!=null){
				String shareIds=company.getShareIds();
				if(shareIds!=null){
					String shareIDs[]=shareIds.split("#");
					Integer []integers=TypeChange.ArrayStringToInt(shareIDs);
					List<Integer> strings=new ArrayList<Integer>();
					//select * from tablename where id in(?,?,?,?)
					if(integers!=null&&integers.length>0){
						StringBuffer buffer=new StringBuffer();
						buffer.append(" and g.id in(");
						for(int i =0 ; i<integers.length;i++){
							buffer.append("?,");
							strings.add(integers[i]);
						}
						buffer.deleteCharAt(buffer.length()-1);//去掉最后一个无用","
						buffer.append(")");
						return userdao.findObjectConditionNoPage(buffer.toString(), strings.toArray());
					}
				}
			}
		}
		return null;
	}
	@Override
	public void updateTouchTime(String ids, String next_touch_date,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(next_touch_date)&&StringUtils.isNotBlank(ids)){
			Integer []IDS=TypeChange.ArrayStringToInt(ids.split(","));
			if(IDS!=null&&IDS.length>0){
				for(int i =0;i<IDS.length;i++){
					Company company=companyDao.findById(IDS[i]);
					java.sql.Date nextTouchDate=java.sql.Date.valueOf(next_touch_date);
					company.setNextTouchDate(nextTouchDate);
					company.setDispenseDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
					companyDao.update(company);
				}
				
			}
		}
		
	}
	@Override
	public void updateChangePerson(String userid, String companyids,User curUser) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(userid)&&StringUtils.isNotBlank(companyids)){
			Integer userID=Integer.parseInt(userid);
			Integer []integers=TypeChange.ArrayStringToInt(companyids.split(","));
			if(userID!=null&&integers!=null){
				User user=new User();
				for(int i =0 ;i<integers.length;i++){
					Company company=companyDao.findById(integers[i]);
					user.setId(userID);
					company.setOwnerUserID(user);
					companyDao.update(company);
				}
				
			}
		}
		
	}

	

}
