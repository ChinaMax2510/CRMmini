package com.zy.crm.service;

import java.util.List;

import com.zy.crm.domain.Menu;

public interface IMenuService {
	
	public List<Menu> findAllMenu();

	public List<Menu> findAllMenuCache();

}
