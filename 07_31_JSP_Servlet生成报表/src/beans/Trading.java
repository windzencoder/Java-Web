package beans;

/*
 * 交易信息表
 */
public class Trading {
	//交易id
	private int trading_id;
	//商品id
	private int goods_id;
	//用户id
	private int user_id;
	//交易数量
	private int trading_number;
	public int getTrading_id() {
		return trading_id;
	}
	public void setTrading_id(int trading_id) {
		this.trading_id = trading_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTrading_number() {
		return trading_number;
	}
	public void setTrading_number(int trading_number) {
		this.trading_number = trading_number;
	}
	
	
	
}
