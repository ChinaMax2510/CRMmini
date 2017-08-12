package com.zy.crm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zy.crm.domain.PopdeomPrivilege;
import com.zy.crm.domain.User;

public interface ICommonDao<T> {
	
	@SuppressWarnings("hiding")
	public <T> void save(T entity);
	
	public T findById(Serializable id);
	
	void delete(Serializable ... id);
	
	void update(T entity);
	
	void deleteAll(Collection<T> c);
	
	public List<T> findObjectConditionNoPage(String hql,Object [] params,HashMap<String,String> map);
	
	public List<T> findObjectConditionNoPage(String hql , Object []params);
	
	public List<T> findObjectConditionNoPage(HashMap<String,String> map);
	/**
	 * 使用二级缓存查询数据
	 * @param map
	 * @return
	 */
	List<T> findObjectConditionNoPageCache(HashMap<String, String> map);
	List<T> findObjectConditionNoPageCache(String hql , Object []params,HashMap<String, String> map);

}
