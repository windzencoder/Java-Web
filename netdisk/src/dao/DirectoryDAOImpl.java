package dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import common.UserInfo;
import dao.interfaces.DirectoryDAO;
import entity.DirInfo;
import entity.Directory;

public class DirectoryDAOImpl extends DAOSupport implements DirectoryDAO {

	//构造方法
	public DirectoryDAOImpl(HibernateTemplate template) {
		super(template);
	}

	@Override
	public void save(Directory directory) {
		template.save(directory);
	}

	@Override
	public void delete(UserInfo userInfo, String path) {
		//删除t_directories表中的指定用户和路劲记录
		template.bulkUpdate("delete from Directory where user = ? and path = ?", 
				new Object[] {userInfo.getCookieUser(), path});
		//删除t_directories表中的指定用户和路径的所有子目录的记录
		template.bulkUpdate("delete from Directory where user = ? and parentPath like ?", 
				new Object[] {userInfo.getCookieUser(), path+"%"});
	}

	@Override
	public List<DirInfo> getDirInfo(String user, String parentPath) {
		//通过调用p_dir_info获取指定用户和路径中的所有子目录的信息
		List<DirInfo> directories = template.findByNamedQueryAndNamedParam
				("myDirInfo", new String[] {"user", "parentPath"}, new Object[] {user, parentPath});
		return directories;
	}

}
