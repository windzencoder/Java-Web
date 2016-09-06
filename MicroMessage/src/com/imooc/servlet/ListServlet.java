package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;

/**
 * 列表页面初始化控制
 * @author Miller
 *
 */
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			req.setCharacterEncoding("UTF-8");
			String command = req.getParameter("command");
			String description = req.getParameter("description");
			
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
			List<Message> messageList = new ArrayList<>();
			while(rs.next()){
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}
			req.setAttribute("messageList", messageList);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
