package com.zy.crm.service;

import java.util.List;

import com.zy.crm.bean.ReportBean;

public interface IReportService {
	/**
	 * 统计报表部门
	 * @return
	 */
	public List<ReportBean> findReportCompany();
	
	public List<ReportBean> findReportUser();

}
