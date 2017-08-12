package com.zy.crm.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.zy.crm.bean.ReportBean;
import com.zy.crm.dao.IReportDao;

public class ReportDaoImpl extends CommonDaoImpl<ReportBean> implements IReportDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportBean> findReportBeanWithCompany() {
		// TODO Auto-generated method stub
		
		List<ReportBean> beans=this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				//sql:SELECT c.grade,COUNT(*) FROM c_company c GROUP BY c.grade
				String hql= "select new com.zy.crm.bean.ReportBean(c.grade,count(*)) from Company c group by c.grade ";
				Query query =arg0.createQuery(hql);
				return query.list();
			}
		});
		return beans;
	}

	@Override
	public List<ReportBean> findReportBeanWithUser() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<ReportBean> beans=this.getHibernateTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				//SELECT u.groupId, FROM sys_user u GROUP BY u.groupId
				String hql="select new com.zy.crm.bean.ReportBean(u.Group.name,count(*)) from User u group by u.Group ";
				Query query=arg0.createQuery(hql);
				return query.list();
			}
		}) ; 
		return beans;
	}

}
