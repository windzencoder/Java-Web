package mybatis.test7;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis.bean.ConditionUser;
import mybatis.test2.User;

public class TestUser7 {

	private SqlSession session;
	
	@Before
	public void before() throws IOException{
		String resource = "Configuration.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql 的sqlSession
		session = sessionFactory.openSession();
	}
	

	@Test
	public void testQuery() {
		
		ConditionUser param = new ConditionUser("%null%", 13, 18);
		List<mybatis.bean.User> users = session.selectList("mybatis.test7.userMapper.getUser", param);
		for (mybatis.bean.User user : users) {
			System.out.println(user);
		}
	}
	
	
}
