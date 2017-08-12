package com.zy.crm.serviceimpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.zy.crm.dao.IMenuPrivilegeDao;
import com.zy.crm.domain.MenuPrivilege;
import com.zy.crm.domain.MenuPrivilegeID;
import com.zy.crm.service.IMenuPrivilege;

public class MenuPrivilegeServiceImpl implements IMenuPrivilege {
	
	@Resource(name="MenuPrivilegeDaoImpl")
	private IMenuPrivilegeDao impd;

	@Override
	public void updateMenu(String string, String[] strings) {
		// TODO Auto-generated method stub
		//先删除再添加权限
		if(StringUtils.isNotBlank(string)&&strings.length>0){
			String hql=" and g.id.roleId=?";
			String params[]={string};
			
			List<MenuPrivilege> lists=impd.findObjectConditionNoPage(hql, params);
			impd.deleteAll(lists);
			
			//------------------------------------------
			for(int i =0 ; i<strings.length;i++){
				MenuPrivilege privilege=new MenuPrivilege();
				MenuPrivilegeID id=new MenuPrivilegeID();
				String ModelAndPrivilege[]=strings[i].split(",");
				id.setRoleId(string);
				id.setMenuModule(ModelAndPrivilege[0]);
				id.setMenuPrivilege(ModelAndPrivilege[1]);
				privilege.setId(id);
				impd.save(privilege);
			}
			
			
		}

	}

	@Override
	public List<MenuPrivilege> findAllMenuPriByID(String roleID) {
		// TODO Auto-generated method stub
		String hql=" and g.id.roleId =? ";
		String params[]={roleID};
		return impd.findObjectConditionNoPage(hql, params);
	}

	@Override
	public List<MenuPrivilege> findAllMenuPrivilege() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<>();
		map.put(" g.id.roleId ", " asc ");
		return impd.findObjectConditionNoPage(map);
	}

	@Override
	public List<MenuPrivilege> findAllMenuPrivilegeCache() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<>();
		map.put(" g.id.roleId ", " asc ");
		return impd.findObjectConditionNoPageCache(null,null,map);
	}

}
