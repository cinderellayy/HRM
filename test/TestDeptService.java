import org.junit.Test;

import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;

public class TestDeptService {

	private DeptServiceImpl service = new DeptServiceImpl();
	
	@Test
	public void testInsert() throws Exception {
		DeptVo vo = new DeptVo("²ÍÒû²¿", "5Â¥");
		service.insert(vo);
	}
	
}
