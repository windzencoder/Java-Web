package dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class DAOSupport {

	protected HibernateTemplate template;
	
	/*
	 * 通过Spring注入的方式传入HibernateTemplate对象
	 */
	public DAOSupport(HibernateTemplate template) {
		this.template = template;
	}
	
}
