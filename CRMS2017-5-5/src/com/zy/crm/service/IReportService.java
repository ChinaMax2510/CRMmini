package com.zy.crm.service;

import java.util.List;

import com.zy.crm.bean.ReportBean;

public interface IReportService {
	/**
	 * ͳ�Ʊ�����
	 * @return
	 */
	public List<ReportBean> findReportCompany();
	
	public List<ReportBean> findReportUser();

}
