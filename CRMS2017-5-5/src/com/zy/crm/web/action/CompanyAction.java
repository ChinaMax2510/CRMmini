package com.zy.crm.web.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.bean.CompanySearch;
import com.zy.crm.container.ServiceProvider;
import com.zy.crm.dao.IDictionaryDao;
import com.zy.crm.domain.City;
import com.zy.crm.domain.Company;
import com.zy.crm.domain.DictionaryType;
import com.zy.crm.domain.Group;
import com.zy.crm.domain.Province;
import com.zy.crm.domain.User;
import com.zy.crm.service.ICityService;
import com.zy.crm.service.ICompanyService;
import com.zy.crm.service.IDictionaryService;
import com.zy.crm.service.IGroupService;
import com.zy.crm.service.IProvinceService;
import com.zy.crm.service.IUserService;
import com.zy.crm.serviceimpl.GroupSerivceImpl;
import com.zy.crm.utils.Beanutils;
import com.zy.crm.utils.Content;
import com.zy.crm.utils.PingyinUtils;
import com.zy.crm.utils.SQLDateConverter;
import com.zy.crm.utils.SessionUtils;
import com.zy.crm.utils.TypeChange;
import com.zy.crm.web.form.CompanyForm;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class CompanyAction extends BeansAction implements ModelDriven<CompanyForm> {
	
	private CompanyForm form=new CompanyForm();
	Company company=new Company();
	
	ICompanyService companyService=(ICompanyService) ServiceProvider.getService("CompanyServiceImpl");
	IDictionaryService dictionaryService=(IDictionaryService) ServiceProvider.getService("DictionaryServiceImpl");
	IProvinceService provinceService=(IProvinceService) ServiceProvider.getService("ProvinceServiceImpl");
	ICityService cityService=(ICityService)ServiceProvider.getService("CityServiceImpl");
	@SuppressWarnings("unchecked")
	IGroupService<Group> GroupSerivce=(IGroupService<Group>)ServiceProvider.getService("GroupSerivceImpl");
	IUserService userService=(IUserService)ServiceProvider.getService("UserServiceImpl");
	
	@Override
	public CompanyForm getModel() {
		// TODO Auto-generated method stub
		return form;
	}
	
	/**
	 * �ͻ���ʾ
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings("unused")
	public String list() throws IllegalAccessException, InvocationTargetException{
		//�ͻ��б�
		CompanySearch companySearch=new CompanySearch();
		BeanUtils.copyProperties(companySearch, form);
		User user=SessionUtils.getUserSession(request);
		List<Company> companys;
		String userid=user.getId().toString();
		//����
		if(!Beanutils.checkObjFieldIsNull(companySearch)){
			companys=companyService.findAllCompany(companySearch,user);
			if(companys!=null){
				this.request.setAttribute("companys", companys);
			}
		}else{
			companys=companyService.findAllCompany(user.getId(),user);
			
			if(companys!=null){
				this.request.setAttribute("companys", companys);
			}
		}
		
		
		
		//�ͻ��ȼ�
		Set<String> gradeArray=new HashSet<String>();
		Set<String> sourcesArray=new HashSet<String>();
		Set<String> qualityArray=new HashSet<String>();
		for( Company company : companys){
		gradeArray.add(company.getGrade());
		sourcesArray.add(company.getSource());
		qualityArray.add(company.getQuality());
		}
		this.request.setAttribute("companygrade", gradeArray);
		this.request.setAttribute("sourcesSelect", sourcesArray);
		
		this.request.setAttribute("qualitySelect", qualityArray);
		
		return "list";
	}
	
	public String add(){
		
		//�ͻ�����
		String code=companyService.codeRule("c_company");
		this.request.setAttribute("code", code);
		//��ʾ��������Ϣ
		List<DictionaryType> grades=dictionaryService.findDictionaryType(Content.GRADE);
		List<DictionaryType> regionName=dictionaryService.findDictionaryType(Content.REGION);
		List<DictionaryType> trade=dictionaryService.findDictionaryType(Content.TRADE);
		List<DictionaryType> source=dictionaryService.findDictionaryType(Content.SOURCE);
		List<DictionaryType> quality=dictionaryService.findDictionaryType(Content.QUALITY);
		List<DictionaryType> kind=dictionaryService.findDictionaryType(Content.KIND);
		List<DictionaryType> manage_type=dictionaryService.findDictionaryType(Content.manage_type);
		List<DictionaryType> scale=dictionaryService.findDictionaryType(Content.SCALE);
		this.request.setAttribute("scale", scale);
		this.request.setAttribute("source", source);
		this.request.setAttribute("quality", quality);
		this.request.setAttribute("kind", kind);
		this.request.setAttribute("manage_type", manage_type);
		this.request.setAttribute("trade", trade);
		this.request.setAttribute("regionName", regionName);
		this.request.setAttribute("grades", grades);
		//��ʾʡ������biao
		List<Province>provinces=provinceService.findAllProvince();
		this.request.setAttribute("provinces", provinces);
		//��ȡueer
		User user=SessionUtils.getUserSession(request);
		this.request.setAttribute("user", user);
		return "add";
	}
	
	//����ͻ�
	public String save() throws IllegalAccessException, InvocationTargetException{
		
		User user =new User ();
		ConvertUtils.register(new SQLDateConverter(), java.sql.Date.class);
		BeanUtils.copyProperties(company, form);
		if(StringUtils.isNotBlank(form.getOwnerUser())){
			user.setId(Integer.parseInt(form.getOwnerUser()));
			company.setOwnerUserID(user);
		}
		
		
		companyService.saveCompany(company,user);
		return "SHOW";
	}
	public String delete(){
		String []ids=this.request.getParameterValues("ids");
		User user=SessionUtils.getUserSession(request);
		companyService.deleteCompanyByID(ids,user);
		return "SHOW";
	}
	//��ת�༭ҳ��
	public String edit() throws IllegalAccessException, InvocationTargetException{
		//���ݻ���
		//��ʾ��������Ϣ
		List<DictionaryType> grades=dictionaryService.findDictionaryType(Content.GRADE);
		List<DictionaryType> regionName=dictionaryService.findDictionaryType(Content.REGION);
		List<DictionaryType> trade=dictionaryService.findDictionaryType(Content.TRADE);
		List<DictionaryType> source=dictionaryService.findDictionaryType(Content.SOURCE);
		List<DictionaryType> quality=dictionaryService.findDictionaryType(Content.QUALITY);
		List<DictionaryType> kind=dictionaryService.findDictionaryType(Content.KIND);
		List<DictionaryType> manage_type=dictionaryService.findDictionaryType(Content.manage_type);
		List<DictionaryType> scale=dictionaryService.findDictionaryType(Content.SCALE);
		this.request.setAttribute("scale", scale);
		this.request.setAttribute("source", source);
		this.request.setAttribute("quality", quality);
		this.request.setAttribute("kind", kind);
		this.request.setAttribute("manage_type", manage_type);
		this.request.setAttribute("trade", trade);
		this.request.setAttribute("regionName", regionName);
		this.request.setAttribute("grades", grades);
		//��ʾʡ������biao
		List<Province>provinces=provinceService.findAllProvince();
		this.request.setAttribute("provinces", provinces);
		//��ȡueer
		User user=SessionUtils.getUserSession(request);
		this.request.setAttribute("user", user);
		
		String companyID=request.getParameter("id");
		Company company=companyService.findCompanyByID(companyID,user);
		BeanUtils.copyProperties(form, company);
		
		
		return "edit";
	}
	//�������
	public String update() throws IllegalAccessException, InvocationTargetException{
		ConvertUtils.register(new SQLDateConverter(), Date.class);
		BeanUtils.copyProperties(company, form);
		User user=new User();
		user.setId(Integer.parseInt(form.getOwnerUser()));
		company.setOwnerUserID(user);
		
		companyService.updateCompany(company,user);
		return "SHOW";
	}
	
	//��ʾ����������
	public String showCity() throws IOException{
		//ʡ����
		String name = request.getParameter("name");
		Province province=provinceService.findProvinceByName(name);
		//��ʾ��������
		List<City> cities=cityService.findCituByPid(province.getId());
		
		//�Ѽ���ת��json��ʽ���ݴ��䵽jsp
		JSONArray jsonArray=JSONArray.fromObject(cities);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonArray.toString());
		return null;
	}
	
	/**
	 * ����ƴ������
	 * @return
	 * @throws IOException
	 */
	public String pinyin() throws IOException{
		String name=request.getParameter("name");
		if(StringUtils.isNotBlank(name)){
			String pinyi=PingyinUtils.converterToFirstSpell(name);
			response.getWriter().println(pinyi);
		}
		return null;
	}
	/**
	 * ��ʾ�������ô�����Ϣ
	 * @return
	 */
	public String shoeShareOne(){
		//��ȡ�ͻ�ID
		String id=request.getParameter("id");
		//ͨ��id�Ż�ȡ�ͻ�����
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(id,user);
		this.request.setAttribute("company", company);
		//��ȡ���в��Ŷ���
		List<Group> groups=GroupSerivce.findAllGroup();
		this.request.setAttribute("sysUserGroups", groups);
		//��ȡ�����û�����
		List<User> users=userService.findUser_Show();
		this.request.setAttribute("sysUsers", users);
		
		
		return "share";
	}
	
	/**
	 * ���Ĺ�������
	 * @return
	 */
	public String updateShareSetOne(){
		//��ȡ�ͻ�id
		String companyID=request.getParameter("id");
		//��ȡ��������û�������
		String userIDs[]=request.getParameterValues("uid");
			//ת����������
			Integer []UserIDs=TypeChange.ArrayStringToInt(userIDs);
		//��ȡģ����
		String moduleName=request.getParameter("s_module");
		//�����������  
		String sharetype=request.getParameter("sharetype");
			if(sharetype.equals("add")){
				User user=SessionUtils.getUserSession(request);
				companyService.addUpdateShareSetOne(companyID,UserIDs,moduleName,user);
			}
			if(sharetype.equals("minus")){
				User user=SessionUtils.getUserSession(request);
				companyService.minusUpdateShareSetOne(companyID,UserIDs,moduleName,user);
			}
			
		return"SHARE";
	}
	
	/**
	 * ��ʾȡ��������
	 */
	public String showShareCancel(){
		
		String compamyID=request.getParameter("id");
		//ͨ��id�Ż�ȡ�ͻ�����
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(compamyID,user);
		this.request.setAttribute("company", company);
		return "cancelView";
	}
	/**
	 * ȡ����������
	 */
	public String ShareCancel(){
		String compamyID=request.getParameter("id");
		String s_module=request.getParameter("s_module");
		//ͨ��id�Ż�ȡ�ͻ�����
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(compamyID,user);
		this.request.setAttribute("company", company);
		if(StringUtils.isNotBlank(compamyID)){
			companyService.updateShareCanael(compamyID,s_module,user);
		}
		return "shareCancel";
	}
	/**
	 * ��ʾ�ͻ�������û�
	 * @return
	 */
	public String showShareViewOne(){
		String compamyID=request.getParameter("id");
		//ͨ��id�Ż�ȡ�ͻ�����
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(compamyID,user);
		this.request.setAttribute("company", company);
		List<User> users=companyService.shareView(compamyID,user);
		if(users!=null){
		this.request.setAttribute("sysUsers", users);
		}
		return "shareView";
	}
	
	public String nextTouchTimeview(){
		
		return "nextTouchTime";
	}
	
	public String updateTouchTime(){
		String ids=request.getParameter("ids");
		//��ȡָ��ʱ��
		String next_touch_date=this.request.getParameter("next_touch_date");
		User user=SessionUtils.getUserSession(request);
		companyService.updateTouchTime(ids,next_touch_date,user);
		return "nextTouchTime";
	}
	
	//�����˱��
	public String changePersonView(){
		List<User> users=userService.findUser_Show();
		this.request.setAttribute("sysUserSelect", users);
		return "changePerson";
	}
	public String changePerson(){
		User user=SessionUtils.getUserSession(request);
		String userid=request.getParameter("new_owner");
		String companyids=request.getParameter("ids");
		companyService.updateChangePerson(userid,companyids,user);
		return "changePerson";
	}
}
