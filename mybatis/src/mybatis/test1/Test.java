package mybatis.test1;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) throws IOException{
		
		String resource = "Configuration.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql 的sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql 的标识字符串
		String statement = "mybatis.test1.userMapper"+".getUser";
		//执行查询返回一个唯一user 对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);

	}

}
