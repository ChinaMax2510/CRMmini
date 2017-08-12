package com.zy.crm.service;

import java.util.List;

import com.zy.crm.domain.Province;

public interface IProvinceService {
	
	//查询所有城市
	public List<Province> findAllProvince();
	
	public Province findProvinceByName(String string);

}
