import java.sql.Date;

import org.junit.Test;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.dao.impl.EmpDaoImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.job.po.Job;

public class TestEmpDao {

	private EmpDaoImpl dao = new EmpDaoImpl();

	@Test
	public void testInsert() throws Exception {
		Job job = new Job();
		job.setJobId(100);

		Dept dept = new Dept();
		dept.setDeptId(6);

		Emp emp = new Emp("jack", "jack@163.com", "13912345678", Date
				.valueOf("2006-11-17"), job, 4700, dept);
		
		dao.insert(emp);
	}
}