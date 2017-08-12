package com.zy.crm.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.zy.crm.dao.ICommonDao;
import com.zy.crm.utils.GenericClass;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
	/**
	 * ע��hibernateTemplate
	 */
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("rawtypes")
	private Class classs=GenericClass.getGenericClass(this.getClass());
	 @Resource  
	    public void setSessionFacotry(SessionFactory sessionFacotry) {  
	        super.setSessionFactory(sessionFacotry);  
	    } 
	@SuppressWarnings("hiding")
	public<T> void save(T entity) {
		hibernateTemplate.save(entity);
		// TODO Auto-generated method stub
	}
	@SuppressWarnings("unchecked")
	@Override
	public  T findById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) hibernateTemplate.get(classs, id);
	}
	@SuppressWarnings("unchecked")
	public void delete(Serializable ... ids) {
		// TODO Auto-generated method stub
		for(Serializable id : ids){
			Object entity=hibernateTemplate.get(classs, id);
			if(entity==null){
				throw new RuntimeException("idΪ"+id+"�Ĳ��Ų����ڣ�");
			}
			hibernateTemplate.delete(entity);
		}
	}
	@Override
	public void update(T entity) {
		hibernateTemplate.update(entity);
		// TODO Auto-generated method stub
	}
	@Override
	public void deleteAll(Collection<T> c) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(c);
	}
	@Override
	public List<T> findObjectConditionNoPage(String hql,final Object[] params, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		//����HQL���
		  String HQL="select g from "+classs.getSimpleName()+" g where 1=1 ";
		//��HQL��������
		if(StringUtils.isNotBlank(hql)){
			HQL=HQL+hql;
		}
		if(map!=null){
		String orderbyStr=build_orderby(map);
		HQL=HQL+orderbyStr;
		}
		final String fHQL=HQL;
		@SuppressWarnings("unchecked")
		List<T> list=(List<T>) hibernateTemplate.execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery(fHQL);
				query.setCacheable(true);//��������
				if(params!=null){
					for(int i = 0 ; i < params.length; i ++){
						query.setParameter(i, params[i]);
					}
				}
				return ((T) query.list());
			}
		});
		
		return list;
	}
		@Override
		public List<T> findObjectConditionNoPage(HashMap<String, String> map) {
			// TODO Auto-generated method stub
			return this.findObjectConditionNoPage(null, null, map);
		}
		@Override
		public List<T> findObjectConditionNoPage(String hql, Object[] params) {
			// TODO Auto-generated method stub
			
			return this.findObjectConditionNoPage(hql, params, null);
		}
		@Override
		public List<T> findObjectConditionNoPageCache(HashMap<String, String> map) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<T> findObjectConditionNoPageCache(String hql, final Object[] params,
				HashMap<String, String> map) {
			// TODO Auto-generated method stub
			//����HQL���
			  String HQL="select g from "+classs.getSimpleName()+" g where 1=1 ";
			//��HQL��������
			if(StringUtils.isNotBlank(hql)){
				HQL=HQL+hql;
			}
			if(map!=null){
			String orderbyStr=build_orderby(map);
			HQL=HQL+orderbyStr;
			}
			final String fHQL=HQL;
			System.out.println("��������");
			@SuppressWarnings("unchecked")
			List<T> list=(List<T>) hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Query query=session.createQuery(fHQL);
					query.setCacheable(true);//ʹ�ö�������
					if(params!=null){
						for(int i = 0 ; i < params.length; i ++){
							query.setParameter(i, params[i]);
						}
					}
					return  query.list();
				}
			});
			return list;
		}


/*****************************************************************************************/
	

		//��������
		public String build_orderby(HashMap<String, String> mp){
			StringBuilder sb = new StringBuilder();
			sb.append(" order by ");
			//ע��ǰ��˳��
			if(mp!=null&&!mp.isEmpty()){
	//		������ʽһ��Iterator<String> iterator=mp.keySet().iterator();
	//			while (iterator.hasNext()) {
	//				String key = (String) iterator.next();
	//				String value=mp.get(key);
	//			}
				//��ʽ��
				for(Map.Entry<String, String> map : mp.entrySet()){
					sb.append(map.getKey()+" "+map.getValue()+",");
				}
				//ȥ�����һ�� " , "
				sb.deleteCharAt(sb.length()-1);
			}
			return sb.toString();
		}

	
	

}
