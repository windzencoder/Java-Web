package mapper;

import java.util.List;

public interface OrdersCustomMapper {

	public List<OrdersCustom> findOrdersUser();
	
	public List<Orders> findOrdersUserResultMap();
	
    public List<OrderDetail>findOrdersAndOrderDetailResultMap();


	
}
