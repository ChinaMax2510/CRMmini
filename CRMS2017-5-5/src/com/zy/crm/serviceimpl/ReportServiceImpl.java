package com.zy.crm.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import com.zy.crm.bean.ReportBean;
import com.zy.crm.dao.IReportDao;
import com.zy.crm.service.IReportService;

public class ReportServiceImpl implements IReportService {
	@Resource(name="ReportDaoImpl")
	private IReportDao reportDao;
	public List<ReportBean> findReportCompany(){
		List<ReportBean> beans=reportDao.findReportBeanWithCompany();
		return beans;
	}
	@Override
	public List<ReportBean> findReportUser() {
		// TODO Auto-generated method stub
		return reportDao.findReportBeanWithUser();
	}

}
