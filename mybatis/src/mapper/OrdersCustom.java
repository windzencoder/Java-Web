package mapper;

public class OrdersCustom extends Orders{

	private String username;
    private String sex;
    private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", sex=" + sex + ", address=" + address + ", getId()=" + getId()
				+ ", getUserid()=" + getUserid() + ", getNumber()=" + getNumber() + ", getCreateTime()="
				+ getCreateTime() + ", getNote()=" + getNote() + ", getUser()=" + getUser() + ", getOrderdetails()="
				+ getOrderdetails() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
    
	
}
