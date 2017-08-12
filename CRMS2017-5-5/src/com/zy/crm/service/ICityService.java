package com.zy.crm.service;

import java.util.List;

import com.zy.crm.domain.City;

public interface ICityService {
	
	public List<City> findAllCity();
	
	public List<City> findCituByPid(Integer pid);

}
