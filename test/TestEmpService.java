import java.sql.Date;

import org.junit.Test;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.dao.impl.EmpDaoImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.po.Job;

public class TestEmpService {

	private EmpServiceImpl service = new EmpServiceImpl();

	@Test
	public void testInsert() throws Exception {
		EmpVo vo = new EmpVo("rose", "rose@163.com", "13312345678", Date
				.valueOf("2011-11-11"), 100, 3900, 5);
		service.insert(vo);
	}
}