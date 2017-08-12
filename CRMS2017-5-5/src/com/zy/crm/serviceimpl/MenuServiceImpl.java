package com.zy.crm.serviceimpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.zy.crm.daoimpl.MenuDaoImpl;
import com.zy.crm.domain.Menu;
import com.zy.crm.service.IMenuService;

public class MenuServiceImpl implements IMenuService {
	
	@Resource(name="MenuDaoImpl")
	private MenuDaoImpl menuDao;

	@Override
	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(" g.sort ", " asc ");
		return menuDao.findObjectConditionNoPage(map);
	}

	@Override
	public List<Menu> findAllMenuCache() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(" g.sort ", " asc ");
		return menuDao.findObjectConditionNoPageCache(null,null,map);
	}

}
