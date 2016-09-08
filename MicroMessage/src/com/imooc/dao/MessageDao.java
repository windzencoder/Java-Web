package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
import com.sun.xml.internal.ws.api.databinding.DatabindingConfig;

/*
 * 和Message相关的数据操作
 */
public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表，原来使用mybatis的实现方式
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			//通过sqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessageList", message);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/*
	 * 单条删除
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
		
			//通过sqlSession执行SQL语句
			sqlSession.selectList("Message.deleteOne", id);
			//提交事务
			sqlSession.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/*
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
		
			//通过sqlSession执行SQL语句
			sqlSession.selectList("Message.deleteBatch", ids);
			//提交事务
			sqlSession.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
	}
	
	/**
	 * 根据查询条件查询消息列表，原来使用jdbc的实现方式
	 */
	/*
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = new ArrayList<>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?characterEncoding=utf8", "root", "");
			StringBuilder sql = new StringBuilder("select ID, COMMAND, DESCRIPTION, CONTENT from message where 1=1");
			
			List<String> paramList = new ArrayList<>();
			if (command != null && !"".equals(command.trim())) {
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sql.append(" and DESCRIPTION like '%' ? '%' ");
				paramList.add(description);
			}

			PreparedStatement statement =  connection.prepareStatement(sql.toString());
			for(int i = 0; i < paramList.size(); i++){
				statement.setString(i+1, paramList.get(i));
			}
			
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return messageList;
		
	}
	*/
	
}
