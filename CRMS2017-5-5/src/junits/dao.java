package junits;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zy.crm.dao.ISysGroupDao;
import com.zy.crm.dao.IUserDao;
import com.zy.crm.daoimpl.SysGroupDaoImpl;
import com.zy.crm.domain.Group;
import com.zy.crm.domain.Role;
import com.zy.crm.domain.User;
import com.zy.crm.service.IGroupService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class dao {
	
	@Test
	public void HibernateTest(){
		Configuration con=new Configuration();
		con.configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tran= session.beginTransaction();
		Group g=new Group();
		g.setIncumbent("开发");
		g.setPrincipal("张经理");
		g.setName("开发部");
		g.setRemark("xx");
		session.save(g);
		tran.commit();
		session.close();
	}
	
	@Autowired
	private ISysGroupDao iSysGroupDao;
	
	@Test
	public void testSave(){
		Group g= new Group();
		g.setIncumbent("开发");
		g.setName("开发部");
		g.setPrincipal("王经理");
//		//GroupSerivceImpl.saveGroup(g);
//		ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
//		ISysGroupDao sysGroupDaoImpl=(ISysGroupDao)application.getBean(SysGroupDaoImpl.GDao_name);
//		sysGroupDaoImpl.save(g);
		
		iSysGroupDao.save(g);
	}
	@Test
	public void testFindById(){
			Serializable id=21;
			Group group = iSysGroupDao.findById(id);
			System.out.println(group);
	}
	@Test
	public void testDelete(){
		Serializable[] ids={23,24};
		iSysGroupDao.delete(ids);
	}
	@Test
	public void testUpdate(){
		Group g=new Group();
		g.setId(21);
		g.setIncumbent("产品研发");
		g.setName("研发部");
		g.setPrincipal("黎明");
		g.setRemark("*********");
		iSysGroupDao.update(g);
	}
	@Test
	public void testDeleteAll(){
		List<Group> list=new ArrayList<Group>();
		Group g=new Group();
		g.setId(21);
		g.setIncumbent("产品研发");
		g.setName("研发部");
		g.setPrincipal("黎明");
		g.setRemark("*********");
		Group G1=new Group();
		G1.setId(22);
		G1.setName("销售部");
		list.add(g);
		//list.add(G1);
		
		iSysGroupDao.deleteAll(list);
	}
	
	@Autowired
	private IUserDao userdao;
	@Test
	public void testUserSave(){
		
		User entity=new User();
		Group g=new Group();
		Role r=new Role();
		r.setId("402881e43250ee0b013250eeb9b80001");
		g.setId(21);
		entity.setName("白嘉轩");
		entity.setGroup(g);
		entity.setRole(r);
		userdao.save(entity);
	}
	
	public static void main(String[] args) {
		
	}
	

	


}
