package com.yi.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.DAO.MovieDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;
import com.yi.mvc.CommandHandler;

public class TimetableHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCUtil.getConnection();
			MovieDAO dao = MovieDAO.getInstance();
			List<Movie> list = dao.list(conn);
			req.setAttribute("list", list);

			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		
	
		return "/WEB-INF/view/movieTime.jsp";
	}
	}


