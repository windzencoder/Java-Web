package entity;

/**
 * 用户实体Bean 而且作为struts2的模型类
 * @author Miller
 *	password表示用户输入的密码字符串，未加密
 *	repassword表示用户重新输入的密码，可以通过password属性和repassword校验两次输入的是否一致
 *	validationCode表示用户输入的验证码
 */
public class User {

	private String user;
	private String password;
	private String repassword;
	private String passwordMD5;
	private String xm;
	private String email;
	private String phone;
	private String qq;
	private String validationCode;

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPasswordMD5() throws Exception {
		return common.Encrypter.md5Encrypt(password);
	}

	public void setPasswordMD5(String passwordMD5) {
		this.passwordMD5 = passwordMD5;
	}

	public String toString() {
		return getUser();
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}
