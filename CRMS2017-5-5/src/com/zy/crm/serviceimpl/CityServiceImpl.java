package com.zy.crm.serviceimpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.zy.crm.dao.ICityDao;
import com.zy.crm.domain.City;
import com.zy.crm.service.ICityService;

public class CityServiceImpl implements ICityService {
	
	@Resource(name="CityDaoImpl")
	private ICityDao citydao;

	@Override
	public List<City> findAllCity() {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<String,String>();
		map.put(" g.id ", " asc ");
		return citydao.findObjectConditionNoPage(map);
	}

	@Override
	public List<City> findCituByPid(Integer pid) {
		// TODO Auto-generated method stub
		if(pid!=null){
			String hql=" and g.pid = ? ";
			Object []params={pid};
			return citydao.findObjectConditionNoPage(hql, params);
		}
		return null;
	}

}
