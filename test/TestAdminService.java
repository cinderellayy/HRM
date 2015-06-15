import org.junit.Test;

import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;
import com.icss.hr.common.LoginStatus;


public class TestAdminService {
	
	private AdminServiceImpl service = new AdminServiceImpl();
	
	@Test
	public void testLogin() throws Exception {
		AdminVo vo = new AdminVo("admin", "admin", 1);
		LoginStatus loginStatus = service.login(vo);
		System.out.println(loginStatus);
	}	

}
