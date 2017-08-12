package com.zy.crm.serviceimpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.zy.crm.dao.IProvinceDao;
import com.zy.crm.domain.Province;
import com.zy.crm.service.IProvinceService;

public class ProvinceServiceImpl implements IProvinceService {
	
	@Resource(name="ProvinceDaoImpl")
	private IProvinceDao  provinceDao;

	@Override
	public List<Province> findAllProvince() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String,String>();
		map.put(" g.id ", " asc ");
		return provinceDao.findObjectConditionNoPage(map);
	}

	@Override
	public Province findProvinceByName(String string) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(string)){
			String hql = " and g.name = ? ";
			Object []params={string};
			List<Province> list=provinceDao.findObjectConditionNoPage(hql, params);
			if(list!=null&&list.size()==1){
				return list.get(0);
			}
		}
		
		return null;
	}

}
