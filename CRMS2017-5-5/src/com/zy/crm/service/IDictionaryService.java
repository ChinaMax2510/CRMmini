package com.zy.crm.service;

import java.util.List;

import com.zy.crm.domain.DictionaryType;

public interface IDictionaryService {
	
	public List<DictionaryType> findDictionaryType(String code);

}
