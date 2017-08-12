package com.zy.crm.serviceimpl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.zy.crm.bean.RoleSearch2;
import com.zy.crm.dao.IPopdeomDao;
import com.zy.crm.domain.Popdeom;
import com.zy.crm.domain.Role;
import com.zy.crm.service.IPopdeom;
import com.zy.crm.service.IRoleService;

public class PopdeomServiceImpl implements IPopdeom<Popdeom> {
	
	@Resource(name="PopdeomDaoImpl")
	private IPopdeomDao popdeomdao;

	@Override
	public List<Popdeom> findAllPopdeom() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(" g.sort ", "asc");
		return popdeomdao.findObjectConditionNoPage(map);
	}
	
	
}
