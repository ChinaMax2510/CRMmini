package com.zy.crm.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.zy.crm.dao.IDictionaryDao;
import com.zy.crm.domain.DictionaryType;
import com.zy.crm.service.IDictionaryService;

public class DictionaryServiceImpl implements IDictionaryService {
	
	@Resource(name="DictionaryDaoImpl")
	private IDictionaryDao dd;

	@Override
	public List<DictionaryType> findDictionaryType(String code) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(code)){
			String hql=" and g.code = ? ";
			Object params[]={code};
			DictionaryType dictionaryType = new DictionaryType();
			List<DictionaryType> types=dd.findObjectConditionNoPage(hql,params);
//			for( DictionaryType type : types){
//				if(type.getCode().equals(code)){
//					dictionaryType.setValue(type.getValue());
//					types.add(dictionaryType);
//					return types;
//				}
//			}
			return types;
					
		}
		
		return null;
	}

}
