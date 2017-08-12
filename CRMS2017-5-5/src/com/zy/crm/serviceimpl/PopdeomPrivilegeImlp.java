package com.zy.crm.serviceimpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.zy.crm.dao.IPopdeomPrivilegeDao;
import com.zy.crm.domain.Popdeom;
import com.zy.crm.domain.PopdeomPrivilege;
import com.zy.crm.domain.PopdeomPrivilegeID;
import com.zy.crm.service.IPopdeomPrivilege;

public class PopdeomPrivilegeImlp implements IPopdeomPrivilege {
	
	@Resource(name="PopdeomPrivilegeDaoImpl")
	private IPopdeomPrivilegeDao pp;

	@Override
	public List<Popdeom> updatePopdeom(String roleID, String[] strings) {
		// TODO Auto-generated method stub
		//因主键部可重复，所有在报错之前报原有数据  清空
		if(StringUtils.isNotBlank(roleID)&&strings.length>0){
			String hql=" and g.ids.roleId=? ";
			String []params={roleID};
			//先查找出在删除
			List<PopdeomPrivilege> privileges=pp.findObjectConditionNoPage(hql, params);
			pp.deleteAll(privileges);
		}
		
		
		//保存改权限对应的所有权限
		if(StringUtils.isNotBlank(roleID)){
		for(int i=0;i<strings.length;i++){
			if(StringUtils.isNotBlank(strings[i])){
			String []ModelPrivilege=strings[i].split(",");
			PopdeomPrivilege privilege=new PopdeomPrivilege();
			PopdeomPrivilegeID privilegeID=new PopdeomPrivilegeID();
			privilegeID.setRoleId(roleID);
			privilegeID.setPopedomModule(ModelPrivilege[0]);
			privilegeID.setPopedomPrivilege(ModelPrivilege[1]);
			privilege.setIds(privilegeID);
			pp.save(privilege);
			}
		}
		}
		return null;
	}

	@Override
	public List<PopdeomPrivilege> findPopedomPrivilegeByID(String roleId) {
		// TODO Auto-generated method stub
		String hql="";
		List<PopdeomPrivilege> list = null;
		if(StringUtils.isNotBlank(roleId)){
			hql=" and g.ids.roleId = ? ";
			String params[]={roleId};
			 list = pp.findObjectConditionNoPage(hql, params);
		}
		
		return list ;
	}

	@Override
	public List<PopdeomPrivilege> findAllpopdeomPrivilege() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(" g.ids.roleId ", " asc ");
		return pp.findObjectConditionNoPage(map);
	}

	@Override
	public List<PopdeomPrivilege> findAllpopdeomPrivilegeCache() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(" g.ids.roleId ", " asc ");
		return pp.findObjectConditionNoPageCache(null,null,map);
	}

}
