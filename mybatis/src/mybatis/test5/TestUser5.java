package mybatis.test5;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis.bean.Order;
import mybatis.test2.User;

public class TestUser5 {

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
		mybatis.bean.Class clazz = session.selectOne("mybatis.test5.classMapper.getClass2", 1);
		System.out.println(clazz);
	}
	
	
}
