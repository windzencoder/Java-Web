package mybatis.test3;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis.test2.User;

public class TestUser3 {

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
	public void testAddAnnotation() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "xiaoqian", 23));
		session.commit();
		System.out.println(add);
	}
	
	
}
