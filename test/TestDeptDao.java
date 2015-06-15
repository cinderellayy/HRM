import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.po.Dept;


/**
 * ���Բ���DAO
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	private DeptDaoImpl dao = new DeptDaoImpl();

	@Test
	public void testInsert() throws Exception {
		Dept dept = new Dept("�ɹ���","6¥");
		dao.insert(dept);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Dept dept = new Dept(2,"��Ʋ�","3¥");
		dao.update(dept);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	
	@Test
	public void testQueryById() throws Exception {
		Dept dept = dao.queryById(2);
		System.out.println(dept);
	}
	
	@Test
	public void testQuery() throws Exception {
		ArrayList<Dept> list = dao.query();
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}
}