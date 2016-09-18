package mybatis.test2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestUser2 {

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
	public void test() {
	}
	
	@Test
	public void testAdd() {
		int insert = session.insert("mybatis.test2.userMapper.addUser", new User(-1, "xiaozhao", 23));
		session.commit();
		assertEquals(1, insert);
	}
	
	@Test
	public void testUpdate(){
		int update = session.update("mybatis.test2.userMapper.updateUser", new User(4, "xiaowang", 30));
		session.commit();
		assertEquals(1, update);
	}
	
	@Test
	public void testDelete(){
		int delete = session.delete("mybatis.test2.userMapper.deleteUser", 6);
		session.commit();
		assertEquals(1, delete);
	}

	@Test
	public void testGetUser(){
		User user = session.selectOne("mybatis.test2.userMapper.getUser", 1);
		session.commit();
		System.out.println(user);
	}
	
	@Test
	public void testGetAllUser(){
		List<User> users = session.selectList("mybatis.test2.userMapper.getAllUsers");
		session.commit();
		System.out.println(users);
	}
	
	
	
}
