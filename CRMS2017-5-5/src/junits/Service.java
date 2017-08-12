package junits;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zy.crm.domain.Group;
import com.zy.crm.service.IGroupService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Service {
	
	@Autowired
    private IGroupService<Group> iGroupService;
	@Test
	public void TestGroupSerivceImpl(){
		Group g= new Group();
		g.setIncumbent("ս��");
		g.setName("���²�");
		g.setPrincipal("����");
		iGroupService.saveGroup(g);
	}
	
	@Test
	public void testDelete(){
		Serializable[] ids={21};
		iGroupService.deleteGroup(ids);
	}
	
//	
}
