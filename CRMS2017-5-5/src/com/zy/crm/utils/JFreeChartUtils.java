package com.zy.crm.utils;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.zy.crm.bean.ReportBean;

public class JFreeChartUtils {

	public static void generaBarJpegCompany(List<ReportBean> beans, HttpServletRequest request, ServletContext context) throws IOException {
		// TODO Auto-generated method stub
		
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		if(beans!=null&&beans.size()>0){
					for(ReportBean bean : beans){
					dataset.setValue(bean.getCount(), "�ͻ��ȼ�", bean.getType());//����ӦY�����ֵ��ͼ�У���ӦX�����ֵ��
					}
			}
		
		
		
		org.jfree.chart.JFreeChart freeChart=ChartFactory.createBarChart3D("�ͻ��������",
																								"�ͻ��ȼ�", //X�����
																								"�ͻ�����", //Y�����
																								dataset, //������
																								PlotOrientation.VERTICAL,//ˮƽ���ߴ�ֱ---����,һˮƽΪ��
																								true, 								//��ʾͼ��    ͼ���ʾ������
																								true, 							//������ʾ��Ϣ
																								true);							//url����
		
		//���������
	     CategoryPlot plot=(CategoryPlot) freeChart.getPlot();
	     //��ͼ����
	   BarRenderer3D renderer3d=(BarRenderer3D)  plot.getRenderer();
	     //ͼ�ο��
	   renderer3d.setMaximumBarWidth(0.07);
	   //ͼ������ʾֵ
	   renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	   renderer3d.setBaseItemLabelsVisible(true);
	   renderer3d.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));
		
		/*************************************************************************************************************************************************/
		
		//���ñ�������
		       //�����������
		      freeChart.getTitle().setFont(new Font("����", Font.BOLD, 25));
			//ͼ�б���
		      freeChart.getLegend().setItemFont(new Font("����", Font.BOLD, 20));
		      
				                	//X
				                    CategoryAxis3D ca=(CategoryAxis3D)   plot.getDomainAxis();
								     ca.setTickLabelFont(new Font("����", Font.BOLD, 20));
								     ca.setLabelFont(new Font("����", Font.BOLD, 20));
								     //Y
								     NumberAxis3D na=(NumberAxis3D) plot.getRangeAxis();
								     na.setTickLabelFont(new Font("����", Font.BOLD, 20));//����X���ϵ�����
								     na.setLabelFont(new Font("����", Font.BOLD, 20));//����X������롣
								     //���ÿ̶�
								     na.setAutoTickUnitSelection(false);//�ƶ��̶�
								     NumberTickUnit unit=new NumberTickUnit(0.5);
								     na.setTickUnit(unit);
								     
/************************************************************************************************************************************************************/								     
		//����ͼƬ
		String realPath=context.getRealPath("/temp");
		String fileName=DateFormatUtils.format(new Date(), "yyMMddHHmmss")+".jpeg";
		File file=new File(realPath,fileName);
		ChartUtilities.saveChartAsJPEG(file, freeChart, 1000, 500);
		request.setAttribute("filename", fileName);
		
	}


	public static void generaBarJpegUser(List<ReportBean> beans, HttpServletRequest request, ServletContext context) throws IOException {
		// TODO Auto-generated method stub
		
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		if(beans!=null&&beans.size()>0){
					for(ReportBean bean : beans){
					dataset.setValue(bean.getCount(), "����", bean.getType());//����ӦY�����ֵ��ͼ�У���ӦX�����ֵ��
					}
			}
		
		
		
		org.jfree.chart.JFreeChart freeChart=ChartFactory.createBarChart3D("�û��������",
																								"����", //X�����
																								"����", //Y�����
																								dataset, //������
																								PlotOrientation.VERTICAL,//ˮƽ���ߴ�ֱ---����,һˮƽΪ��
																								true, 								//��ʾͼ��    ͼ���ʾ������
																								true, 							//������ʾ��Ϣ
																								true);							//url����
		
		//���������
	     CategoryPlot plot=(CategoryPlot) freeChart.getPlot();
	     //��ͼ����
	   BarRenderer3D renderer3d=(BarRenderer3D)  plot.getRenderer();
	     //ͼ�ο��
	   renderer3d.setMaximumBarWidth(0.07);
	   //ͼ������ʾֵ
	   renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	   renderer3d.setBaseItemLabelsVisible(true);
	   renderer3d.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));
		
		/*************************************************************************************************************************************************/
		
		//���ñ�������
		       //�����������
		      freeChart.getTitle().setFont(new Font("����", Font.BOLD, 25));
			//ͼ�б���
		      freeChart.getLegend().setItemFont(new Font("����", Font.BOLD, 20));
		      
				                	//X
				                    CategoryAxis3D ca=(CategoryAxis3D)   plot.getDomainAxis();
								     ca.setTickLabelFont(new Font("����", Font.BOLD, 20));
								     ca.setLabelFont(new Font("����", Font.BOLD, 20));
								     //Y
								     NumberAxis3D na=(NumberAxis3D) plot.getRangeAxis();
								     na.setTickLabelFont(new Font("����", Font.BOLD, 20));//����X���ϵ�����
								     na.setLabelFont(new Font("����", Font.BOLD, 20));//����X������롣
								     //���ÿ̶�
								     na.setAutoTickUnitSelection(false);//�ƶ��̶�
								     NumberTickUnit unit=new NumberTickUnit(1);
								     na.setTickUnit(unit);
								     
/************************************************************************************************************************************************************/								     
		//����ͼƬ
		String realPath=context.getRealPath("/temp");
		String fileName=DateFormatUtils.format(new Date(), "yyMMddHHmmss")+".jpeg";
		File file=new File(realPath,fileName);
		ChartUtilities.saveChartAsJPEG(file, freeChart, 1000, 500);
		request.setAttribute("filename", fileName);
		
	}



}
