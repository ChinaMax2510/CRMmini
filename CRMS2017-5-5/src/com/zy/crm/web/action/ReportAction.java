package com.zy.crm.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.zy.crm.bean.ReportBean;
import com.zy.crm.container.ServiceProvider;
import com.zy.crm.container.ServiceProviderCore;
import com.zy.crm.dao.IReportDao;
import com.zy.crm.service.ICompanyService;
import com.zy.crm.service.IReportService;
import com.zy.crm.utils.JFreeChartUtils;

public class ReportAction extends BeansAction {
	
	IReportService reportService=(IReportService) ServiceProvider.getService("ReportServiceImpl");
	
	public String khflfx() throws IOException{
		List<ReportBean>beans= reportService.findReportCompany();
		long count = 0;
		for(ReportBean bean : beans){
			count+=bean.getCount();
		}
		//Éú³ÉÖù×´Í¼
		ServletContext context=ServletActionContext.getServletContext();
		JFreeChartUtils.generaBarJpegCompany(beans,request,context);
		
		this.request.setAttribute("sum", count);
		this.request.setAttribute("reportBeans", beans);
		return "report";
	}
	public String usersReport() throws IOException{
		List<ReportBean> beans  =reportService.findReportUser();
		long count=0;
		for(ReportBean bean : beans){
			count+=bean.getCount();
		}
		ServletContext context=ServletActionContext.getServletContext();
		JFreeChartUtils.generaBarJpegUser(beans, request, context);
		this.request.setAttribute("sum", count);
		this.request.setAttribute("reportBeans", beans);
		return "usersreport";
	}

}
