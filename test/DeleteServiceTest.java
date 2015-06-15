import org.junit.Test;

import com.icss.hr.job.service.impl.JobServiceImpl;



public class DeleteServiceTest {
	JobServiceImpl j = new JobServiceImpl();
	@Test
	public void test() throws Exception{
		j.delete(22);
	}
}
