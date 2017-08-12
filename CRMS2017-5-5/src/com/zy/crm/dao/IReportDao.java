package com.zy.crm.dao;

import java.util.List;

import com.zy.crm.bean.ReportBean;

public interface IReportDao extends ICommonDao<ReportBean> {

	List<ReportBean> findReportBeanWithCompany();
	
	List<ReportBean> findReportBeanWithUser();

}
