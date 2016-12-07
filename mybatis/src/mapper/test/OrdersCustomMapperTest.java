package mapper.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mapper.OrderDetail;
import mapper.Orders;
import mapper.OrdersCustom;
import mapper.OrdersCustomMapper;

public class OrdersCustomMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}

	@Test
	public void testFindOrderUser() {
		SqlSession session = sqlSessionFactory.openSession();
		OrdersCustomMapper oc = session.getMapper(OrdersCustomMapper.class);
		List<OrdersCustom> list = oc.findOrdersUser();
		System.out.println(list);
		session.close();
	}
	
	// 查询订单，关联查询用户信息，使用resultMap实现的测试
    @Test
    public void TestFindOrdersUserResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersCustomMapper oc = sqlSession.getMapper(OrdersCustomMapper.class);
        // 调用mapper的方法
        List<Orders> list = oc.findOrdersUserResultMap();
        System.out.println(list);
        sqlSession.close();

    }
	
 // 查询订单（关联用户）以及订单明细的测试
    @Test
    public void TestFindOrdersAndOrderDetailResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersCustomMapper oc = sqlSession.getMapper(OrdersCustomMapper.class);
        // 调用mapper的方法
        List<OrderDetail> list = oc.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
        sqlSession.close();  
    }
    
}







