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
	 * 客户显示
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings("unused")
	public String list() throws IllegalAccessException, InvocationTargetException{
		//客户列表
		CompanySearch companySearch=new CompanySearch();
		BeanUtils.copyProperties(companySearch, form);
		User user=SessionUtils.getUserSession(request);
		List<Company> companys;
		String userid=user.getId().toString();
		//搜索
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
		
		
		
		//客户等级
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
		
		//客户编码
		String code=companyService.codeRule("c_company");
		this.request.setAttribute("code", code);
		//显示下拉表信息
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
		//显示省份下拉biao
		List<Province>provinces=provinceService.findAllProvince();
		this.request.setAttribute("provinces", provinces);
		//获取ueer
		User user=SessionUtils.getUserSession(request);
		this.request.setAttribute("user", user);
		return "add";
	}
	
	//保存客户
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
	//跳转编辑页面
	public String edit() throws IllegalAccessException, InvocationTargetException{
		//数据回显
		//显示下拉表信息
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
		//显示省份下拉biao
		List<Province>provinces=provinceService.findAllProvince();
		this.request.setAttribute("provinces", provinces);
		//获取ueer
		User user=SessionUtils.getUserSession(request);
		this.request.setAttribute("user", user);
		
		String companyID=request.getParameter("id");
		Company company=companyService.findCompanyByID(companyID,user);
		BeanUtils.copyProperties(form, company);
		
		
		return "edit";
	}
	//保存更改
	public String update() throws IllegalAccessException, InvocationTargetException{
		ConvertUtils.register(new SQLDateConverter(), Date.class);
		BeanUtils.copyProperties(company, form);
		User user=new User();
		user.setId(Integer.parseInt(form.getOwnerUser()));
		company.setOwnerUserID(user);
		
		companyService.updateCompany(company,user);
		return "SHOW";
	}
	
	//显示城市下拉表
	public String showCity() throws IOException{
		//省的名
		String name = request.getParameter("name");
		Province province=provinceService.findProvinceByName(name);
		//显示城市下拉
		List<City> cities=cityService.findCituByPid(province.getId());
		
		//把集合转成json形式数据传输到jsp
		JSONArray jsonArray=JSONArray.fromObject(cities);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonArray.toString());
		return null;
	}
	
	/**
	 * 生成拼音编码
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
	 * 显示共享设置窗口信息
	 * @return
	 */
	public String shoeShareOne(){
		//获取客户ID
		String id=request.getParameter("id");
		//通过id号获取客户对象
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(id,user);
		this.request.setAttribute("company", company);
		//获取所有部门对象
		List<Group> groups=GroupSerivce.findAllGroup();
		this.request.setAttribute("sysUserGroups", groups);
		//获取所有用户对象
		List<User> users=userService.findUser_Show();
		this.request.setAttribute("sysUsers", users);
		
		
		return "share";
	}
	
	/**
	 * 更改共享设置
	 * @return
	 */
	public String updateShareSetOne(){
		//获取客户id
		String companyID=request.getParameter("id");
		//获取共享对象用户底数组
		String userIDs[]=request.getParameterValues("uid");
			//转型整型数组
			Integer []UserIDs=TypeChange.ArrayStringToInt(userIDs);
		//获取模块名
		String moduleName=request.getParameter("s_module");
		//分享操作类型  
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
	 * 显示取消共享窗口
	 */
	public String showShareCancel(){
		
		String compamyID=request.getParameter("id");
		//通过id号获取客户对象
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(compamyID,user);
		this.request.setAttribute("company", company);
		return "cancelView";
	}
	/**
	 * 取消共享设置
	 */
	public String ShareCancel(){
		String compamyID=request.getParameter("id");
		String s_module=request.getParameter("s_module");
		//通过id号获取客户对象
		User user=SessionUtils.getUserSession(request);
		Company company=companyService.findCompanyByID(compamyID,user);
		this.request.setAttribute("company", company);
		if(StringUtils.isNotBlank(compamyID)){
			companyService.updateShareCanael(compamyID,s_module,user);
		}
		return "shareCancel";
	}
	/**
	 * 显示客户共享的用户
	 * @return
	 */
	public String showShareViewOne(){
		String compamyID=request.getParameter("id");
		//通过id号获取客户对象
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
		//获取指定时间
		String next_touch_date=this.request.getParameter("next_touch_date");
		User user=SessionUtils.getUserSession(request);
		companyService.updateTouchTime(ids,next_touch_date,user);
		return "nextTouchTime";
	}
	
	//经手人变更
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
