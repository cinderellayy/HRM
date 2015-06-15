import org.junit.Test;

import com.icss.hr.admin.dao.impl.AdminDaoImpl;
import com.icss.hr.admin.po.Admin;


public class TestAdminDao {

	private AdminDaoImpl dao = new AdminDaoImpl();
	
	@Test
	public void testQueryByName() throws Exception {
		Admin admin = dao.queryByName("tosdfsdfdsfm");
		System.out.println(admin);
	}
	
}
