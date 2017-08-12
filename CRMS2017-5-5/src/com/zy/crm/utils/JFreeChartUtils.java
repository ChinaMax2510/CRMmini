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
					dataset.setValue(bean.getCount(), "客户等级", bean.getType());//（对应Y坐标的值，图列，对应X坐标的值）
					}
			}
		
		
		
		org.jfree.chart.JFreeChart freeChart=ChartFactory.createBarChart3D("客户报表分析",
																								"客户等级", //X轴标题
																								"客户人数", //Y轴标题
																								dataset, //表数据
																								PlotOrientation.VERTICAL,//水平或者垂直---方向,一水平为列
																								true, 								//显示图列    图像表示的内容
																								true, 							//工具提示信息
																								true);							//url连接
		
		//表区域对象
	     CategoryPlot plot=(CategoryPlot) freeChart.getPlot();
	     //绘图区域
	   BarRenderer3D renderer3d=(BarRenderer3D)  plot.getRenderer();
	     //图形宽度
	   renderer3d.setMaximumBarWidth(0.07);
	   //图形上显示值
	   renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	   renderer3d.setBaseItemLabelsVisible(true);
	   renderer3d.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		
		/*************************************************************************************************************************************************/
		
		//设置编码类型
		       //主题编码类型
		      freeChart.getTitle().setFont(new Font("楷体", Font.BOLD, 25));
			//图列编码
		      freeChart.getLegend().setItemFont(new Font("楷体", Font.BOLD, 20));
		      
				                	//X
				                    CategoryAxis3D ca=(CategoryAxis3D)   plot.getDomainAxis();
								     ca.setTickLabelFont(new Font("楷体", Font.BOLD, 20));
								     ca.setLabelFont(new Font("楷体", Font.BOLD, 20));
								     //Y
								     NumberAxis3D na=(NumberAxis3D) plot.getRangeAxis();
								     na.setTickLabelFont(new Font("楷体", Font.BOLD, 20));//处理X轴上的乱码
								     na.setLabelFont(new Font("楷体", Font.BOLD, 20));//处理X外的乱码。
								     //设置刻度
								     na.setAutoTickUnitSelection(false);//制动刻度
								     NumberTickUnit unit=new NumberTickUnit(0.5);
								     na.setTickUnit(unit);
								     
/************************************************************************************************************************************************************/								     
		//生成图片
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
					dataset.setValue(bean.getCount(), "部门", bean.getType());//（对应Y坐标的值，图列，对应X坐标的值）
					}
			}
		
		
		
		org.jfree.chart.JFreeChart freeChart=ChartFactory.createBarChart3D("用户报表分析",
																								"部门", //X轴标题
																								"人数", //Y轴标题
																								dataset, //表数据
																								PlotOrientation.VERTICAL,//水平或者垂直---方向,一水平为列
																								true, 								//显示图列    图像表示的内容
																								true, 							//工具提示信息
																								true);							//url连接
		
		//表区域对象
	     CategoryPlot plot=(CategoryPlot) freeChart.getPlot();
	     //绘图区域
	   BarRenderer3D renderer3d=(BarRenderer3D)  plot.getRenderer();
	     //图形宽度
	   renderer3d.setMaximumBarWidth(0.07);
	   //图形上显示值
	   renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	   renderer3d.setBaseItemLabelsVisible(true);
	   renderer3d.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		
		/*************************************************************************************************************************************************/
		
		//设置编码类型
		       //主题编码类型
		      freeChart.getTitle().setFont(new Font("楷体", Font.BOLD, 25));
			//图列编码
		      freeChart.getLegend().setItemFont(new Font("楷体", Font.BOLD, 20));
		      
				                	//X
				                    CategoryAxis3D ca=(CategoryAxis3D)   plot.getDomainAxis();
								     ca.setTickLabelFont(new Font("楷体", Font.BOLD, 20));
								     ca.setLabelFont(new Font("楷体", Font.BOLD, 20));
								     //Y
								     NumberAxis3D na=(NumberAxis3D) plot.getRangeAxis();
								     na.setTickLabelFont(new Font("楷体", Font.BOLD, 20));//处理X轴上的乱码
								     na.setLabelFont(new Font("楷体", Font.BOLD, 20));//处理X外的乱码。
								     //设置刻度
								     na.setAutoTickUnitSelection(false);//制动刻度
								     NumberTickUnit unit=new NumberTickUnit(1);
								     na.setTickUnit(unit);
								     
/************************************************************************************************************************************************************/								     
		//生成图片
		String realPath=context.getRealPath("/temp");
		String fileName=DateFormatUtils.format(new Date(), "yyMMddHHmmss")+".jpeg";
		File file=new File(realPath,fileName);
		ChartUtilities.saveChartAsJPEG(file, freeChart, 1000, 500);
		request.setAttribute("filename", fileName);
		
	}



}
